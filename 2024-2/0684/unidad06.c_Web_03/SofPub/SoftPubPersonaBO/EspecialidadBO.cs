using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaDA.DAO;
using SoftPubPersonaDA.DAOImpl;
using SoftPubPersonaModel;

namespace SoftPubPersonaBO
{    
    public class EspecialidadBO
    {
        private EspecialidadDAO especialidadDAO;

        public EspecialidadBO()
        {
            this.especialidadDAO = new EspecialidadDAOImpl();
        }

        public int insertar(int idEspecialidad, string nombre_especialidad, string facultad, string descripcion_nivel)
        {
            Nivel nivel = (Nivel)Enum.Parse(typeof(Nivel), descripcion_nivel);
            Especialidad especialidad = new Especialidad(idEspecialidad, nombre_especialidad, facultad, nivel);
            return this.especialidadDAO.insertar(especialidad);
        }

        public int modificar(int idEspecialidad, string nombre_especialidad, string facultad, string descripcion_nivel)
        {
            Nivel nivel = (Nivel)Enum.Parse(typeof(Nivel), descripcion_nivel);
            Especialidad especialidad = new Especialidad(idEspecialidad, nombre_especialidad, facultad, nivel);
            return this.especialidadDAO.modificar(especialidad);
        }

        public int eliminar(int idEspecialidad, string nombre_especialidad, string facultad, string descripcion_nivel)
        {
            Nivel nivel = (Nivel)Enum.Parse(typeof(Nivel), descripcion_nivel);
            Especialidad especialidad = new Especialidad(idEspecialidad, nombre_especialidad, facultad, nivel);
            return this.especialidadDAO.eliminar(especialidad);
        }

        public BindingList<Object> listarTodos()
        {
            return this.especialidadDAO.listarTodos();
        }
    }
}
