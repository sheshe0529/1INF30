using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubGrupoModel;

namespace SoftPubGrupoControler.DAO
{
    public interface LineaDAO
    {        
        BindingList<Object> listarTodos();

        BindingList<object> listarPorGrupo(int? idGrupo);

        Linea obtenerPorId(int idGrupo, int idLinea);
    }
}
