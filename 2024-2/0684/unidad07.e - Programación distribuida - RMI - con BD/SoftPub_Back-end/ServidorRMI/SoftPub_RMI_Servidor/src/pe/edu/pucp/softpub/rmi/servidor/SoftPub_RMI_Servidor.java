package pe.edu.pucp.softpub.rmi.servidor;


import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.rmi.interfaces.EspecialidadBO;
import pe.edu.pucp.softpub.rmi.interfaces.SeccionBO;
import pe.edu.pucp.softpub.rmi.interfacesImpl.EspecialidadBOImpl;
import pe.edu.pucp.softpub.rmi.interfacesImpl.SeccionBOImpl;
        
public class SoftPub_RMI_Servidor {

    //estos atributos se deben leer de un rmi.properties
    private static String IP = "127.0.0.1";
    private static Integer puerto = 1234;
    
    public static void main(String[] args) {
        try {
            //registramos el servicio
            LocateRegistry.createRegistry(puerto);
            
            //inicializamos objetos remotos
            SeccionBO seccionBO = new SeccionBOImpl(puerto);
            EspecialidadBO especialidadBO = new EspecialidadBOImpl(puerto);
            
            //colocamos los objetos en el servidor
            String nombreServicio = retornaNombreDelServicio("seccionBO");
            Naming.rebind(nombreServicio, seccionBO);
            
            nombreServicio = retornaNombreDelServicio("especialidadBO");
            Naming.rebind(nombreServicio, especialidadBO);
            
            System.out.println("Servidor RMI registrado correctamente...");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(SoftPub_RMI_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String retornaNombreDelServicio(String nombreObjetoRemoto) {
        return "//" + IP + ":" + puerto + "/" + nombreObjetoRemoto;
    }

}
