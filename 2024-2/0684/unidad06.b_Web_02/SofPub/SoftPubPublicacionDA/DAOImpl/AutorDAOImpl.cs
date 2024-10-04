using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SofPubDBManager;
using SoftPubPublicacionDA.DAO;

namespace SoftPubPublicacionDA.DAOImpl
{
    public class AutorDAOImpl : DAOImplBase, AutorDAO
    {
        public AutorDAOImpl() : base("autor")
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
