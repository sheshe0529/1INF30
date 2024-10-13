using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SoftPubDBManager;
using SoftPubPersonaControler.DAO;
using SoftPubPersonaModel;

namespace SoftPubPersonaControler.DAOImpl
{
    public class EspecialidadDAOImpl : DAOImplBase, EspecialidadDAO
    {
        private Especialidad especialidad;

        public EspecialidadDAOImpl() : base("Especialidad")
        {
            this.especialidad = new Especialidad();
        }

        public int insertar(Especialidad especialidad)
        {
            this.especialidad = especialidad;
            return base.insertar();
        }

        protected override string obtenerListaAtributosParaInsercion()
        {
            return "idEspecialidad, especialidad, facultad, nivel";
        }

        protected override string incluirListaParametrosParaInsercion()
        {
            return "@idEspecialidad, @especialidad, @facultad, @nivel";
        }

        protected override void incluirValorParametrosParaInsercion()
        {
            this.Comando.Parameters.AddWithValue("@idEspecialidad", this.especialidad.IdEspecialidad);
            this.Comando.Parameters.AddWithValue("@especialidad", this.especialidad.Nombre_especialidad);
            this.Comando.Parameters.AddWithValue("@facultad", this.especialidad.Facultad);
            this.Comando.Parameters.AddWithValue("@nivel", this.especialidad.Nivel.ToString());
        }

        public int modificar(Especialidad especialidad)
        {
            this.especialidad = especialidad;
            return base.modificar();
        }

        protected override string obtenerListaAtributosParaModificacion()
        {
            return "especialidad=@especialidad, facultad=@facultad, nivel=@nivel";
        }

        protected override void incluirValorParametrosParaModificacion()
        {
            this.Comando.Parameters.AddWithValue("@idEspecialidad", this.especialidad.IdEspecialidad);
            this.Comando.Parameters.AddWithValue("@especialidad", this.especialidad.Nombre_especialidad);
            this.Comando.Parameters.AddWithValue("@facultad", this.especialidad.Facultad);
            this.Comando.Parameters.AddWithValue("@nivel", this.especialidad.Nivel.ToString());
        }        

        public int eliminar(Especialidad especialidad)
        {
            this.especialidad = especialidad;
            return base.eliminar();
        }

        protected override string obtenerPredicadoParaLlavePrimaria()
        {
            return "idEspecialidad = @idEspecialidad";
        }

        protected override void incluirValorParametrosParaEliminacion()
        {
            this.Comando.Parameters.AddWithValue("@idEspecialidad", this.especialidad.IdEspecialidad);
        }

        public BindingList<object> listarTodos()
        {
            return base.listarTodos(null);
        }

        protected override string obtenerProyeccionParaSelect()
        {
            return "idEspecialidad, especialidad, facultad, nivel";
        }

        protected override void agregarObjetoALaLista(BindingList<object> lista, MySqlDataReader lector)
        {
            this.instanciarObjetoDelResultSet(this.Lector);
            lista.Add(especialidad);
        }

        public Especialidad obtenerPorId(int idEspecialidad)
        {
            Especialidad especialidad = new Especialidad();
            especialidad.IdEspecialidad = idEspecialidad;
            this.especialidad = especialidad;
            base.obtenerPorId();
            return this.especialidad;
        }

        protected override void incluirValorParametrosParaObtenerPorId()
        {
            this.Comando.Parameters.AddWithValue("@idEspecialidad", this.especialidad.IdEspecialidad);
        }

        protected override void instanciarObjetoDelResultSet(MySqlDataReader lector)
        {
            this.especialidad = new Especialidad();
            this.especialidad.IdEspecialidad = lector.GetInt32("idEspecialidad");
            this.especialidad.Nombre_especialidad = lector.GetString("especialidad");
            this.especialidad.Facultad = lector.GetString("facultad");
            this.especialidad.Nivel = (Nivel)Enum.Parse(typeof(Nivel), lector.GetString("nivel"));
        }

        protected override void limpiarObjetoDelResultSet()
        {
            this.especialidad = null;
        }        
    }
}
