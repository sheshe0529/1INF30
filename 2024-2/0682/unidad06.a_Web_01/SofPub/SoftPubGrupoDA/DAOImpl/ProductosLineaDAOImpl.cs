using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SofPubDBManager;
using SoftPubGrupoDA.DAO;

namespace SoftPubGrupoDA.DAOImpl
{
    public class ProductosLineaDAOImpl : DAOImplBase, ProductosLineaDAO
    {
        public ProductosLineaDAOImpl() : base("productos_x_linea")
        {
        }

        protected override void agregarObjetoALaLista(BindingList<object> lista, MySqlDataReader lector)
        {
            throw new NotImplementedException();
        }

        protected override string obtenerProyeccionParaSelect()
        {
            throw new NotImplementedException();
        }
    }
}
