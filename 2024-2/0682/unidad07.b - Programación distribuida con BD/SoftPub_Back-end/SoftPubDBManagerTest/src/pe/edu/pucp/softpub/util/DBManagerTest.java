package pe.edu.pucp.softpub.util;

import pe.edu.pucp.softpub.db.DBManager;
import java.sql.Connection;

public class DBManagerTest {

    public static void main(String[] args) {
        //instanciación del dbManager
        DBManager dbManager = null;
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);

        //creación de la conexión a la base de datos
        Connection conexion = dbManager.getConnection();        
    }
}
