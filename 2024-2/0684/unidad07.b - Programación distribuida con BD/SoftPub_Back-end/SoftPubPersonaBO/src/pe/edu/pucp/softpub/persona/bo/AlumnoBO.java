package pe.edu.pucp.softpub.persona.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.persona.dao.AlumnoDAO;
import pe.edu.pucp.softpub.persona.daoImpl.AlumnoDAOImpl;
import pe.edu.pucp.softpub.persona.model.Alumno;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Genero;

public class AlumnoBO {

    private final AlumnoDAO alumnoDAO;

    public AlumnoBO() {
        this.alumnoDAO = new AlumnoDAOImpl();
    }
    
    public Integer insertar(String paterno, String materno, String nombre, Genero genero, Date fechaCreacion, String usuarioCreacion, Boolean matriculado, Especialidad especialidad) {
        Alumno alumno = new Alumno(null, paterno, materno,  nombre,  genero,  fechaCreacion,  usuarioCreacion, null, null, null,  matriculado,  especialidad);
        return this.alumnoDAO.insertar(alumno);
    }
    
    public Integer modificar(Integer idPersona, String paterno, String materno, String nombre, Genero genero, Date fechaModificacion, String usuarioModificacion, Boolean matriculado, Especialidad especialidad) {
        Alumno alumno = new Alumno(idPersona, paterno, materno,  nombre,  genero,  null,  null, fechaModificacion, usuarioModificacion, null,  matriculado,  especialidad);
        return this.alumnoDAO.modificar(alumno);
    }
    
    public Integer eliminar(Integer idPersona) {
        Alumno alumno = new Alumno();
        alumno.setIdPersona(idPersona);
        return this.alumnoDAO.eliminar(alumno);
    }
    
    public ArrayList<Alumno> listarTodos(){
        return this.alumnoDAO.listarTodos();
    }
    
    public Alumno obtenerPorId(Integer idPersona){
        return this.alumnoDAO.obtenerPorId(idPersona);
    }
}
