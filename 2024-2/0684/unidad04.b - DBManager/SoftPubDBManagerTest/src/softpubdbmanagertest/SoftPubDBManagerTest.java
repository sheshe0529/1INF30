package softpubdbmanagertest;

import java.sql.Connection;
import pe.edu.pucp.softpub.config.DBManager;

public class SoftPubDBManagerTest {

    public static void main(String[] args) {
        //DBManager dbManager = new DBManager();
        DBManager dbManager = null;
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        Connection conexion = dbManager.getConnection();        
    }
    
}
