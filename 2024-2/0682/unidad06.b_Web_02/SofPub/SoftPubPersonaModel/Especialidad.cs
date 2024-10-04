using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubPersonaModel
{
    public class Especialidad
    {
        private int idEspecialidad;
        private string nombre_especialidad;
        private string facultad;
        private Nivel nivel;

        public int IdEspecialidad { get => idEspecialidad; set => idEspecialidad = value; }
        public string Nombre_especialidad { get => nombre_especialidad; set => nombre_especialidad = value; }
        public string Facultad { get => facultad; set => facultad = value; }
        public Nivel Nivel { get => nivel; set => nivel = value; }
    }
}
