package servidorrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClaseRemota extends UnicastRemoteObject implements InterfazRemota{

    public ClaseRemota(Integer puerto) throws RemoteException{
        super(puerto);
    }
    
    @Override
    public String retornarNombre() throws RemoteException {
        return "Programción 3";
    }

    @Override
    public Double retornarNota(Double e1, Double e2) throws RemoteException {
        return e1*0.3 + e2*0.7;
    }

}
