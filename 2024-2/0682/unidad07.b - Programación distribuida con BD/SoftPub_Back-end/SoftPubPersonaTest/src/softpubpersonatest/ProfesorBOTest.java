package softpubpersonatest;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.persona.bo.ProfesorBO;
import pe.edu.pucp.softpub.persona.bo.SeccionBO;
import pe.edu.pucp.softpub.persona.model.Categoria;
import pe.edu.pucp.softpub.persona.model.Dedicacion;
import pe.edu.pucp.softpub.persona.model.Genero;
import pe.edu.pucp.softpub.persona.model.Profesor;
import pe.edu.pucp.softpub.persona.model.Seccion;
import pe.edu.pucp.softpub.util.MuestraFecha;

/**
 *
 * Autor: andres
 */
public class ProfesorBOTest {

    private static ProfesorBO profesorBO;
    private static SeccionBO seccionBO;
    private static ArrayList<Profesor> listaProfesores;

    static void testProfesorBO() {
        System.out.println("\ntestProfesorBO");
        profesorBO = new ProfesorBO();
        seccionBO = new SeccionBO();

        ArrayList<Integer> listaId = new ArrayList<>();
        testProfesorBOInsertar(listaId);
        testProfesorBOListarTodos();
        testProfesorBOModificar(listaId);
        testProfesorBOListarTodos();
        testProfesorBOObtenerPorId(listaId);
        testProfesorBOEliminar();
        testBorrarSecciones();
    }

    private static void testBorrarSecciones() {
        System.out.println("\ntestBorrarSecciones");
        seccionBO.eliminar("INF");
    }

    private static void testProfesorBOEliminar() {
        System.out.println("\ntestProfesorBOEliminar");
        for (Profesor profesor : listaProfesores) {
            profesorBO.eliminar(profesor.getIdPersona());            
        }
    }
    
    private static void testProfesorBOObtenerPorId(ArrayList<Integer> listaId) {
        System.out.println("\ntestProfesorBOObtenerPorId");
        for (Integer id : listaId) {
            Profesor profesor = profesorBO.obtenerPorId(id);
            System.out.println("idPersona: " + profesor.getIdPersona() + " " + profesor.getPaterno() + " " + profesor);
        }
    }

    private static void testProfesorBOModificar(ArrayList<Integer> listaId) {
        System.out.println("\ntestProfesorBOModificar");
        Date fechaModificacion = new Date();
        String usuarioModificacion = "fpaz";
        Seccion seccion = seccionBO.obtenerPorId("INF");

        Integer resultado = profesorBO.modificar(listaId.get(0), "MELGAR", "Sasieta", "Héctor Andrés", Genero.MASCULINO, fechaModificacion, usuarioModificacion, Categoria.PRINCIPAL, Dedicacion.TC, true, seccion);
        resultado = profesorBO.modificar(listaId.get(1), "PAZ", "Espinoza", "Fredy Alberto", Genero.MASCULINO, fechaModificacion, usuarioModificacion, Categoria.PRINCIPAL, Dedicacion.TC, true, seccion);
        resultado = profesorBO.modificar(listaId.get(2), "SANCHEZ", "Enriquez", "Heider Ysaias", Genero.MASCULINO, fechaModificacion, usuarioModificacion, Categoria.PRINCIPAL, Dedicacion.TC, true, seccion);
    }

    private static void testProfesorBOListarTodos() {
        System.out.println("\ntestProfesorBOListarTodos");
        listaProfesores = profesorBO.listarTodos();
        for (Profesor profesor : listaProfesores) {
            System.out.print(profesor.getIdPersona().toString());
            System.out.print(", ");
            System.out.print(profesor.getPaterno());
            System.out.print(", ");
            System.out.print(profesor.getMaterno());
            System.out.print(", ");
            System.out.print(profesor.getNombre());
            System.out.print(", ");
            System.out.print(profesor.getGenero().toString());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(profesor.getFechaCreacion()));
            System.out.print(", ");
            System.out.print(profesor.getUsuarioCreacion());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(profesor.getFechaModificacion()));
            System.out.print(", ");
            System.out.print(profesor.getUsuarioModificacion());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(profesor.getFechaEliminacion()));
            System.out.print(", ");
            System.out.print(profesor.getSeccion().getIdSeccion());
            System.out.print(", ");
            System.out.print(profesor.getCategoria());
            System.out.print(", ");
            System.out.print(profesor.getDedicacion());
            System.out.print(", ");
            System.out.println(profesor.getActivo());
        }
    }

    private static void testProfesorBOInsertar(ArrayList<Integer> listaId) {
        System.out.println("\ntestProfesorBOInsertar");
        Integer resultado = seccionBO.insertar("INF", "Ingeniería Informática", "Ingeniería");
        Seccion seccion = seccionBO.obtenerPorId("INF");

        Date fechaCreacion = new Date();
        String usuarioCreacion = "amelgar";
        resultado = profesorBO.insertar("Melgar", "Sasieta", "Héctor Andrés", Genero.MASCULINO, fechaCreacion, usuarioCreacion, Categoria.PRINCIPAL, Dedicacion.TC, true, seccion);
        System.out.println("Llave primaria insertada: " + resultado);
        listaId.add(resultado);
        resultado = profesorBO.insertar("Paz", "Espinoza", "Fredy Alberto", Genero.MASCULINO, fechaCreacion, usuarioCreacion, Categoria.ASOCIADO, Dedicacion.TC, true, seccion);
        System.out.println("Llave primaria insertada: " + resultado);
        listaId.add(resultado);
        resultado = profesorBO.insertar("Sanchez", "Enriquez", "Heider Ysaias", Genero.MASCULINO, fechaCreacion, usuarioCreacion, Categoria.CONTRATADO, Dedicacion.TPA, true, seccion);
        System.out.println("Llave primaria insertada: " + resultado);
        listaId.add(resultado);
    }    
}
