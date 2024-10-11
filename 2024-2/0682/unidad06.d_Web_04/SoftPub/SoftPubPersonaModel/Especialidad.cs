using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubPersonaModel
{
    public class Especialidad
    {
        private int? idEspecialidad;
        private string nombre_especialidad;
        private string facultad;
        private Nivel? nivel;

        public Especialidad()
        {
            this.idEspecialidad = null;
            this.nombre_especialidad = null;
            this.facultad = null;
            this.nivel = null;
        }

        public Especialidad(int idEspecialidad, string nombre_especialidad, string facultad, Nivel nivel)
        {
            this.idEspecialidad = idEspecialidad;
            this.nombre_especialidad = nombre_especialidad;
            this.facultad = facultad;
            this.nivel = nivel;
        }

        public int? IdEspecialidad { get => idEspecialidad; set => idEspecialidad = value; }
        public string Nombre_especialidad { get => nombre_especialidad; set => nombre_especialidad = value; }
        public string Facultad { get => facultad; set => facultad = value; }
        public Nivel? Nivel { get => nivel; set => nivel = value; }
    }
}
