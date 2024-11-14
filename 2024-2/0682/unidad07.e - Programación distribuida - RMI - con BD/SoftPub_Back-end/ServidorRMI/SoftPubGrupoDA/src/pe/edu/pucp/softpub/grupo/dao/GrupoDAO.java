package pe.edu.pucp.softpub.grupo.dao;

import java.util.ArrayList;
import pe.edu.pucp.softpub.grupo.model.Grupo;

public interface GrupoDAO {

    public Integer insertar(Grupo grupo);    

    public Integer modificar(Grupo grupo);

    public Integer eliminar(Grupo grupo);

    public ArrayList<Grupo> listarTodos();

    public Grupo obtenerPorId(Integer idGrupo);
    
}
