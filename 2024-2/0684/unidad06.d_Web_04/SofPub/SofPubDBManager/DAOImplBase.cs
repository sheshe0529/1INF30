using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace SofPubDBManager
{
    public abstract class DAOImplBase
    {
        private string nombre_tabla;
        private MySqlConnection conexion;
        private MySqlTransaction transaccion;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        private bool mostrarSentenciaSQL;
        private bool retornarLlavePrimaria;
        private bool usarTransaccion;

        protected string Nombre_tabla { get => nombre_tabla; set => nombre_tabla = value; }
        protected MySqlConnection Conexion { get => conexion; set => conexion = value; }
        protected MySqlTransaction Transaccion { get => transaccion; set => transaccion = value; }
        protected MySqlCommand Comando { get => comando; set => comando = value; }
        protected MySqlDataReader Lector { get => lector; set => lector = value; }
        protected bool MostrarSentenciaSQL { get => mostrarSentenciaSQL; set => mostrarSentenciaSQL = value; }
        protected bool RetornarLlavePrimaria { get => retornarLlavePrimaria; set => retornarLlavePrimaria = value; }
        protected bool UsarTransaccion { get => usarTransaccion; set => usarTransaccion = value; }

        protected DAOImplBase(string nombre_tabla)
        {
            Nombre_tabla = nombre_tabla;
            Conexion = null;
            Transaccion = null;
            Comando = null;
            Lector = null;
            MostrarSentenciaSQL = true;
            RetornarLlavePrimaria = false;
            UsarTransaccion = true;
        }

        protected void iniciarTransaccion()
        {
            this.abrirConexion();
            this.Transaccion = this.Conexion.BeginTransaction();
        }

        protected void comitarTransaccion()
        {
            this.Transaccion.Commit();
            this.Transaccion = null;
        }

        protected void rollbackTransaccion()
        {
            if (this.Transaccion != null)
                this.Transaccion.Rollback();
            this.Transaccion = null;
        }

        protected void abrirConexion()
        {
            this.Conexion = DBManager.Instance.Conexion;
            this.Conexion.Open();
        }

        protected void cerrarConexion()
        {
            if (this.Conexion != null)
            {
                this.Conexion.Close();
            }
        }

        protected void colocarSQLenComando(string sql)
        {
            this.Comando.Connection = this.Conexion;
            this.Comando.CommandType = System.Data.CommandType.Text;
            this.Comando.CommandText = sql;
        }

        private int ejecuta_DML(Tipo_Operacion tipo_operacion)
        {
            int resultado = 0;
            try
            {
                if (this.usarTransaccion)
                    this.iniciarTransaccion();
                this.Comando = new MySqlCommand();
                string sql = "";
                switch (tipo_operacion)
                {
                    case Tipo_Operacion.INSERTAR:
                        sql = this.generaSQLParaInsercion();
                        break;
                    case Tipo_Operacion.MODIFICAR:
                        sql = this.generaSQLParaModificacion();
                        break;
                    case Tipo_Operacion.ELIMINAR:
                        sql = this.generaSQLParaEliminacion();
                        break;
                }
                this.colocarSQLenComando(sql);
                switch (tipo_operacion)
                {
                    case Tipo_Operacion.INSERTAR:
                        this.incluirValorParametroParaInsercion();
                        break;
                    case Tipo_Operacion.MODIFICAR:
                        this.incluirValorParametroParaModificacion();
                        break;
                    case Tipo_Operacion.ELIMINAR:
                        this.incluirValorParametroParaEliminacion();
                        break;
                }
                this.Comando.ExecuteNonQuery();
                if (this.retornarLlavePrimaria)
                {
                    int id = this.retormarUltimoIdAutoGenerado();
                    resultado = id;
                }
                if (this.usarTransaccion)
                    this.comitarTransaccion();
            }
            catch (Exception ex)
            {
                if (this.usarTransaccion)
                    this.rollbackTransaccion();
                throw new Exception(ex.Message);
            }
            finally
            {
                this.cerrarConexion();
            }
            return resultado;
        }

        private string generaSQLParaInsercion()
        {
            string sql = "insert into ";
            sql += this.Nombre_tabla;
            sql += " (";
            sql += this.obtenerListaDeAtributosParaInsertar();
            sql += ") values (";
            sql += this.incluirListaDeParametrosParaInsertar();
            sql += ")";
            return sql;
        }
        protected abstract string incluirListaDeParametrosParaInsertar();

        protected abstract string obtenerListaDeAtributosParaInsertar();

        private string generaSQLParaModificacion()
        {
            string sql = "update ";
            sql += this.Nombre_tabla;
            sql += " set ";
            sql += this.obtenerListaDeAtributosParaModificacion();
            sql += " where ";
            sql += this.obtenerPredicadoParaLlavePrimaria();
            return sql;
        }
        protected abstract string obtenerPredicadoParaLlavePrimaria();

        protected abstract string obtenerListaDeAtributosParaModificacion();

        private string generaSQLParaEliminacion()
        {
            string sql = "delete from ";
            sql += this.Nombre_tabla;
            sql += " where ";
            sql += this.obtenerPredicadoParaLlavePrimaria();
            return sql;
        }

        protected abstract void incluirValorParametroParaInsercion();

        protected abstract void incluirValorParametroParaModificacion();

        protected abstract void incluirValorParametroParaEliminacion();

        protected int insertar()
        {
            return this.ejecuta_DML(Tipo_Operacion.INSERTAR);
        }

        protected int modificar()
        {
            return this.ejecuta_DML(Tipo_Operacion.MODIFICAR);
        }

        protected int eliminar()
        {
            return this.ejecuta_DML(Tipo_Operacion.ELIMINAR);
        }

        protected BindingList<Object> listarTodos(int? limite)
        {
            BindingList<Object> lista = new BindingList<Object>();
            this.comando = new MySqlCommand();
            try
            {
                this.abrirConexion();
                string sql = this.generarSQLParaListarTodos(limite);
                this.colocarSQLenComando(sql);
                this.Lector = this.Comando.ExecuteReader();
                while (this.Lector.Read())
                {
                    this.agregarObjetoALaLista(lista, this.Lector);
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                this.cerrarConexion();
            } 
            return lista;
        }
        private string generarSQLParaListarTodos(int? limite)
        {
            string sql = "select ";
            sql += this.obtenerProyeccionParaSelect();
            sql += " from " + this.Nombre_tabla;
            if (!(limite is null) && limite > 0)
            {
                sql += " limite " + limite.ToString();
            }
            return sql;
        }

        protected abstract string obtenerProyeccionParaSelect();

        protected abstract void agregarObjetoALaLista(BindingList<object> lista, MySqlDataReader lector);

        private int retormarUltimoIdAutoGenerado()
        {
            throw new NotImplementedException();
        }
    }
}
