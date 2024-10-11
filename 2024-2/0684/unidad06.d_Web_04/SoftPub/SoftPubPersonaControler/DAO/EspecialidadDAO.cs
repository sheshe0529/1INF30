using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaModel;

namespace SoftPubPersonaControler.DAO
{
    public interface EspecialidadDAO
    {        
        int insertar(Especialidad especialidad);

        int modificar(Especialidad especialidad);

        int eliminar(Especialidad especialidad);

        BindingList<object> listarTodos();

        Especialidad obtenerPorId(int idEspecialidad);        
    }
}
