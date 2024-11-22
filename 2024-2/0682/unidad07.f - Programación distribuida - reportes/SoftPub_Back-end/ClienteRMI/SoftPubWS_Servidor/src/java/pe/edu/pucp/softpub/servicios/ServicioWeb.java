package pe.edu.pucp.softpub.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;
import pe.edu.pucp.softpub.persona.model.Seccion;
import pe.edu.pucp.softpub.rmi.interfaces.EspecialidadBO;
import pe.edu.pucp.softpub.rmi.interfaces.SeccionBO;
import pe.edu.pucp.softpub.rmi.servidor.SoftPubRMI_Servidor;

@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    //datos del servidor RMI
    private String IP = "localhost";
    private Integer puerto = 1234;

    //interfaces remotas
    private SeccionBO seccionBO;
    private EspecialidadBO especialidadBO;

    public ServicioWeb() {
        try {
            String nombreServicio = SoftPubRMI_Servidor.retornarNombreDelServicio("seccionBO");
            this.seccionBO = (SeccionBO) Naming.lookup(nombreServicio);

            nombreServicio = SoftPubRMI_Servidor.retornarNombreDelServicio("especialidadBO");
            this.especialidadBO = (EspecialidadBO) Naming.lookup(nombreServicio);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "seccion_insertar")
    public Integer seccion_insertar(@WebParam(name = "idSeccion") String idSeccion, @WebParam(name = "nombre_seccion") String nombre_seccion, @WebParam(name = "departamento") String departamento) {
        Integer retorno = null;
        try {
            retorno = this.seccionBO.insertar(idSeccion, nombre_seccion, departamento);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "seccion_modificar")
    public Integer seccion_modificar(@WebParam(name = "name") String idSeccion, @WebParam(name = "nombre_seccion") String nombre_seccion, @WebParam(name = "departamento") String departamento) {
        Integer retorno = null;
        try {
            retorno = this.seccionBO.modificar(idSeccion, nombre_seccion, departamento);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "seccion_eliminar")
    public Integer seccion_eliminar(@WebParam(name = "idSeccion") String idSeccion) {
        Integer retorno = null;
        try {
            retorno = this.seccionBO.eliminar(idSeccion);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "seccion_listarTodos")
    public ArrayList<Seccion> seccion_listarTodos() {
        ArrayList<Seccion> retorno = null;
        try {
            retorno = this.seccionBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "seccion_obtenerPorId")
    public Seccion seccion_obtenerPorId(@WebParam(name = "idSeccion") String idSeccion) {
        Seccion retorno = null;
        try {
            retorno = this.seccionBO.obtenerPorId(idSeccion);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "especialidad_insertar")
    public Integer especialidad_insertar(@WebParam(name = "idEspecialidad") Integer idEspecialidad, @WebParam(name = "nombre_especialidad") String nombre_especialidad, @WebParam(name = "facultad") String facultad, @WebParam(name = "nivel") Nivel nivel) {
        Integer retorno = null;
        try {
            retorno = especialidadBO.insertar(idEspecialidad, nombre_especialidad, facultad, nivel);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "especialidad_modificar")
    public Integer especialidad_modificar(@WebParam(name = "idEspecialidad") Integer idEspecialidad, @WebParam(name = "nombre_especialidad") String nombre_especialidad, @WebParam(name = "facultad") String facultad, @WebParam(name = "nivel") Nivel nivel) {
        Integer retorno = null;
        try {
            retorno = especialidadBO.modificar(idEspecialidad, nombre_especialidad, facultad, nivel);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "especialidad_eliminar")
    public Integer especialidad_eliminar(@WebParam(name = "idEspecialidad") Integer idEspecialidad) {
        Integer retorno = null;
        try {
            retorno = especialidadBO.eliminar(idEspecialidad);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "especialidad_listarTodos")
    public ArrayList<Especialidad> especialidad_listarTodos() {
        ArrayList<Especialidad> retorno = null;
        try {
            retorno = especialidadBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "especialidad_obtenerPorId")
    public Especialidad especialidad_obtenerPorId(@WebParam(name = "idEspecialidad") Integer idEspecialidad) {
        Especialidad retorno = null;
        try {
            retorno = especialidadBO.obtenerPorId(idEspecialidad);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
