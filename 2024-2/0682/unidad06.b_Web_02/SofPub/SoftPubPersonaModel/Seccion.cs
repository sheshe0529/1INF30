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

        public string IdSeccion { get => idSeccion; set => idSeccion = value; }
        public string Nombre_seccion { get => nombre_seccion; set => nombre_seccion = value; }
        public string Departamento { get => departamento; set => departamento = value; }
    }
}
