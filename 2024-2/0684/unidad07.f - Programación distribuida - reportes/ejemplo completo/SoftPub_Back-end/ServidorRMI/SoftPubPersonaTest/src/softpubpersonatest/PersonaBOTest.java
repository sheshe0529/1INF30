package softpubpersonatest;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.persona.bo.PersonaBO;
import pe.edu.pucp.softpub.persona.model.Genero;
import pe.edu.pucp.softpub.persona.model.Persona;
import pe.edu.pucp.softpub.util.MuestraFecha;

public class PersonaBOTest {

    private static PersonaBO personaBO;
    private static ArrayList<Persona> listaPersonas;

    static void testPersonaBO() {
        System.out.println("\ntestPersonaBO");
        personaBO = new PersonaBO();
        ArrayList<Integer> listaId = new ArrayList<>();        
        testPersonaBOInsertar(listaId);
        testPersonaBOListarTodos();
        testPersonaBOModificar(listaId);
        testPersonaBOListarTodos();
        testPersonaBOObtenerPorId(listaId);  
        testPersonaBOExistePersona();
        testPersonaBOEliminar(listaId);
    }
    
    private static void testPersonaBOEliminar(ArrayList<Integer> listaId) {
        System.out.println("\ntestPersonaBOEliminar");
        for (Persona persona : listaPersonas) {
            personaBO.eliminar(persona.getIdPersona());
        }
    }       
    
    private static void testPersonaBOExistePersona() {
        System.out.println("\ntestPersonaBOExistePersona");
        Boolean existe = personaBO.existePersona("Melgar", "Sasieta", "Héctor Andrés");
        System.out.println("Existe persona: " + existe);
        existe = personaBO.existePersona("Paz", "Espinoza", "Fredy Alberto");
        System.out.println("Existe persona: " + existe);
        existe = personaBO.existePersona("Sanchez", "Enriquez", "Heider Ysaias");        
        System.out.println("Existe persona: " + existe);
        existe = personaBO.existePersona("Guanira", "Erazo", "Juan Miguel");        
        System.out.println("Existe persona: " + existe);
    }

    private static void testPersonaBOObtenerPorId(ArrayList<Integer> listaId) {
        System.out.println("\ntestPersonaBOObtenerPorId");
        for (Integer id : listaId) {
            Persona persona = personaBO.obtenerPorId(id);
            System.out.println("idPersona: " + persona.getIdPersona() + " " + persona.getPaterno() + " " + persona);
        }
    }
    
    private static void testPersonaBOModificar(ArrayList<Integer> listaId) {
        System.out.println("\ntestPersonaBOModificar");
        Date fechaModificacion = new Date();
        String usuarioModificacion = "fpaz";
        Integer resultado = personaBO.modificar(listaId.get(0), "MELGAR", "Sasieta", "Héctor Andrés", Genero.MASCULINO, fechaModificacion, usuarioModificacion);
        resultado = personaBO.modificar(listaId.get(1), "PAZ", "Espinoza", "Fredy Alberto", Genero.MASCULINO, fechaModificacion, usuarioModificacion);
        resultado = personaBO.modificar(listaId.get(2), "SANCHEZ", "Enriquez", "Heider Ysaias", Genero.MASCULINO, fechaModificacion, usuarioModificacion);
    }
    
    private static void testPersonaBOListarTodos() {
        System.out.println("\ntestPersonaBOListarTodos");
        listaPersonas = personaBO.listarTodos();
        for (Persona persona : listaPersonas) {
            System.out.print(persona.getIdPersona().toString());
            System.out.print(", ");
            System.out.print(persona.getPaterno());
            System.out.print(", ");
            System.out.print(persona.getMaterno());
            System.out.print(", ");
            System.out.print(persona.getNombre());
            System.out.print(", ");
            System.out.print(persona.getGenero().toString());
            System.out.print(", ");            
            System.out.print(MuestraFecha.toString(persona.getFechaCreacion()));
            System.out.print(", ");
            System.out.print(persona.getUsuarioCreacion());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(persona.getFechaModificacion()));
            System.out.print(", ");
            System.out.print(persona.getUsuarioModificacion());
            System.out.print(", ");
            System.out.println(MuestraFecha.toString(persona.getFechaEliminacion()));
        }
    }
    
    private static void testPersonaBOInsertar(ArrayList<Integer> listaId) {
        System.out.println("\ntestPersonaBOInsertar");
        Date fechaCreacion = new Date();
        String usuarioCreacion = "amelgar";
        Integer resultado = personaBO.insertar("Melgar", "Sasieta", "Héctor Andrés", Genero.MASCULINO, fechaCreacion, usuarioCreacion);
        System.out.println("Llave primaria insertada: " + resultado);
        listaId.add(resultado);
        resultado = personaBO.insertar("Paz", "Espinoza", "Fredy Alberto", Genero.MASCULINO, fechaCreacion, usuarioCreacion);
        System.out.println("Llave primaria insertada: " + resultado);
        listaId.add(resultado);
        resultado = personaBO.insertar("Sanchez", "Enriquez", "Heider Ysaias", Genero.MASCULINO, fechaCreacion, usuarioCreacion);
        System.out.println("Llave primaria insertada: " + resultado);
        listaId.add(resultado);
    }    
}