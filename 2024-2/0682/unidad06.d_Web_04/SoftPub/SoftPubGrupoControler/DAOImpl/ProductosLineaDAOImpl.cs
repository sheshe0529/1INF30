using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SoftPubDBManager;
using SoftPubGrupoControler.DAO;
using SoftPubGrupoModel;

namespace SoftPubGrupoControler.DAOImpl
{
    public class ProductosLineaDAOImpl : DAOImplBase, ProductosLineaDAO
    {
        private ProductosLinea productosLinea;

        public ProductosLineaDAOImpl() : base("Productos_x_Linea")
        {
            this.productosLinea = null;
        }

        public void insertarEnLote(BindingList<ProductosLinea> listaProductos)
        {            
            try
            {
                this.UsarTransaccion = false;
                this.iniciarTransaccion();
                foreach(ProductosLinea productosLinea in listaProductos)
                {
                    this.productosLinea = productosLinea;
                    base.insertar();
                }
                this.comitarTransaccion();                
            }
            catch (Exception ex)
            {
                this.rollbackTransaccion();                
                throw new Exception(ex.Message);
            }
            finally
            {
                this.cerrarConexion();
                this.UsarTransaccion = true;
            }            
        }

        protected override string obtenerListaAtributosParaInsercion()
        {
            return "idGrupo, idLinea, idPublicacion";
        }

        protected override string incluirListaParametrosParaInsercion()
        {
            return "@idGrupo, @idLinea, @idPublicacion";
        }

        protected override void incluirValorParametrosParaInsercion()
        {
            this.Comando.Parameters.AddWithValue("@idGrupo", this.productosLinea.Linea.Grupo.IdGrupo);
            this.Comando.Parameters.AddWithValue("@idLinea", this.productosLinea.Linea.IdLinea);            
            this.Comando.Parameters.AddWithValue("@idPublicacion", this.productosLinea.Publicacion.IdPublicacion);
        }

        protected override void agregarObjetoALaLista(BindingList<object> lista, MySqlDataReader lector)
        {
            throw new NotImplementedException();
        }        

        protected override void incluirValorParametrosParaEliminacion()
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
