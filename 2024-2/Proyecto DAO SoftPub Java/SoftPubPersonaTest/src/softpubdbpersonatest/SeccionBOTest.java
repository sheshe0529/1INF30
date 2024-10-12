package softpubdbpersonatest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.bo.SeccionBO;
import pe.edu.pucp.softpub.persona.model.Seccion;

/**
 *
 * Autor: andres
 */
public class SeccionBOTest {

    private static SeccionBO seccionBO;

    public static void testSeccionBO() {
        System.out.println("\ntestSeccionBO");
        seccionBO = new SeccionBO();
        testSeccionBOInsertarSecciones();
        testSeccionBOListarTodos();
        testSeccionBOModificarSecciones();
        testSeccionBOListarTodos();
        testSeccionBOObtenerPorId();
        testSeccionBOEliminarSecciones();
    }

    private static void testSeccionBOEliminarSecciones() {
        System.out.println("\ntestSeccionBOEliminarSecciones");
        int resultado = seccionBO.eliminar("INF");
        resultado = seccionBO.eliminar("MEC");
        resultado = seccionBO.eliminar("ELE");
        resultado = seccionBO.eliminar("TEL");
    }

    private static void testSeccionBOObtenerPorId() {
        System.out.println("\ntestSeccionBOObtenerPorId");
        Seccion seccion = seccionBO.obtenerPorId("MEC");
        if (seccion != null) {
            System.out.print(seccion.getIdSeccion());
            System.out.print(", ");
            System.out.print(seccion.getSeccion());
            System.out.print(", ");
            System.out.println(seccion.getDepartamento());
        } else {
            System.out.println("No existe la seccion MEC\n");
        }

        seccion = seccionBO.obtenerPorId("TEL");
        if (seccion != null) {
            System.out.print(seccion.getIdSeccion());
            System.out.print(", ");
            System.out.print(seccion.getSeccion());
            System.out.print(", ");
            System.out.println(seccion.getDepartamento());
        } else {
            System.out.println("No existe la seccion TEL");
        }
    }

    private static void testSeccionBOListarTodos() {
        System.out.println("\ntestSeccionBOListarTodos");
        ArrayList<Seccion> listaSeccion = seccionBO.listarTodos();
        for (Seccion seccion : listaSeccion) {
            System.out.print(seccion.getIdSeccion());
            System.out.print(", ");
            System.out.print(seccion.getSeccion());
            System.out.print(", ");
            System.out.println(seccion.getDepartamento());
        }
    }

    private static void testSeccionBOModificarSecciones() {
        System.out.println("\ntestSeccionBOModificarSecciones");
        int resultado = seccionBO.modificar("INF", "INFORMÁTICA", "Ingeniería");
        resultado = seccionBO.modificar("TEL", "TELECO", "Ingeniería");

    }

    private static void testSeccionBOInsertarSecciones() {
        System.out.println("\ntestSeccionBOInsertarSecciones");
        int resultado = seccionBO.insertar("INF", "Ingeniería Informática", "Ingeniería");
        resultado = seccionBO.insertar("TEL", "Ingeniería de las Telecomunicaciones", "Ingeniería");
        resultado = seccionBO.insertar("ELE", "Ingeniería Electrónica", "Ingeniería");
        resultado = seccionBO.insertar("MEC", "Ingeniería Mecánica", "Ingeniería");
    }

}
