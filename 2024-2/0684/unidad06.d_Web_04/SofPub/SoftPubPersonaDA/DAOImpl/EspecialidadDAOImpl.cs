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
    public class EspecialidadDAOImpl : DAOImplBase, EspecialidadDAO
    {
        private Especialidad especialidad;

        public EspecialidadDAOImpl() : base("especialidad")
        {
            this.especialidad = null;
        }

        public int insertar(Especialidad especialidad)
        {
            this.especialidad = especialidad;
            return base.insertar();
        }

        protected override string obtenerListaDeAtributosParaInsertar()
        {
            return "idEspecialidad, especialidad, facultad, nivel";
        }

        protected override string incluirListaDeParametrosParaInsertar()
        {
            return "@idEspecialidad, @especialidad, @facultad, @nivel";
        }

        protected override void incluirValorParametroParaInsercion()
        {
            this.Comando.Parameters.AddWithValue("@idEspecialidad", this.especialidad.IdEspecialidad);
            this.Comando.Parameters.AddWithValue("@especialidad", this.especialidad.Nombre_especialidad);
            this.Comando.Parameters.AddWithValue("@facultad", this.especialidad.Facultad);
            this.Comando.Parameters.AddWithValue("@nivel", this.especialidad.Nivel);
        }

        public int modificar(Especialidad especialidad)
        {
            this.especialidad = especialidad;
            return base.modificar();
        }

        protected override string obtenerListaDeAtributosParaModificacion()
        {
            return "especialidad=@especialidad, facultad=@facultad, nivel=@nivel";
        }

        protected override string obtenerPredicadoParaLlavePrimaria()
        {
            return "idEspecialidad=@idEspecialidad";
        }

        protected override void incluirValorParametroParaModificacion()
        {
            this.Comando.Parameters.AddWithValue("@idEspecialidad", this.especialidad.IdEspecialidad);
            this.Comando.Parameters.AddWithValue("@especialidad", this.especialidad.Nombre_especialidad);
            this.Comando.Parameters.AddWithValue("@facultad", this.especialidad.Facultad);
            this.Comando.Parameters.AddWithValue("@nivel", this.especialidad.Nivel);
        }

        public int eliminar(Especialidad especialidad)
        {
            this.especialidad = especialidad;
            return base.eliminar();
        }

        protected override void incluirValorParametroParaEliminacion()
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
            Especialidad especialidad = new Especialidad();
            especialidad.IdEspecialidad = lector.GetInt32("idEspecialidad");
            especialidad.Nombre_especialidad = lector.GetString("especialidad");
            especialidad.Facultad = lector.GetString("facultad");
            especialidad.Nivel =  (Nivel)Enum.Parse(typeof(Nivel), lector.GetString("nivel"));
            lista.Add(especialidad);
        }
    }
}
