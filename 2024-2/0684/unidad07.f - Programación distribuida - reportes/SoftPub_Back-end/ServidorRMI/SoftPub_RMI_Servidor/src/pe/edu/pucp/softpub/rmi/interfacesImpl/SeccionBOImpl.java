package pe.edu.pucp.softpub.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.model.Seccion;
import pe.edu.pucp.softpub.rmi.interfaces.SeccionBO;

public class SeccionBOImpl extends UnicastRemoteObject implements SeccionBO {

    private pe.edu.pucp.softpub.persona.bo.SeccionBO seccionBO;
    
    public SeccionBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
        this.seccionBO = new pe.edu.pucp.softpub.persona.bo.SeccionBO();
    }

    @Override
    public Integer insertar(String idSeccion, String nombre_seccion, String departamento) throws RemoteException {
        return this.seccionBO.insertar(idSeccion, nombre_seccion, departamento);
    }

    @Override
    public Integer modificar(String idSeccion, String nombre_seccion, String departamento) throws RemoteException {
        return this.seccionBO.modificar(idSeccion, nombre_seccion, departamento);
    }

    @Override
    public Integer eliminar(String idSeccion) throws RemoteException {
        return this.seccionBO.eliminar(idSeccion);
    }

    @Override
    public ArrayList<Seccion> listarTodos() throws RemoteException {
        return this.seccionBO.listarTodos();
    }

    @Override
    public Seccion obtenerPorId(String idSeccion) throws RemoteException {
        return this.seccionBO.obtenerPorId(idSeccion);
    }

}
