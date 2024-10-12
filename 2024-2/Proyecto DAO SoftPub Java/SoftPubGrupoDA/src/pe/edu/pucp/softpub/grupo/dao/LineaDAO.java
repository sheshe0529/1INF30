package pe.edu.pucp.softpub.grupo.dao;

import java.util.ArrayList;
import pe.edu.pucp.softpub.grupo.model.Linea;

public interface LineaDAO {

    public Integer insertar(Linea linea);

    public Integer modificar(Linea linea);

    public Integer eliminar(Linea linea);

    public ArrayList<Linea> listarTodos(Integer idGrupo);

    public Linea obtenerPorId(Linea linea);
    
}
