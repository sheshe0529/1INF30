package pe.edu.pucp.softpub.persona.bo;

import pe.edu.pucp.softpub.persona.dao.EspecialidadDAO;
import pe.edu.pucp.softpub.persona.daoImp.EspecialidadDAOImpl;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;

public class EspecialidadBO {
    
    private EspecialidadDAO especialidadDAO;
    
    public EspecialidadBO(){
        this.especialidadDAO = new EspecialidadDAOImpl();
    }
    
    public Integer insertar(Integer idEspecialidad, String nombre_especialidad, String facultad, Nivel nivel){
        Especialidad especialidad = new Especialidad(idEspecialidad, nombre_especialidad, facultad, nivel);
        return this.especialidadDAO.insertar(especialidad);
    }
}
