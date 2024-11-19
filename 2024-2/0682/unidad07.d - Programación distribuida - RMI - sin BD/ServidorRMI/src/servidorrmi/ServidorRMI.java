package servidorrmi;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorRMI {

    //colocar "127.0.0.1" o 1234 es conocido como hard code
    //no es una buena práctica y no se puede usar para la TA
    private static String IP = "127.0.0.1"; //==localhost
    private static Integer puerto = 1234;
    
    public static void main(String[] args) {
        System.out.println("Inicio de registro de servidor");
        
        try {
            LocateRegistry.createRegistry(puerto);
            
            InterfazRemota objetoRemoto = new ClaseRemota(puerto);
            
            String nombreServicio = "//" + IP + ":" + puerto + "/" + "objetoRemoto";
            Naming.rebind(nombreServicio, objetoRemoto);
            
            System.out.println("Servidor RMI registrado correctamente...");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
