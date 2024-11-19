package clientermi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorrmi.InterfazRemota;

public class ClienteRMI {

    //colocar "127.0.0.1" o 1234 es conocido como hard code
    //no es una buena práctica y no se puede usar para la TA
    private static String IP = "localhost";
    private static Integer puerto = 1234;
    
    public static void main(String[] args) {
        try {
            String nombreServicio = "//" + IP + ":" + puerto + "/" + "objetoRemoto";
            InterfazRemota objetoRemoto = (InterfazRemota) Naming.lookup(nombreServicio);
            
            System.out.println("El nombre es: " + objetoRemoto.retornarNombre());
            System.out.println("La nota es: " + objetoRemoto.retornarNota(17.0, 12.0));
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
