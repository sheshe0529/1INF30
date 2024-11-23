package pe.edu.pucp.softpub.rmi.servidor;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.rmi.servidor.interfaces.EspecialidadBO;
import pe.edu.pucp.softpub.rmi.servidor.interfaces.SeccionBO;
import pe.edu.pucp.softpub.rmi.servidor.interfacesImpl.EspecialidadBOImpl;
import pe.edu.pucp.softpub.rmi.servidor.interfacesImpl.SeccionBOImpl;
    
public class SoftPubRMI_Servidor {

    private static String IP = "127.0.0.1";
    private static Integer puerto = 1234;

    public static void main(String[] args) {
        try {
            //registramos el servicio RMI
            LocateRegistry.createRegistry(puerto);
            
            //inicializamos los objetos remotos
            SeccionBO seccionBO = new SeccionBOImpl(puerto);
            EspecialidadBO especialidadBO = new EspecialidadBOImpl(puerto);

            //colocamos los objetos en el servicio RMI
            String nombreServicio = retornaNombreDelServicio("seccionBO");
            Naming.rebind(nombreServicio, seccionBO);
            nombreServicio = retornaNombreDelServicio("especialidadBO");
            Naming.rebind(nombreServicio, especialidadBO);
            
            //imprimimos mensaje de confirmación del inicialización del servidor
            System.out.println("El servidor RMI se ha inicializado correctamente.");            
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(SoftPubRMI_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String retornaNombreDelServicio(String nombreObjetoRemoto) {
        return "//" + IP + ":" + puerto + "/" + nombreObjetoRemoto;
    }

}
