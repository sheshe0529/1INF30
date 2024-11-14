package pe.edu.pucp.softpub.persona.dao;

import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.model.Alumno;

public interface AlumnoDAO {

    public Integer insertar(Alumno alumno);

    public Integer modificar(Alumno alumno);

    public Integer eliminar(Alumno alumno);

    public ArrayList<Alumno> listarTodos();

    public Alumno obtenerPorId(Integer idPersona);
    
    public Boolean existeAlumno(Alumno alumno);
    
    public Boolean existeAlumno(Alumno alumno, Boolean abreConexion);
}
