package pe.edu.pucp.softpub.publicacion.model;

import pe.edu.pucp.softpub.persona.model.Persona;

public class Autor {
    
    private Persona persona;
    private Publicacion publicacion;
    private Integer seaAutor;

    public Autor(Persona persona, Publicacion publicacion, Integer seaAutor) {
        this.persona = persona;
        this.publicacion = publicacion;
        this.seaAutor = seaAutor;
    }

    public Autor() {
        this.persona = null;
        this.publicacion = null;
        this.seaAutor = null;
    }
    
    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
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

    /**
     * @return the seaAutor
     */
    public Integer getSeaAutor() {
        return seaAutor;
    }

    /**
     * @param seaAutor the seaAutor to set
     */
    public void setSeaAutor(Integer seaAutor) {
        this.seaAutor = seaAutor;
    }
    
    
}
