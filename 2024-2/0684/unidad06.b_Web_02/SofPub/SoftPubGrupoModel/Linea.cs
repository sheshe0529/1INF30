using System;
using System.Collections.Generic;
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

        public Grupo Grupo { get => grupo; set => grupo = value; }
        public int IdLinea { get => idLinea; set => idLinea = value; }
        public string Nombre { get => nombre; set => nombre = value; }
    }
}
