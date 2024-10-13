using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubGrupoModel
{
    public class Grupo
    {
        private int? idGrupo;
        private string nombre;
        private string sigla;
        private BindingList<Linea> lineas;           

        public Grupo()
        {
            this.idGrupo = null;
            this.nombre = null;
            this.sigla = null;
            this.lineas = new BindingList<Linea>();
        }

        public Grupo(int? idGrupo, string nombre, string sigla)
        {
            this.idGrupo = idGrupo;
            this.nombre = nombre;
            this.sigla = sigla;
            this.lineas = new BindingList<Linea>();
        }

        public int? IdGrupo { get => idGrupo; set => idGrupo = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Sigla { get => sigla; set => sigla = value; }
        public BindingList<Linea> Lineas { get => lineas; set => lineas = value; }
    }
}
