using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubGrupoModel;

namespace SoftPubGrupoControler.DAO
{
    public interface ProductosLineaDAO
    {
        void insertarEnLote(BindingList<ProductosLinea> listaProductos);
    }
}
