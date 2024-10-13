using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SoftPubDBManager;
using SoftPubGrupoControler.DAO;
using SoftPubGrupoModel;

namespace SoftPubGrupoControler.DAOImpl
{
    public class GrupoDAOImpl : DAOImplBase, GrupoDAO
    {
        private Grupo grupo;
        private string sql_filtro;

        public GrupoDAOImpl() : base("Grupo")
        {
            this.sql_filtro = null;
        }

        public int? insertar(Grupo grupo)
        {
            int? resultado = null;
            this.Comando = new MySqlCommand();
            try
            {
                this.abrirConexion();
                this.Comando.Connection = this.Conexion;
                this.Comando.CommandText = "INSERTAR_GRUPO";
                this.Comando.CommandType = System.Data.CommandType.StoredProcedure;
                this.Comando.Parameters.AddWithValue("pi_nombre", grupo.Nombre);
                this.Comando.Parameters.AddWithValue("pi_sigla", grupo.Sigla);
                this.Comando.Parameters.Add("ps_idGrupo", MySqlDbType.Int32).Direction
                    = System.Data.ParameterDirection.Output;
                this.Comando.ExecuteNonQuery();
                grupo.IdGrupo = Int32.Parse(
                    this.Comando.Parameters["ps_idGrupo"].Value.ToString());
                resultado = grupo.IdGrupo;                
            }
            catch (Exception ex)
            {                
                throw new Exception(ex.Message);
            }
            finally
            {
                this.cerrarConexion();
            }
            return resultado;
        }

        public BindingList<Object> listarGruposConProduccion(string nombre)
        {
            BindingList<Object> lista = new BindingList<Object>();
            this.Comando = new MySqlCommand();
            try
            {
                this.abrirConexion();
                string sql = "select g.idGrupo, g.nombre as nombre_grupo, l.idLinea, l.nombre as nombre_linea, count(p.idPublicacion) as cantidad_productos ";
                sql += "from grupo g ";
                sql += "join linea l on g.idGrupo = l.idGrupo ";
                sql += "left ";
                sql += "join productos_x_linea p on p.idGrupo = l.idGrupo and p.idLinea = l.idLinea ";
                if (nombre != null && nombre != ""){
                    sql += "where  g.nombre like %" + nombre + "% ";
                }
                sql += "group by g.idGrupo, g.nombre, l.idLinea, l.nombre";
                this.colocarSQLenComando(sql);
                this.ejecutarConsultaEnBD(sql);
                while (this.Lector.Read())
                {
                    Grupo grupo = new Grupo();
                    grupo.IdGrupo = this.Lector.GetInt32("idGrupo");
                    grupo.Nombre = this.Lector.GetString("nombre_grupo");

                    Linea linea = new Linea();
                    linea.IdLinea = this.Lector.GetInt32("idLinea");
                    linea.Nombre = this.Lector.GetString("nombre_linea");
                    linea.Cantidad_productos = this.Lector.GetInt32("cantidad_productos");
                    grupo.Lineas.Add(linea);

                    lista.Add(grupo);
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

        public BindingList<Object> listarGruposConProduccion()
        {
            return this.listarGruposConProduccion(null);
        }

        public BindingList<Object> listarTodos()
        {
            return base.listarTodos(null);
        }

        protected override void agregarObjetoALaLista(BindingList<Object> lista, MySqlDataReader lector)
        {
            this.instanciarObjetoDelResultSet(this.Lector);
            lista.Add(this.grupo);
        }

        Grupo GrupoDAO.obtenerPorId(int idGrupo)
        {
            this.grupo = new Grupo();
            this.grupo.IdGrupo = idGrupo;
            base.obtenerPorId();
            return this.grupo;
        }

        protected override string obtenerProyeccionParaSelect()
        {
            return "idGrupo, nombre, sigla";
        }

        protected override string obtenerPredicadoParaListarTodos()
        {
            if (this.sql_filtro != null)
                return this.sql_filtro;
            return "";
        }

        protected override void instanciarObjetoDelResultSet(MySqlDataReader lector)
        {
            this.grupo = new Grupo();
            this.grupo.IdGrupo = this.Lector.GetInt32("idGrupo");
            this.grupo.Nombre = this.Lector.GetString("nombre");
            this.grupo.Sigla = this.Lector.GetString("sigla");
        }

        public BindingList<Object> buscarGrupos(string nombre)
        {
            if (nombre != null && nombre != "")
                this.sql_filtro = " where nombre like \"%" + nombre + "%\"";
            BindingList<Object> lista = this.listarTodos();
            this.sql_filtro = null;
            return lista;
        }

        protected override string obtenerPredicadoParaLlavePrimaria()
        {
            return "idGrupo=@idGrupo";
        }

        protected override void incluirValorParametrosParaObtenerPorId()
        {
            this.Comando.Parameters.AddWithValue("@idGrupo", this.grupo.IdGrupo);
        }

        protected override void limpiarObjetoDelResultSet()
        {
            this.grupo = null;
        }

        protected override string incluirListaParametrosParaInsercion()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametrosParaEliminacion()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametrosParaInsercion()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametrosParaModificacion()
        {
            throw new NotImplementedException();
        }

        protected override string obtenerListaAtributosParaInsercion()
        {
            throw new NotImplementedException();
        }

        protected override string obtenerListaAtributosParaModificacion()
        {
            throw new NotImplementedException();
        }
    }
}
