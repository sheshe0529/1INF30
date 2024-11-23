package pe.edu.pucp.softpub.persona.bo;

import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.dao.EspecialidadDAO;
import pe.edu.pucp.softpub.persona.daoImpl.EspecialidadDAOImpl;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;

public class EspecialidadBO {

    private final EspecialidadDAO especialidadDAO;

    public EspecialidadBO() {
        this.especialidadDAO = new EspecialidadDAOImpl();
    }

    public Integer insertar(Integer idEspecialidad, String nombre_especialidad, String facultad, Nivel nivel) {
        Especialidad especialidad = new Especialidad(idEspecialidad, nombre_especialidad, facultad, nivel);
        return especialidadDAO.insertar(especialidad);
    }
    
    public Integer modificar(Integer idEspecialidad, String nombre_especialidad, String facultad, Nivel nivel) {
        Especialidad especialidad = new Especialidad(idEspecialidad, nombre_especialidad, facultad, nivel);
        return especialidadDAO.modificar(especialidad);                
    }
    
    public Integer eliminar(Integer idEspecialidad){
        Especialidad especialidad = new Especialidad();
        especialidad.setIdEspecialidad(idEspecialidad);
        return especialidadDAO.eliminar(especialidad);
    }
    
    public ArrayList<Especialidad> listarTodos(){
        return especialidadDAO.listarTodos();
    }
    
    public Especialidad obtenerPorId(Integer idEspecialidad){
        return especialidadDAO.obtenerPorId(idEspecialidad);
    }
}
