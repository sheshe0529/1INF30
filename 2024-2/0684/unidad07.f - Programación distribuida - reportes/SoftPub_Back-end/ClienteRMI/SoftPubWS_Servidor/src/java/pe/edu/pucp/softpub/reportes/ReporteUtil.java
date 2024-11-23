package pe.edu.pucp.softpub.reportes;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
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
import pe.edu.pucp.softpub.servlet.ReporteSeccionServlet;

public class ReporteUtil {

    public static byte[] reporteSeccion(HttpServletResponse response) {
        byte[] reporte = null;
        Connection conexion = DBManager.getInstance().getConnection();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ReporteSeccionServlet.class.getResource("/pe/edu/pucp/softpub/reportes/ReporteSeccion.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion);
            if (response != null) {
                JasperExportManager.exportReportToPdfStream(jp, response.getOutputStream());
            } else {
                reporte = JasperExportManager.exportReportToPdf(jp);
            }
        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteSeccionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return reporte;
    }

}
