package pe.edu.pucp.softpub.persona.dao;

import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.model.Seccion;

/**
 *
 * Autor: andres
 */
public interface SeccionDAO {

    public Integer insertar(Seccion seccion);

    public Integer modificar(Seccion seccion);

    public Integer eliminar(Seccion seccion);

    public ArrayList<Seccion> listarTodos();
    
    public Seccion obtenerPorId(String idSeccion);
}
