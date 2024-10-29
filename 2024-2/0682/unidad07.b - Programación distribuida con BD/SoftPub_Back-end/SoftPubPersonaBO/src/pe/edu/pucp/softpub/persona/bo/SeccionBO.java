package pe.edu.pucp.softpub.persona.bo;

import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.dao.SeccionDAO;
import pe.edu.pucp.softpub.persona.daoImpl.SeccionDAOImpl;
import pe.edu.pucp.softpub.persona.model.Seccion;

public class SeccionBO {

    private final SeccionDAO seccionDAO;

    public SeccionBO() {
        this.seccionDAO = new SeccionDAOImpl();
    }
    
    public Integer insertar(String idSeccion, String nombre_seccion, String departamento){
        Seccion seccion = new Seccion(idSeccion,  nombre_seccion,  departamento);
        return seccionDAO.insertar(seccion);
    }
    
    public Integer modificar(String idSeccion, String nombre_seccion, String departamento){
        Seccion seccion = new Seccion(idSeccion,  nombre_seccion,  departamento);
        return seccionDAO.modificar(seccion);
    }
    
    public Integer eliminar(String idSeccion){
        Seccion seccion = new Seccion();
        seccion.setIdSeccion(idSeccion);
        return seccionDAO.eliminar(seccion);
    }
    
    public ArrayList<Seccion> listarTodos(){
        return seccionDAO.listarTodos();
    }
    
    public Seccion obtenerPorId(String idSeccion){
        return seccionDAO.obtenerPorId(idSeccion);
    }       
}
