using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaModel;

namespace SoftPubPersonaDA.DAO
{
    public interface EspecialidadDAO
    {
        int insertar(Especialidad especialidad);

        int eliminar(Especialidad especialidad);

        int modificar(Especialidad especialidad);

        BindingList<object> listarTodos();
    }
}
