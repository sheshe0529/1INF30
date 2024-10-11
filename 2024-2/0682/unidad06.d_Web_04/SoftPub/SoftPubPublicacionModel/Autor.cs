using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaModel;

namespace SoftPubPublicacionModel
{
    public class Autor
    {
        private Persona persona;
        private Publicacion publicacion;
        private int seqAutor;

        public Persona Persona { get => persona; set => persona = value; }
        public Publicacion Publicacion { get => publicacion; set => publicacion = value; }
        public int SeqAutor { get => seqAutor; set => seqAutor = value; }
    }
}
