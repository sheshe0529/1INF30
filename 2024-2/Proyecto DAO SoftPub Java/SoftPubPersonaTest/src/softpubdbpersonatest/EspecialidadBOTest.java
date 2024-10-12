package softpubdbpersonatest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.bo.EspecialidadBO;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;

/**
 *
 * Autor: andres
 */
public class EspecialidadBOTest {

    private static EspecialidadBO especialidadBO;

    static void testEspecialidadBO() {
        System.out.println("\ntestEspecialidadBO");
        especialidadBO = new EspecialidadBO();
        testEspecialidadBOInsertar();
        testEspecialidadBOListarTodos();
        testEspecialidadBOModificar();
        testEspecialidadBOListarTodos();
        testEspecialidadBOObtenerPorId();
        testEspecialidadBOEliminar();        
    }

    private static void testEspecialidadBOEliminar() {
        System.out.println("\ntestEspecialidadBOEliminar");
        int resultado = especialidadBO.eliminar(1);
        resultado = especialidadBO.eliminar(2);
    }

    private static void testEspecialidadBOObtenerPorId() {
        System.out.println("\ntestEspecialidadBOObtenerPorId");
        Especialidad especialidad = especialidadBO.obtenerPorId(1);
        System.out.println("objetoPorId: 1 - " + especialidad);
        System.out.print(especialidad.getIdEspecialidad().toString());
        System.out.print(", ");
        System.out.print(especialidad.getEspecialidad());
        System.out.print(", ");
        System.out.print(especialidad.getFacultad());
        System.out.print(", ");
        System.out.println(especialidad.getNivel().toString());

        especialidad = especialidadBO.obtenerPorId(2);
        System.out.println("objetoPorId: 2 - " + especialidad);
        System.out.print(especialidad.getIdEspecialidad().toString());
        System.out.print(", ");
        System.out.print(especialidad.getEspecialidad());
        System.out.print(", ");
        System.out.print(especialidad.getFacultad());
        System.out.print(", ");
        System.out.println(especialidad.getNivel().toString());

        especialidad = especialidadBO.obtenerPorId(3);
        System.out.println("objetoPorId: 3 - " + especialidad);        
    }

    private static void testEspecialidadBOModificar() {
        System.out.println("\ntestEspecialidadBOModificar");
        int resultado = especialidadBO.modificar(1, "Ingeniería Informática", "FCI", Nivel.PREGRADO);
        resultado = especialidadBO.modificar(2, "Maestría en Informática", "EP", Nivel.MAESTRIA);
    }

    private static void testEspecialidadBOListarTodos() {
        System.out.println("\ntestEspecialidadBOListarTodos");
        ArrayList<Especialidad> lista = especialidadBO.listarTodos();
        for (Especialidad especialidad : lista) {
            System.out.print(especialidad.getIdEspecialidad().toString());
            System.out.print(", ");
            System.out.print(especialidad.getEspecialidad());
            System.out.print(", ");
            System.out.print(especialidad.getFacultad());
            System.out.print(", ");
            System.out.println(especialidad.getNivel().toString());
        }
    }

    private static void testEspecialidadBOInsertar() {
        System.out.println("\ntestEspecialidadBOInsertar");
        int resultado = especialidadBO.insertar(1, "Ingeniería Informática", "Ciencias e Ingeniería", Nivel.PREGRADO);
        resultado = especialidadBO.insertar(2, "Maestría en Informática", "Escuela de Posgrado", Nivel.MAESTRIA);
    }
}
