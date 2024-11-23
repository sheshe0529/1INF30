package pe.edu.pucp.softpub.persona.model;

import java.util.Date;

public class Alumno extends Persona {

    private Boolean matriculado;
    private Especialidad especialidad;

    public Alumno(Integer idPersona, String paterno, String materno, String nombre, Genero genero, Date fechaCreacion, String usuarioCreacion, Date fechaModificacion, String usuarioModificacion, Date fechaEliminacion, Boolean matriculado, Especialidad especialidad) {
        super(idPersona, paterno, materno, nombre, genero, fechaCreacion, usuarioCreacion, fechaModificacion, usuarioModificacion, fechaEliminacion);
        this.matriculado = matriculado;
        this.especialidad = especialidad;
    }
    
    public Alumno(Integer idPersona, Boolean matriculado, Especialidad especialidad) {
        super();
        this.setIdPersona(idPersona);
        this.matriculado = matriculado;
        this.especialidad = especialidad;
    }

    public Alumno() {
        super();
        this.matriculado = null;
        this.especialidad = null;
    }

    /**
     * @return the matriculado
     */
    public Boolean getMatriculado() {
        return matriculado;
    }

    /**
     * @param matriculado the matriculado to set
     */
    public void setMatriculado(Boolean matriculado) {
        this.matriculado = matriculado;
    }

    /**
     * @return the especialidad
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
