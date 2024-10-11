using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubPersonaModel
{
    public class Persona
    {
        private int idPersona;
        private string paterno;
        private string materno;
        private string nombre;
        private Genero genero;
        private DateTime fechaCreacion;
        private string usuarioCreacion;
        private DateTime fechaModificacion;
        private string usuarioModificacion;
        private DateTime fechaEliminacion;

        public int IdPersona { get => idPersona; set => idPersona = value; }
        public string Paterno { get => paterno; set => paterno = value; }
        public string Materno { get => materno; set => materno = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public Genero Genero { get => genero; set => genero = value; }
        public DateTime FechaCreacion { get => fechaCreacion; set => fechaCreacion = value; }
        public string UsuarioCreacion { get => usuarioCreacion; set => usuarioCreacion = value; }
        public DateTime FechaModificacion { get => fechaModificacion; set => fechaModificacion = value; }
        public string UsuarioModificacion { get => usuarioModificacion; set => usuarioModificacion = value; }
        public DateTime FechaEliminacion { get => fechaEliminacion; set => fechaEliminacion = value; }
    }
}
