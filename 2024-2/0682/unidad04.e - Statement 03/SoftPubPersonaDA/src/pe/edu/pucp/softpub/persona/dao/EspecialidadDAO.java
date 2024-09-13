package pe.edu.pucp.softpub.persona.dao;

import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.model.Especialidad;

public interface EspecialidadDAO {
    
    public Integer insertar(Especialidad especialidad);
    
    public Integer modificar(Especialidad especialidad);
    
    public Integer eliminar(Especialidad especialidad);
    
    public ArrayList<Especialidad> listarTodos();
    
    public Especialidad obtenerPorId(String idEspecialidad);
}
