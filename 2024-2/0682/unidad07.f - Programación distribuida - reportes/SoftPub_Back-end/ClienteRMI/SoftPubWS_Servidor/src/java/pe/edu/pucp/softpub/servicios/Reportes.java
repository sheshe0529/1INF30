package pe.edu.pucp.softpub.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.softpub.db.DBManager;
import pe.edu.pucp.softpub.reportes.ReporteUtil;
import pe.edu.pucp.softpub.servlet.ReporteSeccionServlet;

@WebService(serviceName="Reportes")
public class Reportes {
    
    @WebMethod(operationName="reporteSeccion")
    public byte[] reporteSeccion() {
        return ReporteUtil.reporteSeccion(null);        
    }
}
