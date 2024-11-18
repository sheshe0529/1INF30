package servidorrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazRemota extends Remote {

    public String retornarNombre() throws RemoteException;
    
    public Double retornarNota(Double e1, Double e2)  throws RemoteException;
}
