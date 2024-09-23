package pe.edu.pucp.softpub.publicacion.dao;

import java.util.ArrayList;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;

public interface PublicacionDAO {
    
    public Integer insertar(Publicacion publicacion);
    
    public Integer modificar(Publicacion publicacion);
    
    public Integer eliminar(Publicacion publicacion);
    
    public ArrayList<Publicacion> listarTodos();
    
    public Publicacion obtenerPorId(Integer idPublicacion);
}
