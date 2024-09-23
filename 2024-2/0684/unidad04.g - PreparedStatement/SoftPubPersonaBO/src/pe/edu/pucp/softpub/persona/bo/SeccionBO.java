package pe.edu.pucp.softpub.persona.bo;

import pe.edu.pucp.softpub.persona.dao.SeccionDAO;
import pe.edu.pucp.softpub.persona.daoImp.SeccionDAOImpl;
import pe.edu.pucp.softpub.persona.model.Seccion;

public class SeccionBO {
    
    private SeccionDAO seccionDAO;
    
    public SeccionBO(){
        this.seccionDAO = new SeccionDAOImpl();
    }
    
    public Integer insertar(String idSeccion, String nombre_seccion, String departamento){
        Seccion seccion = new Seccion(idSeccion, nombre_seccion, departamento);
        return seccionDAO.insertar(seccion);
    }

    public void listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
