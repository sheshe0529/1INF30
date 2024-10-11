using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubGrupoControler.DAO;
using SoftPubGrupoControler.DAOImpl;
using SoftPubGrupoModel;

namespace SoftPubGrupoBussiness
{
    public class ProductosLineaBo
    {
        private ProductosLineaDAO productosLineaDAO;

        public ProductosLineaBo()
        {
            this.productosLineaDAO = new ProductosLineaDAOImpl();
        }

        public void insertarEnLote(BindingList<ProductosLinea> listaProductos)
        {
            this.productosLineaDAO.insertarEnLote(listaProductos);
        }
    }
}
