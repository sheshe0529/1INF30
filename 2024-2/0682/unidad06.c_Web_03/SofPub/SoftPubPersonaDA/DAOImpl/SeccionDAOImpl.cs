using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SofPubDBManager;
using SoftPubPersonaDA.DAO;
using SoftPubPersonaModel;

namespace SoftPubPersonaDA.DAOImpl
{
    public class SeccionDAOImpl : DAOImplBase, SeccionDAO
    {
        private Seccion seccion;

        public SeccionDAOImpl() : base("seccion")
        {
            this.seccion = null;
        }

        public int insertar(Seccion seccion)
        {
            this.seccion = seccion;
            return base.insertar();
        }

        protected override string obtenerListaAtributosParaInsercion()
        {
            return "idSeccion, seccion, departamento";
        }

        protected override string obtenerListaParametrosParaInsercion()
        {
            return "@idSeccion, @seccion, @departamento";
        }

        protected override void incluirValorParametrosParaInsercion()
        {
            this.Comando.Parameters.AddWithValue("@idSeccion", this.seccion.IdSeccion);
            this.Comando.Parameters.AddWithValue("@seccion", this.seccion.Nombre_seccion);
            this.Comando.Parameters.AddWithValue("@departamento", this.seccion.Departamento);
        }

        public int modificar(Seccion seccion)
        {
            this.seccion = seccion;
            return base.modificar();
        }

        protected override string obtenerListaAtributosParaModificacion()
        {
            return "seccion=@seccion, departamento=@departamento";
        }

        protected override void incluirValorParametrosParaModificacion()
        {
            this.Comando.Parameters.AddWithValue("@idSeccion", this.seccion.IdSeccion);
            this.Comando.Parameters.AddWithValue("@seccion", this.seccion.Nombre_seccion);
            this.Comando.Parameters.AddWithValue("@departamento", this.seccion.Departamento);
        }

        protected override string obtenerPredicadoParaLlavePrimaria()
        {
            return "idSeccion=@idSeccion";
        }

        public int eliminar(Seccion seccion)
        {
            this.seccion = seccion;
            return base.eliminar();
        }

        protected override void incluirValorParametrosParaEliminacion()
        {
            this.Comando.Parameters.AddWithValue("@idSeccion", this.seccion.IdSeccion);
        }

        public BindingList<object> listarTodos()
        {
            return base.listarTodos(null);
        }

        protected override string obtenerProyeccionParaSelect()
        {
            return "idSeccion, seccion, departamento";
        }

        protected override void agregarObjetoALaLista(BindingList<object> lista, MySqlDataReader lector)
        {
            Seccion seccion = new Seccion();
            seccion.IdSeccion = lector.GetString("idSeccion");
            seccion.Nombre_seccion = lector.GetString("seccion");
            seccion.Departamento = lector.GetString("departamento");
            lista.Add(seccion);
        }                              
    }
}
