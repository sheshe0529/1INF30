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
    public class PublicacionDAOImpl : DAOImplBase, PublicacionDAO
    {
        public PublicacionDAOImpl() : base("publicacion")
        {
        }

        protected override void agregarObjetoALaLista(BindingList<object> lista, MySqlDataReader lector)
        {
            throw new NotImplementedException();
        }

        protected override string incluirListaDeParametrosParaInsertar()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametroParaEliminacion()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametroParaInsercion()
        {
            throw new NotImplementedException();
        }

        protected override void incluirValorParametroParaModificacion()
        {
            throw new NotImplementedException();
        }

        protected override string obtenerListaDeAtributosParaInsertar()
        {
            throw new NotImplementedException();
        }

        protected override string obtenerListaDeAtributosParaModificacion()
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
