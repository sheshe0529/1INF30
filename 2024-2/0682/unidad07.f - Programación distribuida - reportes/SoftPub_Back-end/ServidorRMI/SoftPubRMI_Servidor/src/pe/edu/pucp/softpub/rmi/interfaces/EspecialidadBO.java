package pe.edu.pucp.softpub.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;

public interface EspecialidadBO extends Remote {

    public Integer insertar(Integer idEspecialidad, String nombre_especialidad, String facultad, Nivel nivel) throws  RemoteException;

    public Integer modificar(Integer idEspecialidad, String nombre_especialidad, String facultad, Nivel nivel) throws  RemoteException;

    public Integer eliminar(Integer idEspecialidad) throws  RemoteException;

    public ArrayList<Especialidad> listarTodos() throws  RemoteException;

    public Especialidad obtenerPorId(Integer idEspecialidad) throws  RemoteException;
}
