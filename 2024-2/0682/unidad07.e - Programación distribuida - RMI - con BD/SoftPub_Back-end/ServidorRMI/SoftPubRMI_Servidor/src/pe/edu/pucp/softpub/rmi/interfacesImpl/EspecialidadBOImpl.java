package pe.edu.pucp.softpub.rmi.interfacesImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;
import pe.edu.pucp.softpub.rmi.interfaces.EspecialidadBO;


public class EspecialidadBOImpl extends UnicastRemoteObject implements EspecialidadBO{

    private pe.edu.pucp.softpub.persona.bo.EspecialidadBO especialidadBO;
    
    public EspecialidadBOImpl(Integer puerto) throws RemoteException{
        super(puerto);
        this.especialidadBO = new pe.edu.pucp.softpub.persona.bo.EspecialidadBO();
    }
    
    @Override
    public Integer insertar(Integer idEspecialidad, String nombre_especialidad, String facultad, Nivel nivel) throws RemoteException {
        return this.especialidadBO.insertar(idEspecialidad, nombre_especialidad, facultad, nivel);
    }

    @Override
    public Integer modificar(Integer idEspecialidad, String nombre_especialidad, String facultad, Nivel nivel) throws RemoteException {
        return this.especialidadBO.modificar(idEspecialidad, nombre_especialidad, facultad, nivel);
    }

    @Override
    public Integer eliminar(Integer idEspecialidad) throws RemoteException {
        return this.especialidadBO.eliminar(idEspecialidad);
    }

    @Override
    public ArrayList<Especialidad> listarTodos() throws RemoteException {
        return this.especialidadBO.listarTodos();
    }

    @Override
    public Especialidad obtenerPorId(Integer idEspecialidad) throws RemoteException {
        return this.especialidadBO.obtenerPorId(idEspecialidad);
    }

}
