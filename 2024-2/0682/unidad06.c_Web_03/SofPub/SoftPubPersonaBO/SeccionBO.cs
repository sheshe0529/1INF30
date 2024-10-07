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
    public class SeccionBO
    {
        private SeccionDAO seccionDAO;

        public SeccionBO() 
        { 
            this.seccionDAO = new SeccionDAOImpl();
        }

        public int insertar(string idSeccion, string nombre_seccion, string departamento)
        {
            Seccion seccion = new Seccion(idSeccion, nombre_seccion, departamento);
            return this.seccionDAO.insertar(seccion);
        }

        public int modificar(string idSeccion, string nombre_seccion, string departamento)
        {
            Seccion seccion = new Seccion(idSeccion, nombre_seccion, departamento);
            return this.seccionDAO.modificar(seccion);
        }

        public int eliminar(string idSeccion)
        {
            Seccion seccion = new Seccion();
            seccion.IdSeccion = idSeccion;
            return this.seccionDAO.eliminar(seccion);
        }

        public BindingList<Object> listarTodos()
        {
            return this.seccionDAO.listarTodos();
        }
    }
}
