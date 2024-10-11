using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubGrupoModel
{
    public class Linea
    {
        private Grupo grupo;
        private int idLinea;
        private string nombre;
        private BindingList<ProductosLinea> productos;
        private int cantidad_productos;

        public Grupo Grupo { get => grupo; set => grupo = value; }
        public int IdLinea { get => idLinea; set => idLinea = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public int Cantidad_productos { get => cantidad_productos; set => cantidad_productos = value; }
        public BindingList<ProductosLinea> Productos { get => productos; set => productos = value; }
    }
}
