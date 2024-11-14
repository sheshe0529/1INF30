package pe.edu.pucp.softpub.publicacion.model;

import java.util.Date;

public class Editorial extends Publicacion {

    public Editorial() {
        super(); 
    }
    
    public Editorial(Integer idPublicacion, String titulo, String origen, String volumen, String numero, Integer paginaInicio, Integer paginaFin, Date fechaPublicacion, String DOI, String ISSN) {
        super(); //todos los demás campos en null
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.tipo = Tipo.EDITORIAL;
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
