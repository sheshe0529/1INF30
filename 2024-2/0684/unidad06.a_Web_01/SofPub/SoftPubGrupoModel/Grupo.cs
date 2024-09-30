using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubGrupoModel
{
    public class Grupo
    {
        private int idGrupo;
        private string nombre;
        private string sigla;

        public int IdGrupo { get => idGrupo; set => idGrupo = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Sigla { get => sigla; set => sigla = value; }
    }
}
