package softpubdbmanagertest;

import pe.edu.pucp.softpub.config.DBManager;
import java.sql.Connection;

public class SoftPubDBManagerTest {

    public static void main(String[] args) {
        //DBManager dbManager = new DBManager();
        DBManager dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        
        Connection conexion = dbManager.getConnection();
    }
    
}
