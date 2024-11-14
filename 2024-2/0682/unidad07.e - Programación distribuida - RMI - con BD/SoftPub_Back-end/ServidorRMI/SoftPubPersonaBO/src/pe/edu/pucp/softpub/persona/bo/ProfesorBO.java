package pe.edu.pucp.softpub.persona.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.persona.dao.ProfesorDAO;
import pe.edu.pucp.softpub.persona.daoImpl.ProfesorDAOImpl;
import pe.edu.pucp.softpub.persona.model.Categoria;
import pe.edu.pucp.softpub.persona.model.Dedicacion;
import pe.edu.pucp.softpub.persona.model.Genero;
import pe.edu.pucp.softpub.persona.model.Profesor;
import pe.edu.pucp.softpub.persona.model.Seccion;

public class ProfesorBO {

    private final ProfesorDAO profesorDAO;

    public ProfesorBO() {
        this.profesorDAO = new ProfesorDAOImpl();
    }

    public Integer insertar(String paterno, String materno, String nombre, Genero genero, Date fechaCreacion, String usuarioCreacion, Categoria categoria, Dedicacion dedicacion, Boolean activo, Seccion seccion) {
        Profesor profesor = new Profesor(null, paterno, materno, nombre, genero, fechaCreacion, usuarioCreacion, null, null, null, categoria, dedicacion, activo, seccion);
        return this.profesorDAO.insertar(profesor);
    }
    
    public Integer modificar(Integer idPersona, String paterno, String materno, String nombre, Genero genero, Date fechaModificacion, String usuarioModificacion, Categoria categoria, Dedicacion dedicacion, Boolean activo, Seccion seccion) {
        Profesor profesor = new Profesor(idPersona, paterno, materno, nombre, genero, null, null, fechaModificacion, usuarioModificacion, null, categoria, dedicacion, activo, seccion);
        return this.profesorDAO.modificar(profesor);
    }
    
    public Integer eliminar(Integer idPersona) {
        Profesor profesor = new Profesor();
        profesor.setIdPersona(idPersona);
        return this.profesorDAO.eliminar(profesor);
    }
    
    public ArrayList<Profesor> listarTodos(){
        return this.profesorDAO.listarTodos();
    }
    
    public Profesor obtenerPorId(Integer idPersona){
        return this.profesorDAO.obtenerPorId(idPersona);
    }
    
    public Boolean existeProfesor(Integer idPersona){
        Profesor profesor = new Profesor();
        profesor.setIdPersona(idPersona);
        return this.profesorDAO.existeProfesor(profesor);
    }
}
