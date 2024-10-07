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
        public EspecialidadDAOImpl() : base("especialidad")
        {
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
