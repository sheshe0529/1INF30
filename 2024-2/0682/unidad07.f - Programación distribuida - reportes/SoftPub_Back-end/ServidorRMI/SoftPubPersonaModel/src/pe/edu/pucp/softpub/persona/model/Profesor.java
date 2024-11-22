package pe.edu.pucp.softpub.persona.model;

import java.util.Date;

public class Profesor extends Persona {

    private Boolean activo;
    private Categoria categoria;
    private Dedicacion dedicacion;
    private Seccion seccion;

    public Profesor(Integer idPersona, String paterno, String materno, String nombre, Genero genero, Date fechaCreacion, String usuarioCreacion, Date fechaModificacion, String usuarioModificacion, Date fechaEliminacion, Categoria categoria, Dedicacion dedicacion, Boolean activo, Seccion seccion) {
        super(idPersona, paterno, materno, nombre, genero, fechaCreacion, usuarioCreacion, fechaModificacion, usuarioModificacion, fechaEliminacion);
        this.activo = activo;
        this.categoria = categoria;
        this.dedicacion = dedicacion;
        this.seccion = seccion;
    }
    
    public Profesor(Integer idPersona, Categoria categoria, Dedicacion dedicacion, Boolean activo,  Seccion seccion) {
        super();
        this.setIdPersona(idPersona);
        this.activo = activo;
        this.categoria = categoria;
        this.dedicacion = dedicacion;
        this.seccion = seccion;
    }

    public Profesor() {
        super();
        this.activo = null;
        this.categoria = null;
        this.dedicacion = null;
        this.seccion = null;
    }

    /**
     * @return the activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the dedicacion
     */
    public Dedicacion getDedicacion() {
        return dedicacion;
    }

    /**
     * @param dedicacion the dedicacion to set
     */
    public void setDedicacion(Dedicacion dedicacion) {
        this.dedicacion = dedicacion;
    }

    /**
     * @return the seccion
     */
    public Seccion getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
}
