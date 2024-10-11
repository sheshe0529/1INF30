using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SoftPubDBManager;
using SoftPubPublicacionControler.DAO;
using SoftPubPublicacionModel;

namespace SoftPubPublicacionControler.DAOImpl
{
    public class PublicacionDAOImpl : DAOImplBase, PublicacionDAO
    {
        Publicacion publicacion;
        private string sql_filtro;

        public PublicacionDAOImpl() : base("publicacion")
        {
            this.publicacion = null;
            this.sql_filtro = null;
        }

        public BindingList<Object> listarTodos()
        {
            return base.listarTodos(null);
        }

        protected override void agregarObjetoALaLista(BindingList<Object> lista, MySqlDataReader lector)
        {
            this.instanciarObjetoDelResultSet(this.Lector);
            lista.Add(this.publicacion);
        }

        Publicacion PublicacionDAO.obtenerPorId(int idPublicacion)
        {
            this.publicacion = new Publicacion();
            this.publicacion.IdPublicacion = idPublicacion;
            base.obtenerPorId();
            return this.publicacion;
        }
        protected override string obtenerProyeccionParaSelect()
        {
            return "idPublicacion, titulo, tipo, origen, volumen, numero, paginaInicio, paginaFin, fechaPublicacion, DOI, ISSN, ISBN, edicion, lugar, editorial, departamento, institucion, ciudad, estado";
        }

        protected override string obtenerPredicadoParaListarTodos()
        {
            if (this.sql_filtro != null)
                return this.sql_filtro;
            return "";
        }

        protected override void instanciarObjetoDelResultSet(MySqlDataReader lector)
        {
            this.publicacion = new Publicacion();
            this.publicacion.IdPublicacion = this.Lector.GetInt32("idPublicacion");
            this.publicacion.Titulo = this.Lector.GetString("titulo");            
            this.publicacion.Tipo = (Tipo)Enum.Parse(typeof(Tipo), lector.GetString("tipo"));
        }

        public BindingList<Object> buscarPublicacion(string titulo)
        {
            if (titulo != null && titulo != "")
                this.sql_filtro = " where titulo like \"%" + titulo + "%\"";
            BindingList<Object> lista = this.listarTodos();
            this.sql_filtro = null;
            return lista;
        }

        protected override string obtenerPredicadoParaLlavePrimaria()
        {
            return "idPublicacion=@idPublicacion";
        }

        protected override void incluirValorParametrosParaObtenerPorId()
        {
            this.Comando.Parameters.AddWithValue("@idPublicacion", this.publicacion.IdPublicacion);
        }

        protected override void limpiarObjetoDelResultSet()
        {
            this.publicacion = null;
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
