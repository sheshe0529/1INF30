package servidorrmi;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorRMI {
    //el colocar constantes en el código se conoce como HardCode
    //no es una buena práctica, estos datos deben colocarse en un archivo
    private static String IP = "127.0.0.1"; //=localhost
    private static Integer puerto = 1234;
    
    public static void main(String[] args) {
        System.out.println("Incio de registro de servidor RMI...");
        try {                        
            LocateRegistry.createRegistry(puerto);                        
            
            InterfazRemota objetoRemoto = new ClaseRemota(puerto);
            
            String nombreServicio = "//" + IP + ":" + puerto + "/" + "objetoRemoto";
            Naming.rebind(nombreServicio, objetoRemoto);            
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Servidor RMI registrado correctamente...");
    }

}
