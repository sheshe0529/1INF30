package pe.edu.pucp.softpub.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "sumar")
    public int sumar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a + b;
    }

    @WebMethod(operationName = "multiplicar")
    public int multiplicar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a * b;
    }
}
