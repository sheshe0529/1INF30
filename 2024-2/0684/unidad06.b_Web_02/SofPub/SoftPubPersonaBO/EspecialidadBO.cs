using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaDA.DAO;
using SoftPubPersonaDA.DAOImpl;

namespace SoftPubPersonaBO
{    
    public class EspecialidadBO
    {
        private EspecialidadDAO especialidadDAO;

        public EspecialidadBO()
        {
            this.especialidadDAO = new EspecialidadDAOImpl();
        }

        public BindingList<Object> listarTodos()
        {
            return this.especialidadDAO.listarTodos();
        }
    }
}
