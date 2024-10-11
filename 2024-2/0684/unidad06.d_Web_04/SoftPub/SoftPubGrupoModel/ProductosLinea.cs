using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPublicacionModel;

namespace SoftPubGrupoModel
{
    public class ProductosLinea
    {
        private Linea linea;
        private Publicacion publicacion;

        public Linea Linea { get => linea; set => linea = value; }
        public Publicacion Publicacion { get => publicacion; set => publicacion = value; }
    }
}
