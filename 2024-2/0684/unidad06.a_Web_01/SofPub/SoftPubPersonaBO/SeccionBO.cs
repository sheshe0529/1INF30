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

        public BindingList<Seccion> listarTodos()
        {
            return this.seccionDAO.listarTodos();
        }
    }
}
