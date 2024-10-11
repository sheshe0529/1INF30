using System;
using System.Collections.Generic;
using System.ComponentModel;
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
        private string dOI;
        private string iSSN;
        private string iSBN;
        private string edicion;
        private string lugar;
        private string editorial;
        private string departamento;
        private string institucion;
        private string ciudad;
        private string estado;
        private BindingList<Autor> autores;

        public int IdPublicacion { get => idPublicacion; set => idPublicacion = value; }
        public string Titulo { get => titulo; set => titulo = value; }
        public Tipo Tipo { get => tipo; set => tipo = value; }
        public string Origen { get => origen; set => origen = value; }
        public string Volumen { get => volumen; set => volumen = value; }
        public string Numero { get => numero; set => numero = value; }
        public int PaginaInicio { get => paginaInicio; set => paginaInicio = value; }
        public int PaginaFin { get => paginaFin; set => paginaFin = value; }
        public DateTime FechaPublicacion { get => fechaPublicacion; set => fechaPublicacion = value; }
        public string DOI { get => dOI; set => dOI = value; }
        public string ISSN { get => iSSN; set => iSSN = value; }
        public string ISBN { get => iSBN; set => iSBN = value; }
        public string Edicion { get => edicion; set => edicion = value; }
        public string Lugar { get => lugar; set => lugar = value; }
        public string Editorial { get => editorial; set => editorial = value; }
        public string Departamento { get => departamento; set => departamento = value; }
        public string Institucion { get => institucion; set => institucion = value; }
        public string Ciudad { get => ciudad; set => ciudad = value; }
        public string Estado { get => estado; set => estado = value; }
        public BindingList<Autor> Autores { get => autores; set => autores = value; }
    }
}
