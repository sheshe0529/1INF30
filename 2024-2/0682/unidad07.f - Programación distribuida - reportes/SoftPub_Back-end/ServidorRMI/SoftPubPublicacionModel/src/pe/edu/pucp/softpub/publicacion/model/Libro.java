package pe.edu.pucp.softpub.publicacion.model;

import java.util.Date;

public class Libro extends Publicacion {
    
    public Libro() {
        super(); 
    }

    public Libro(Integer idPublicacion, String titulo, String origen, Date fechaPublicacion, String DOI, String ISBN, String edicion, String lugar, String editorial) {
        super(); //todos los demás campos en null
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.tipo = Tipo.LIBRO;
        this.origen = origen;
        this.fechaPublicacion = fechaPublicacion;
        this.DOI = DOI;
        this.ISBN = ISBN;
        this.edicion = edicion;
        this.lugar = lugar;
        this.editorial = editorial;
    }        
}
