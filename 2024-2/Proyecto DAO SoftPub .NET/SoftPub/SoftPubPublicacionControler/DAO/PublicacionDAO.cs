using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubGrupoModel;
using SoftPubPublicacionModel;

namespace SoftPubPublicacionControler.DAO
{
    public interface PublicacionDAO
    {
        BindingList<Object> listarTodos();

        BindingList<Object> buscarPublicacion(string titulo);

        Publicacion obtenerPorId(int idPublicacion);
    }
}
