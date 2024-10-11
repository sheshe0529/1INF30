using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubPersonaModel
{
    public class Seccion
    {
        private string idSeccion;
        private string nombre_seccion;
        private string departamento;

        public Seccion()
        {
            this.idSeccion = null;
            this.nombre_seccion = null;
            this.departamento = null;
        }

        public Seccion(string idSeccion, string nombre_seccion, string departamento)
        {
            this.idSeccion = idSeccion;
            this.nombre_seccion = nombre_seccion;
            this.departamento = departamento;
        }

        public string IdSeccion { get => idSeccion; set => idSeccion = value; }
        public string Nombre_seccion { get => nombre_seccion; set => nombre_seccion = value; }
        public string Departamento { get => departamento; set => departamento = value; }
    }
}
