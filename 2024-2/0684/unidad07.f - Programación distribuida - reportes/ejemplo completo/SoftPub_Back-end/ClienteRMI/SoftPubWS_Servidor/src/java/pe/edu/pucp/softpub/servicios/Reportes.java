package pe.edu.pucp.softpub.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import pe.edu.pucp.softpub.reportes.ReporteUtil;

@WebService(serviceName="Reportes")
public class Reportes {

    @WebMethod(operationName="reporteSeccion")
    public byte[] reporteSeccion() {
        return ReporteUtil.reporteSeccion(null);        
    }
    
    @WebMethod(operationName="reporteEspecialidad")
    public byte[] reporteEspecialidad(Integer idEspecialidad) {
        return ReporteUtil.reporteEspecialidad(null, idEspecialidad);        
    }
}


