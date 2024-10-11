using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.Remoting.Metadata.W3cXsd2001;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaModel;

namespace SoftPubPersonaControler.DAO
{
    public interface SeccionDAO
    {        
        int insertar(Seccion seccion);

        int modificar(Seccion seccion);

        int eliminar(Seccion seccion);

        BindingList<Object> listarTodos();

        Seccion obtenerPorId(string idSeccion);        
    }
}
