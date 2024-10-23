package pe.edu.pucp.softpub.publicacion.model;

import pe.edu.pucp.softpub.persona.model.Persona;

public class Autor {
    private Persona persona;
    private Publicacion publicacion;
    private Integer seqAutor;
    
    public Autor(Persona persona, Publicacion publicacion, Integer seqAutor) {
        this.persona = persona;
        this.publicacion = publicacion;
        this.seqAutor = seqAutor;
    }
    
    public Autor() {
        this.persona = null;
        this.publicacion = null;
        this.seqAutor = null;
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
