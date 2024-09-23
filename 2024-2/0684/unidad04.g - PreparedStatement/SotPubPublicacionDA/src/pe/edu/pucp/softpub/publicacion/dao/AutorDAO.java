package pe.edu.pucp.softpub.publicacion.dao;

import java.util.ArrayList;
import pe.edu.pucp.softpub.publicacion.model.Autor;

public interface AutorDAO {
    
    public Integer insertar(Autor autor);
    
    public Integer modificar(Autor autor);
    
    public Integer eliminar(Autor autor);
    
    public ArrayList<Autor> listarTodos();
    
    public Autor obtenerPorId(Integer idPersona);
    
}
