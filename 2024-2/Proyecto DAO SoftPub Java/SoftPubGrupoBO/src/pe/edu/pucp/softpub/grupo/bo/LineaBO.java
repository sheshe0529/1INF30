package pe.edu.pucp.softpub.grupo.bo;

import java.util.ArrayList;
import pe.edu.pucp.softpub.grupo.dao.LineaDAO;
import pe.edu.pucp.softpub.grupo.daoImpl.LineaDAOImpl;
import pe.edu.pucp.softpub.grupo.model.Grupo;
import pe.edu.pucp.softpub.grupo.model.Linea;

public class LineaBO {
    
    private LineaDAO lineaDAO;
    
    public LineaBO(){
        this.lineaDAO = new LineaDAOImpl();
    }
 
    public Integer insertar(Integer idGrupo, Integer idLinea, String nombre){
        Linea linea = this.crearLinea(idGrupo, idLinea, nombre);
        return this.lineaDAO.insertar(linea);
    }
    
    public Integer modificar(Integer idGrupo, Integer idLinea, String nombre){
        Linea linea = this.crearLinea(idGrupo, idLinea, nombre);
        return this.lineaDAO.modificar(linea);
    }
    
    public Integer eliminar(Integer idGrupo, Integer idLinea){
        Linea linea = this.crearLinea(idGrupo, idLinea, null);
        return this.lineaDAO.eliminar(linea);
    }
    
    public ArrayList<Linea> listarTodos(Integer idGrupo){
        return this.lineaDAO.listarTodos(idGrupo);
    }
    
    public Linea obtenerPorId(Integer idGrupo, Integer idLinea){
        Linea linea = this.crearLinea(idGrupo, idLinea, null);
        return this.lineaDAO.obtenerPorId(linea);
    }
    
    private Linea crearLinea(Integer idGrupo, Integer idLinea, String nombre){
        Grupo grupo = new Grupo();
        grupo.setIdGrupo(idGrupo);
        
        Linea linea = new Linea();
        linea.setGrupo(grupo);
        linea.setIdLinea(idLinea);
        linea.setNombre(nombre);
        return linea;
    }
    
}
