package pe.edu.pucp.softpub.publicacion.model;

import java.util.Date;

public class Articulo extends Publicacion {

    public Articulo() {
        super(); 
    }
    
    public Articulo(Integer idPublicacion, String titulo, String origen, String volumen, String numero, Integer paginaInicio, Integer paginaFin, Date fechaPublicacion, String DOI, String ISSN) {
        super(); //todos los demás campos en null
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.tipo = Tipo.ARTICULO_EN_REVISTA;
        this.origen = origen;
        this.volumen = volumen;
        this.numero = numero;
        this.paginaInicio = paginaInicio;
        this.paginaFin = paginaFin;
        this.fechaPublicacion = fechaPublicacion;
        this.DOI = DOI;
        this.ISSN = ISSN;
    }

}
