package softpubdbpersonatest;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.persona.bo.AlumnoBO;
import pe.edu.pucp.softpub.persona.bo.EspecialidadBO;
import pe.edu.pucp.softpub.persona.model.Alumno;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Genero;
import pe.edu.pucp.softpub.persona.model.Nivel;
import pe.edu.pucp.softpub.util.MuestraFecha;

public class AlumnoBOTest {

    private static AlumnoBO alumnoBO;
    private static EspecialidadBO especialidadBO;
    private static ArrayList<Alumno> listaAlumnos;

    static void testAlumnoBO() {
        System.out.println("\ntestAlumnoBO");
        alumnoBO = new AlumnoBO();
        especialidadBO = new EspecialidadBO();

        ArrayList<Integer> listaId = new ArrayList<>();
        testAlumnoBOInsertar(listaId);
        testAlumnoBOListarTodos();
        testAlumnoBOModificar(listaId);
        testAlumnoBOListarTodos();
        testAlumnoBOObtenerPorId(listaId);
        testAlumnoBOEliminar();
        testBorrarEspecialidades();
    }

    private static void testBorrarEspecialidades() {
        System.out.println("\ntestBorrarEspecialidades");
        int resultado = especialidadBO.eliminar(1);
    }

    private static void testAlumnoBOEliminar() {
        System.out.println("\ntestAlumnoBOEliminar");
        for (Alumno alumno : listaAlumnos) {
            alumnoBO.eliminar(alumno.getIdPersona());            
        }
    }

    private static void testAlumnoBOObtenerPorId(ArrayList<Integer> listaId) {
        System.out.println("\ntestAlumnoBOObtenerPorId");
        for (Integer id : listaId) {
            Alumno alumno = alumnoBO.obtenerPorId(id);
            System.out.println("idPersona: " + alumno.getIdPersona() + " " + alumno.getPaterno() + " " + alumno);
        }
    }

    private static void testAlumnoBOListarTodos() {
        System.out.println("\ntestAlumnoBOListarTodos");
        listaAlumnos = alumnoBO.listarTodos();
        for (Alumno alumno : listaAlumnos) {
            System.out.print(alumno.getIdPersona().toString());
            System.out.print(", ");
            System.out.print(alumno.getPaterno());
            System.out.print(", ");
            System.out.print(alumno.getMaterno());
            System.out.print(", ");
            System.out.print(alumno.getNombre());
            System.out.print(", ");
            System.out.print(alumno.getGenero().toString());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(alumno.getFechaCreacion()));
            System.out.print(", ");
            System.out.print(alumno.getUsuarioCreacion());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(alumno.getFechaModificacion()));
            System.out.print(", ");
            System.out.print(alumno.getUsuarioModificacion());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(alumno.getFechaEliminacion()));
            System.out.print(", ");
            System.out.print(alumno.getEspecialidad().getIdEspecialidad());
            System.out.print(", ");
            System.out.println(alumno.getMatriculado());
        }
    }

    private static void testAlumnoBOModificar(ArrayList<Integer> listaId) {
        System.out.println("\ntestAlumnoBOModificar");
        Date fechaModificacion = new Date();
        String usuarioModificacion = "fpaz";
         Especialidad especialidad = especialidadBO.obtenerPorId(1);

        Integer resultado = alumnoBO.modificar(listaId.get(0), "MELGAR", "Sasieta", "Héctor Andrés", Genero.MASCULINO, fechaModificacion, usuarioModificacion, false, especialidad);
        resultado = alumnoBO.modificar(listaId.get(1), "PAZ", "Espinoza", "Fredy Alberto", Genero.MASCULINO, fechaModificacion, usuarioModificacion, false, especialidad);
        resultado = alumnoBO.modificar(listaId.get(2), "SANCHEZ", "Enriquez", "Heider Ysaias", Genero.MASCULINO, fechaModificacion, usuarioModificacion, false, especialidad);
    }

    private static void testAlumnoBOInsertar(ArrayList<Integer> listaId) {
        System.out.println("\ntestAlumnoBOInsertar");
        int resultado = especialidadBO.insertar(1, "Ingeniería Informática", "Ciencias e Ingeniería", Nivel.PREGRADO);
        Especialidad especialidad = especialidadBO.obtenerPorId(1);
        
        Date fechaCreacion = new Date();
        String usuarioCreacion = "amelgar";
        resultado = alumnoBO.insertar("Melgar", "Sasieta", "Héctor Andrés", Genero.MASCULINO, fechaCreacion, usuarioCreacion, true, especialidad);
        System.out.println("Llave primaria insertada: " + resultado);
        listaId.add(resultado);
        resultado = alumnoBO.insertar("Paz", "Espinoza", "Fredy Alberto", Genero.MASCULINO, fechaCreacion, usuarioCreacion, true, especialidad);
        System.out.println("Llave primaria insertada: " + resultado);
        listaId.add(resultado);
        resultado = alumnoBO.insertar("Sanchez", "Enriquez", "Heider Ysaias", Genero.MASCULINO, fechaCreacion, usuarioCreacion, false, especialidad);
        System.out.println("Llave primaria insertada: " + resultado);
        listaId.add(resultado);
    }

}
