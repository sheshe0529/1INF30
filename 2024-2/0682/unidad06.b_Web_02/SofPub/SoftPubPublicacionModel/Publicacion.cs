using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftPubPublicacionModel
{
    public class Publicacion
    {
        private int idPublicacion;
        private string titulo;
        private Tipo tipo;
        private string origen;
        private string volumen;
        private string numero;
        private int paginaInicio;
        private int paginaFin;
        private DateTime fechaPublicacion;
        private string DOI;
        private string ISSN;
        private string ISBN;
        private string edicion;
        private string lugar;
        private string editorial;
        private string departamento;
        private string institucion;
        private string ciudad;

        public int IdPublicacion { get => idPublicacion; set => idPublicacion = value; }
        public string Titulo { get => titulo; set => titulo = value; }
        public Tipo Tipo { get => tipo; set => tipo = value; }
        public string Origen { get => origen; set => origen = value; }
        public string Volumen { get => volumen; set => volumen = value; }
        public string Numero { get => numero; set => numero = value; }
        public int PaginaInicio { get => paginaInicio; set => paginaInicio = value; }
        public int PaginaFin { get => paginaFin; set => paginaFin = value; }
        public DateTime FechaPublicacion { get => fechaPublicacion; set => fechaPublicacion = value; }
        public string DOI1 { get => DOI; set => DOI = value; }
        public string ISSN1 { get => ISSN; set => ISSN = value; }
        public string ISBN1 { get => ISBN; set => ISBN = value; }
        public string Edicion { get => edicion; set => edicion = value; }
        public string Lugar { get => lugar; set => lugar = value; }
        public string Editorial { get => editorial; set => editorial = value; }
        public string Departamento { get => departamento; set => departamento = value; }
        public string Institucion { get => institucion; set => institucion = value; }
        public string Ciudad { get => ciudad; set => ciudad = value; }
    }    
}
