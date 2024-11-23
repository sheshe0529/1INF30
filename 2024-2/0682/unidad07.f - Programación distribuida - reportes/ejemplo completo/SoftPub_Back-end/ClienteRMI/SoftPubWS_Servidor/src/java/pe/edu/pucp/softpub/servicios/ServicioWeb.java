package pe.edu.pucp.softpub.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.net.MalformedURLException;
import java.util.ArrayList;
import pe.edu.pucp.softpub.rmi.servidor.interfaces.EspecialidadBO;
import pe.edu.pucp.softpub.rmi.servidor.interfaces.SeccionBO;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;
import pe.edu.pucp.softpub.persona.model.Seccion;
import pe.edu.pucp.softpub.rmi.servidor.SoftPubRMI_Servidor;

@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    //idealmente estos atributos se leen de un archivo
    private final String IP = "127.0.0.1";
    private final Integer puerto = 1234;

    private SeccionBO seccionBO = null;
    private EspecialidadBO especialidadBO = null;

    public ServicioWeb() {
        try {
            String nombreServicio = SoftPubRMI_Servidor.retornaNombreDelServicio("seccionBO");
            this.seccionBO = (SeccionBO) Naming.lookup(nombreServicio);
            nombreServicio = SoftPubRMI_Servidor.retornaNombreDelServicio("especialidadBO");
            this.especialidadBO = (EspecialidadBO) Naming.lookup(nombreServicio);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "seccion_insertar")
    public Integer seccion_insertar(@WebParam(name = "idSeccion") String idSeccion, @WebParam(name = "nombre_seccion") String nombre_seccion, @WebParam(name = "departamento") String departamento) {
        Integer resultado = null;
        try {
            resultado = this.seccionBO.insertar(idSeccion, nombre_seccion, departamento);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @WebMethod(operationName = "seccion_modificar")
    public Integer seccion_modificar(@WebParam(name = "name") String idSeccion, @WebParam(name = "nombre_seccion") String nombre_seccion, @WebParam(name = "departamento") String departamento) {
        Integer resultado = null;
        try {
            resultado = this.seccionBO.modificar(idSeccion, nombre_seccion, departamento);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @WebMethod(operationName = "seccion_eliminar")
    public Integer seccion_eliminar(@WebParam(name = "idSeccion") String idSeccion) {
        Integer resultado = null;
        try {
            resultado = this.seccionBO.eliminar(idSeccion);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @WebMethod(operationName = "seccion_listarTodos")
    public ArrayList<Seccion> seccion_listarTodos() {
        ArrayList<Seccion> lista = null;
        try {
            lista =  this.seccionBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @WebMethod(operationName = "seccion_obtenerPorId")
    public Seccion seccion_obtenerPorId(@WebParam(name = "idSeccion") String idSeccion) {
        Seccion seccion = null;
        try {
            seccion = this.seccionBO.obtenerPorId(idSeccion);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seccion;
    }

    @WebMethod(operationName = "especialidad_insertar")
    public Integer especialidad_insertar(@WebParam(name = "idEspecialidad") Integer idEspecialidad, @WebParam(name = "nombre_especialidad") String nombre_especialidad, @WebParam(name = "facultad") String facultad, @WebParam(name = "nivel") Nivel nivel) {
        Integer resultado = null;
        try {
            resultado= especialidadBO.insertar(idEspecialidad, nombre_especialidad, facultad, nivel);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @WebMethod(operationName = "especialidad_modificar")
    public Integer especialidad_modificar(@WebParam(name = "idEspecialidad") Integer idEspecialidad, @WebParam(name = "nombre_especialidad") String nombre_especialidad, @WebParam(name = "facultad") String facultad, @WebParam(name = "nivel") Nivel nivel) {
        Integer resultado = null;
        try {
            resultado= especialidadBO.modificar(idEspecialidad, nombre_especialidad, facultad, nivel);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @WebMethod(operationName = "especialidad_eliminar")
    public Integer especialidad_eliminar(@WebParam(name = "idEspecialidad") Integer idEspecialidad) {
        Integer resultado = null;
        try {
            resultado = especialidadBO.eliminar(idEspecialidad);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @WebMethod(operationName = "especialidad_listarTodos")
    public ArrayList<Especialidad> especialidad_listarTodos() {
        ArrayList<Especialidad> lista = null;
        try {
            lista = especialidadBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @WebMethod(operationName = "especialidad_obtenerPorId")
    public Especialidad especialidad_obtenerPorId(@WebParam(name = "idEspecialidad") Integer idEspecialidad) {
        Especialidad especialidad = null;
        try {
            especialidad = especialidadBO.obtenerPorId(idEspecialidad);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especialidad;
    }
}
