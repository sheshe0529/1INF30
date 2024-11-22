package pe.edu.pucp.softpub.persona.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.persona.dao.PersonaDAO;
import pe.edu.pucp.softpub.persona.daoImpl.PersonaDAOImpl;
import pe.edu.pucp.softpub.persona.model.Genero;
import pe.edu.pucp.softpub.persona.model.Persona;

public class PersonaBO {

    private final PersonaDAO personaDAO;

    public PersonaBO() {
        this.personaDAO = new PersonaDAOImpl();
    }

    public Integer insertar(String paterno, String materno, String nombre, Genero genero, Date fechaCreacion, String usuarioCreacion) {
        Persona persona = new Persona(null, paterno, materno, nombre, genero, fechaCreacion, usuarioCreacion, null, null, null);
        return this.personaDAO.insertar(persona);
    }
    
    public Integer modificar(Integer idPersona, String paterno, String materno, String nombre, Genero genero, Date fechaModificacion, String usuarioModificacion) {
        Persona persona = new Persona(idPersona, paterno, materno, nombre, genero, null, null, fechaModificacion, usuarioModificacion, null);
        return this.personaDAO.modificar(persona);
    }
    
    public Integer eliminar(Integer idPersona) {
        Persona persona = new Persona();
        persona.setIdPersona(idPersona);
        return this.personaDAO.eliminar(persona);
    }

    public ArrayList<Persona> listarTodos(){
        return this.personaDAO.listarTodos();
    }
    
    public Persona obtenerPorId(Integer idPersona){
        return this.personaDAO.obtenerPorId(idPersona);
    }
    
    public Boolean existePersona(String paterno, String materno, String nombre){
        Persona persona = new Persona();
        persona.setPaterno(paterno);
        persona.setMaterno(materno);
        persona.setNombre(nombre);
        return this.personaDAO.existePersona(persona);
    }
}
