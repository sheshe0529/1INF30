using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubGrupoModel;

namespace SoftPubGrupoControler.DAO
{
    public interface GrupoDAO
    {        
        int? insertar(Grupo grupo);

        BindingList<Object> listarTodos();

        BindingList<Object> listarGruposConProduccion();

        BindingList<Object> buscarGrupos(string nombre);

        Grupo obtenerPorId(int idGrupo);
    }
}
