package pe.edu.pucp.softpub.persona.model;

public class Especialidad {
    private Integer idEspecialidad;
    private String especialidad;
    private String facultad;
    private Nivel nivel;

    public Especialidad() {
        this.idEspecialidad = null;
        this.especialidad = null;
        this.facultad = null;
        this.nivel = null;
    }
    
    public Especialidad(Integer idEspecialidad, String especialidad, String facultad, Nivel nivel) {
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
        this.facultad = facultad;
        this.nivel = nivel;
    }

    /**
     * @return the idEspecialidad
     */
    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     * @param idEspecialidad the idEspecialidad to set
     */
    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the facultad
     */
    public String getFacultad() {
        return facultad;
    }

    /**
     * @param facultad the facultad to set
     */
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    /**
     * @return the nivel
     */
    public Nivel getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
    
    
}
