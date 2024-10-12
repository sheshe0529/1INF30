package pe.edu.pucp.softpub.grupo.bo;

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
}
