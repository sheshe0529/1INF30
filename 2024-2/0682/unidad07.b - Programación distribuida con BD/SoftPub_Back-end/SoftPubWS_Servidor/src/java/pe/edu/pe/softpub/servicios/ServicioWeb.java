package pe.edu.pe.softpub.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.bo.EspecialidadBO;
import pe.edu.pucp.softpub.persona.bo.SeccionBO;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;
import pe.edu.pucp.softpub.persona.model.Seccion;

@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    private final SeccionBO seccionBO;
    private final EspecialidadBO especialidadBO;

    public ServicioWeb() {
        this.seccionBO = new SeccionBO();
        this.especialidadBO = new EspecialidadBO();
    }

    @WebMethod(operationName = "seccion_insertar")
    public Integer seccion_insertar(@WebParam(name = "idSeccion") String idSeccion, @WebParam(name = "nombre_seccion") String nombre_seccion, @WebParam(name = "departamento") String departamento) {
        return seccionBO.insertar(idSeccion, nombre_seccion, departamento);
    }

    @WebMethod(operationName = "seccion_modificar")
    public Integer seccion_modificar(@WebParam(name = "idSeccion") String idSeccion, @WebParam(name = "nombre_seccion") String nombre_seccion, @WebParam(name = "departamento") String departamento) {
        return seccionBO.modificar(idSeccion, nombre_seccion, departamento);
    }

    @WebMethod(operationName = "seccion_eliminar")
    public Integer seccion_eliminar(@WebParam(name = "idSeccion") String idSeccion) {
        return seccionBO.eliminar(idSeccion);
    }

    @WebMethod(operationName = "seccion_listarTodos")
    public ArrayList<Seccion> seccion_listarTodos() {
        return seccionBO.listarTodos();
    }

    @WebMethod(operationName = "seccion_obtenerPorId")
    public Seccion seccion_obtenerPorId(@WebParam(name = "idSeccion") String idSeccion) {
        return seccionBO.obtenerPorId(idSeccion);
    }

    @WebMethod(operationName = "especialidad_insertar")
    public Integer especialidad_insertar(@WebParam(name = "idEspecialidad")Integer idEspecialidad, @WebParam(name = "nombre_especialidad")String nombre_especialidad, @WebParam(name = "facultad")String facultad, @WebParam(name = "nivel")Nivel nivel) {
        return this.especialidadBO.insertar(idEspecialidad,  nombre_especialidad,  facultad,  nivel);
    }
    
    @WebMethod(operationName = "especialidad_modificar")
    public Integer especialidad_modificar(@WebParam(name = "idEspecialidad")Integer idEspecialidad, @WebParam(name = "nombre_especialidad")String nombre_especialidad, @WebParam(name = "facultad")String facultad, @WebParam(name = "nivel")Nivel nivel) {
        return this.especialidadBO.modificar(idEspecialidad,  nombre_especialidad,  facultad,  nivel);                
    }
    
    @WebMethod(operationName = "especialidad_eliminar")
    public Integer especialidad_eliminar(@WebParam(name = "idEspecialidad")Integer idEspecialidad){        
        return this.especialidadBO.eliminar(idEspecialidad);
    }
    
    @WebMethod(operationName = "especialidad_listarTodos")
    public ArrayList<Especialidad> especialidad_listarTodos(){
        return this.especialidadBO.listarTodos();
    }
    
    @WebMethod(operationName = "especialidad_obtenerPorId")
    public Especialidad especialidad_obtenerPorId(@WebParam(name = "idEspecialidad")Integer idEspecialidad){
        return this.especialidadBO.obtenerPorId(idEspecialidad);
    }
}
