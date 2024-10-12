package pe.edu.pucp.softpub.grupo.bo;

import java.util.ArrayList;
import pe.edu.pucp.softpub.grupo.dao.GrupoDAO;
import pe.edu.pucp.softpub.grupo.daoImpl.GrupoDAOImpl;
import pe.edu.pucp.softpub.grupo.model.Grupo;

public class GrupoBO {

    private final GrupoDAO grupoDAO;
    
    public GrupoBO(){
        this.grupoDAO = new GrupoDAOImpl();
    }
    
    public Integer insertar(String nombre, String sigla){
        Grupo grupo = new Grupo(null, nombre, sigla);
        return this.grupoDAO.insertar(grupo);
    }
    
    public Integer modificar(Integer idGrupo, String nombre, String sigla){
        Grupo grupo = new Grupo(idGrupo, nombre, sigla);
        return this.grupoDAO.modificar(grupo);
    }
    
    public Integer eliminar(Integer idGrupo){
        Grupo grupo = new Grupo();
        grupo.setIdGrupo(idGrupo);
        return this.grupoDAO.eliminar(grupo);
    }
    
    public ArrayList<Grupo> listarTodos(){
        return this.grupoDAO.listarTodos();
    }
    
    public Grupo obtenerPorId(Integer idGrupo){
        return this.grupoDAO.obtenerPorId(idGrupo);
    }
}
