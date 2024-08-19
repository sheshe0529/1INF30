using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v01
{
    public class Publicacion
    {
        private string nombre;
        private string[] autores;
        private int cantidad_autores;
        private int año;

        public Publicacion(string nombre, string[] autores, int cantidad_autores, int año)
        {
            this.nombre = nombre;
            this.autores = autores;
            this.cantidad_autores = cantidad_autores;
            this.año = año;
        }
    }
}
