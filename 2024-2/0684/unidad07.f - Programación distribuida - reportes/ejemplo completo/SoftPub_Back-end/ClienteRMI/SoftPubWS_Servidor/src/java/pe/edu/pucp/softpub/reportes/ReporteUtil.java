package pe.edu.pucp.softpub.reportes;

import jakarta.servlet.http.HttpServletResponse;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.softpub.db.DBManager;
import pe.edu.pucp.softpub.servlet.ReporteSeccionServlet;

public class ReporteUtil {

    private static byte[] invocarReporte(HttpServletResponse response, String nombreReporte, HashMap parametros) {
        byte[] reporte = null;
        Connection conexion = DBManager.getInstance().getConnection();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ReporteUtil.class.getResource("/pe/edu/pucp/softpub/reportes/" + nombreReporte + ".jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
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

    public static byte[] reporteSeccion(HttpServletResponse response) {
        return invocarReporte(response, "ReporteSeccion", null);
    }

    public static byte[] reporteEspecialidad(HttpServletResponse response, Integer idEspecialidad) {
        URL rutaLogo = ReporteUtil.class.getResource("/pe/edu/pucp/softpub/reportes/pucp.png");
        Image logo = new ImageIcon(rutaLogo).getImage();
        
        HashMap parametros = new HashMap();
        parametros.put("pIdEspecialidad", idEspecialidad);
        parametros.put("pLogo", logo);
                
        return invocarReporte(response, "ReporteEspecialidad", parametros);
        
        /*byte[] reporte = null;
        Connection conexion = DBManager.getInstance().getConnection();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ReporteSeccionServlet.class.getResource("/pe/edu/pucp/softpub/reportes/ReporteEspecialidad.jasper"));

            HashMap parametro = new HashMap();
            parametro.put("pIdEspecialidad", idEspecialidad);

            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, conexion);
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
        return reporte;*/
    }

}
