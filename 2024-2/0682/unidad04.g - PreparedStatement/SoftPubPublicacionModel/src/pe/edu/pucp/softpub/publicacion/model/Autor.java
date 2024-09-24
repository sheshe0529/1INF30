package pe.edu.pucp.softpub.publicacion.model;

import pe.edu.pucp.softpub.persona.model.Persona;

public class Autor {
    private Publicacion publicacion;
    private Persona persona;
    private Integer seqAutor;

    public Autor(Publicacion publicacion, Persona persona, Integer seqAutor) {
        this.publicacion = publicacion;
        this.persona = persona;
        this.seqAutor = seqAutor;
    }
    
    public Autor() {
        this.publicacion = null;
        this.persona = null;
        this.seqAutor = null;
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
     * @return the seqAutor
     */
    public Integer getSeqAutor() {
        return seqAutor;
    }

    /**
     * @param seqAutor the seqAutor to set
     */
    public void setSeqAutor(Integer seqAutor) {
        this.seqAutor = seqAutor;
    }
    
    
}
