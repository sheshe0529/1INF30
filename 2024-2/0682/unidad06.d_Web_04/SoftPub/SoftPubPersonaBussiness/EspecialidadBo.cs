using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaControler.DAO;
using SoftPubPersonaControler.DAOImpl;
using SoftPubPersonaModel;

namespace SoftPubPersonaBussiness
{
    public class EspecialidadBo
    {
        private EspecialidadDAO especialidadDAO;

        public EspecialidadBo()
        {
            this.especialidadDAO = new EspecialidadDAOImpl();
        }

        public int insertar(int idEspecialidad, string nombre_especialidad, string faculdad, string descripcion_nivel)
        {
            Nivel nivel = (Nivel)Enum.Parse(typeof(Nivel), descripcion_nivel);
            Especialidad especialidad = new Especialidad(idEspecialidad, nombre_especialidad, faculdad, nivel);
            return this.especialidadDAO.insertar(especialidad); 
        }

        public int modificar(int idEspecialidad, string nombre_especialidad, string faculdad, string descripcion_nivel)
        {
            Nivel nivel = (Nivel)Enum.Parse(typeof(Nivel), descripcion_nivel);
            Especialidad especialidad = new Especialidad(idEspecialidad, nombre_especialidad, faculdad, nivel);
            return this.especialidadDAO.modificar(especialidad);
        }

        public int eliminar(int idEspecialidad)
        {
            Especialidad especialidad = new Especialidad();
            especialidad.IdEspecialidad = idEspecialidad;
            return this.especialidadDAO.eliminar(especialidad);
        }

        public BindingList<Object> listarTodos()
        {
            return this.especialidadDAO.listarTodos();
        }

        public Especialidad obtenerPorId(int idEspecialidad)
        {
            return this.especialidadDAO.obtenerPorId(idEspecialidad);
        }
    }
}
