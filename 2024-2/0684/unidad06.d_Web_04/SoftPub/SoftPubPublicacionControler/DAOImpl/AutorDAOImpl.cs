using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SoftPubDBManager;
using SoftPubPublicacionControler.DAO;

namespace SoftPubPublicacionControler.DAOImpl
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

        protected override string incluirListaParametrosParaInsercion()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametrosParaEliminacion()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametrosParaInsercion()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametrosParaModificacion()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametrosParaObtenerPorId()
        {
            throw new NotImplementedException();
        }

        protected override void instanciarObjetoDelResultSet(MySqlDataReader lector)
        {
            throw new NotImplementedException();
        }

        protected override void limpiarObjetoDelResultSet()
        {
            throw new NotImplementedException();
        }

        protected override string obtenerListaAtributosParaInsercion()
        {
            throw new NotImplementedException();
        }

        protected override string obtenerListaAtributosParaModificacion()
        {
            throw new NotImplementedException();
        }

        protected override string obtenerPredicadoParaLlavePrimaria()
        {
            throw new NotImplementedException();
        }

        protected override string obtenerProyeccionParaSelect()
        {
            throw new NotImplementedException();
        }
    }
}
