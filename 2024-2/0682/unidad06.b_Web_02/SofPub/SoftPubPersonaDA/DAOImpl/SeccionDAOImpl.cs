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
        public SeccionDAOImpl() : base("seccion")
        {
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
