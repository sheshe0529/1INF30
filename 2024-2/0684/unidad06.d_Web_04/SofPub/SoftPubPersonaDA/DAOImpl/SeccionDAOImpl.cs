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

        protected override string obtenerListaDeAtributosParaInsertar()
        {
            return "idSeccion, seccion, departamento";
        }

        protected override string incluirListaDeParametrosParaInsertar()
        {
            return "@idSeccion, @seccion, @departamento";
        }

        protected override void incluirValorParametroParaInsercion()
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

        protected override string obtenerListaDeAtributosParaModificacion()
        {
            return "seccion=@seccion, departamento=@departamento";
        }

        protected override string obtenerPredicadoParaLlavePrimaria()
        {
            return "idSeccion=@idSeccion";
        }

        protected override void incluirValorParametroParaModificacion()
        {
            this.Comando.Parameters.AddWithValue("@idSeccion", this.seccion.IdSeccion);
            this.Comando.Parameters.AddWithValue("@seccion", this.seccion.Nombre_seccion);
            this.Comando.Parameters.AddWithValue("@departamento", this.seccion.Departamento);
        }

        public int eliminar(Seccion seccion)
        {
            this.seccion = seccion;
            return base.eliminar();
        }

        protected override void incluirValorParametroParaEliminacion()
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
