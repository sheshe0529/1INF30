package pe.edu.pucp.softpub.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;
import pe.edu.pucp.softpub.rmi.interfaces.EspecialidadBO;

public class EspecialidadBOImpl extends UnicastRemoteObject implements EspecialidadBO {

    public EspecialidadBOImpl(Integer puerto) throws RemoteException {
        super(puerto);
    }

    @Override
    public Integer insertar(Integer idEspecialidad, String nombre_especialidad, String facultad, Nivel nivel) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Integer idEspecialidad, String nombre_especialidad, String facultad, Nivel nivel) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Integer idEspecialidad) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Especialidad> listarTodos() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Especialidad obtenerPorId(Integer idEspecialidad) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
