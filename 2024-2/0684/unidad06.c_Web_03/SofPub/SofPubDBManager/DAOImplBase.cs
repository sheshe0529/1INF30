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

        protected BindingList<Object> listarTodos(int? limite)
        {
            BindingList<Object> lista = new BindingList<Object>();
            this.comando = new MySqlCommand();
            try
            {
                this.abrirConexion();
                string sql = this.generarSQLParaListarTodos(limite);
                this.Comando.Connection = this.Conexion;
                this.Comando.CommandType = System.Data.CommandType.Text;
                this.Comando.CommandText = sql;
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
    }
}
