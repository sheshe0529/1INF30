using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaModel;

namespace SoftPubPersonaDA.DAO
{
    public interface SeccionDAO
    {
        int insertar(Seccion seccion);

        int eliminar(Seccion seccion);

        int modificar(Seccion seccion);

        BindingList<object> listarTodos();
    }
}
