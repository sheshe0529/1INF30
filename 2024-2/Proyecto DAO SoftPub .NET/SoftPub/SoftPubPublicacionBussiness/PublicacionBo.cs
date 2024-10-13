using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPublicacionControler.DAO;
using SoftPubPublicacionControler.DAOImpl;
using SoftPubPublicacionModel;

namespace SoftPubPublicacionBussiness
{
    public class PublicacionBo
    {
        private PublicacionDAO publicacionDAO;

        public PublicacionBo()
        {
            this.publicacionDAO = new PublicacionDAOImpl();
        }

        public BindingList<Object> listarTodos()
        {
            return this.publicacionDAO.listarTodos();   
        }

        public BindingList<Object> buscarPublicacion(string titulo)
        {
            return this.publicacionDAO.buscarPublicacion(titulo);
        }

        public Publicacion obtenerPorId(int idPublicacion)
        {
            return this.publicacionDAO.obtenerPorId(idPublicacion);
        }
    }
}
