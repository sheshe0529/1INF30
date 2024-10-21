package pe.edu.pucp.softpub.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    public int sumar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a + b;
    }

    public int multiplicar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a * b;
    }
}
