package pe.edu.pucp.softpub.grupo.model;

import pe.edu.pucp.softpub.publicacion.model.Publicacion;

/**
 *
 * Autor: andres
 */
public class ProductosLinea {
    private Linea linea;
    private Publicacion publicacion;

    public ProductosLinea(Linea linea, Publicacion publicacion) {
        this.linea = linea;
        this.publicacion = publicacion;        
    }
    
    public ProductosLinea() {
        this.linea = null;
        this.publicacion = null;
    }

    /**
     * @return the linea
     */
    public Linea getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    /**
     * @return the publicacion
     */
    public Publicacion getPublicacion() {
        return publicacion;
    }

    /**
     * @param publicacion the publicacion to set
     */
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    
}
