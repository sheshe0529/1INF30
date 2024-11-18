package clientermi;

import java.net.MalformedURLException;
import servidorrmi.InterfazRemota;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteRMI {
    //el colocar constantes en el código (p.e. localhost, 1234) se conoce como HardCode
    //no es una buena práctica, estos datos deben colocarse en un archivo   
    private static String IP = "localhost";
    private static Integer puerto = 1234;
    
    public static void main(String[] args) {
        try {
            System.out.println("Inicio del cliente RMI");
            String nombreServicio = "//" + IP + ":" + puerto + "/" + "objetoRemoto";
            InterfazRemota objetoRemoto = (InterfazRemota) Naming.lookup(nombreServicio);
            
            System.out.println("El nombre retornado es: " + objetoRemoto.retornarNombre());
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
