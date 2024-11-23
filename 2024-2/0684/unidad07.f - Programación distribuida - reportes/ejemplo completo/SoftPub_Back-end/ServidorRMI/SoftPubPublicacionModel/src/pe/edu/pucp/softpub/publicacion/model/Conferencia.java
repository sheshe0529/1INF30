package pe.edu.pucp.softpub.publicacion.model;

import java.util.Date;

public class Conferencia extends Publicacion {

    public Conferencia() {
        super(); 
    }
    
    public Conferencia(Integer idPublicacion, String titulo, String origen, Integer paginaInicio, Integer paginaFin, Date fechaPublicacion, String DOI, String lugar, String ciudad, String estado) {
        super(); //todos los demás campos en null
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.tipo = Tipo.ARTICULO_EN_CONFERENCIA;
        this.origen = origen;
        this.paginaInicio = paginaInicio;
        this.paginaFin = paginaFin;
        this.fechaPublicacion = fechaPublicacion;
        this.DOI = DOI;        
        this.lugar = lugar;
        this.ciudad = ciudad;
        this.estado = estado;
    }
}
