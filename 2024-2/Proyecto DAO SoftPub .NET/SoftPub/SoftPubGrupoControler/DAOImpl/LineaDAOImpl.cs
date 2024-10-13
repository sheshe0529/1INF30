using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SoftPubDBManager;
using SoftPubGrupoControler.DAO;
using SoftPubGrupoModel;

namespace SoftPubGrupoControler.DAOImpl
{
    public class LineaDAOImpl : DAOImplBase, LineaDAO
    { 
        private Linea linea;
        private string sql_filtro;

        public LineaDAOImpl() : base("Linea")
        {
            this.sql_filtro = null;
        }

        public BindingList<Object> listarPorGrupo(int? idGrupo)
        {
            this.linea = new Linea();
            this.linea.Grupo = new Grupo();
            this.linea.Grupo.IdGrupo = idGrupo;

            this.sql_filtro = " where idGrupo=@idGrupo ";
            BindingList<Object> lista = this.listarTodos();
            this.sql_filtro = null;
            return lista;
        }

        public BindingList<Object> listarTodos()
        {
            return base.listarTodos(null);
        }

        protected override string obtenerPredicadoParaListarTodos()
        {
            if (this.sql_filtro != null)
                return this.sql_filtro;
            return "";
        }

        protected override void onListarTodosDespuesDeColocarComandoSQL()
        {
            this.Comando.Parameters.AddWithValue("@idGrupo", this.linea.Grupo.IdGrupo);
        }

        protected override void agregarObjetoALaLista(BindingList<Object> lista, MySqlDataReader lector)
        {
            this.instanciarObjetoDelResultSet(this.Lector);
            lista.Add(this.linea);
        }

        Linea LineaDAO.obtenerPorId(int idGrupo, int idLinea)
        {
            Grupo grupo = new Grupo();
            grupo.IdGrupo = idGrupo;

            this.linea = new Linea();
            this.linea.IdLinea = idLinea;                
            this.linea.Grupo = grupo;

            base.obtenerPorId();
            return this.linea;
        }

        protected override string obtenerProyeccionParaSelect()
        {
            return "idGrupo, idLinea, nombre";
        }

        protected override void instanciarObjetoDelResultSet(MySqlDataReader lector)
        {
            this.linea = new Linea();
            this.linea.IdLinea = this.Lector.GetInt32("idLinea");
            this.linea.Nombre = this.Lector.GetString("nombre");            
        }

        protected override string obtenerPredicadoParaLlavePrimaria()
        {
            return "idGrupo=@idGrupo and idLinea=@idLinea";
        }

        protected override void incluirValorParametrosParaObtenerPorId()
        {
            this.Comando.Parameters.AddWithValue("@idGrupo", this.linea.Grupo.IdGrupo);
            this.Comando.Parameters.AddWithValue("@idLinea", this.linea.IdLinea);
        }

        protected override void limpiarObjetoDelResultSet()
        {
            this.linea = null;
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
