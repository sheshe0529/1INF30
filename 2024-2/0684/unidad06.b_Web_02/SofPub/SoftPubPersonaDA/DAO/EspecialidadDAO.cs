using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubPersonaDA.DAO
{
    public interface EspecialidadDAO
    {
        BindingList<object> listarTodos();
    }
}
