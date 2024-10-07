using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SofPubDBManager;
using SoftPubGrupoDA.DAO;

namespace SoftPubGrupoDA.DAOImpl
{
    public class LineaDAOImpl : DAOImplBase, LineaDAO
    {
        public LineaDAOImpl() : base("linea")
        {
        }

        protected override void agregarObjetoALaLista(BindingList<object> lista, global::MySql.Data.MySqlClient.MySqlDataReader lector)
        {
            throw new NotImplementedException();
        }

        protected override string obtenerProyeccionParaSelect()
        {
            throw new NotImplementedException();
        }
    }
}
