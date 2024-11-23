package pe.edu.pucp.softpub.rmi.servidor.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.model.Seccion;

public interface SeccionBO extends Remote{
    
    public Integer insertar(String idSeccion, String nombre_seccion, String departamento) throws RemoteException;
    
    public Integer modificar(String idSeccion, String nombre_seccion, String departamento) throws RemoteException;
    
    public Integer eliminar(String idSeccion) throws RemoteException;
    
    public ArrayList<Seccion> listarTodos() throws RemoteException;
    
    public Seccion obtenerPorId(String idSeccion) throws RemoteException;
}
