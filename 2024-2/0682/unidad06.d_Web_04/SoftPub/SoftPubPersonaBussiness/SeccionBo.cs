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
    public class SeccionBo
    {
        private SeccionDAO seccionDAO;

        public SeccionBo()
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

        public Seccion obtenerPorId(string idSeccion)
        {
            return this.seccionDAO.obtenerPorId(idSeccion);
        }        
    }
}
