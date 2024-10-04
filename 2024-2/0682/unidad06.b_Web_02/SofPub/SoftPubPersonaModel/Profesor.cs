using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubPersonaModel
{
    public class Profesor : Persona
    {
        private bool activo;
        private Categoria categoria;
        private Dedicacion dedicacion;
        private Seccion seccion;

        public bool Activo { get => activo; set => activo = value; }
        public Categoria Categoria { get => categoria; set => categoria = value; }
        public Dedicacion Dedicacion { get => dedicacion; set => dedicacion = value; }
        public Seccion Seccion { get => seccion; set => seccion = value; }
    }
}
