using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubPersonaModel
{
    internal class Alumno : Persona
    {
        private bool matriculado;
        private Especialidad especialidad;

        public bool Matriculado { get => matriculado; set => matriculado = value; }
        public Especialidad Especialidad { get => especialidad; set => especialidad = value; }
    }
}
