package pe.edu.pucp.softpub.persona.dao;

import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.model.Profesor;

public interface ProfesorDAO {

    public Integer insertar(Profesor profesor);

    public Integer modificar(Profesor profesor);

    public Integer eliminar(Profesor profesor);

    public ArrayList<Profesor> listarTodos();

    public Profesor obtenerPorId(Integer idPersona);
    
    public Boolean existeProfesor(Profesor profesor);
    
    public Boolean existeProfesor(Profesor profesor, Boolean abreConexion);
}
