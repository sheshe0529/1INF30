package softpubpublicaciontest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.publicacion.bo.ConferenciaBO;

class ConferenciaBOTest {

    private static ConferenciaBO conferenciaBO;
    private static ArrayList<Integer> listaId;
    
    static void testConferenciaBO() {
        System.out.println("\ntestConferenciaBO");
        conferenciaBO = new ConferenciaBO();
        listaId = new ArrayList<>();
        testConferenciaBOInsertar(listaId);
        testConferenciaBOListarTodos();
        testConferenciaBOModificar(listaId);
        testConferenciaBOListarTodos();
        testConferenciaBOObtenerPorId(listaId);
        testConferenciaBOEliminar(listaId);
    }

    private static void testConferenciaBOEliminar(ArrayList<Integer> listaId) {
        System.out.println("\ntestConferenciaBOEliminar");
    }

    private static void testConferenciaBOObtenerPorId(ArrayList<Integer> listaId) {
        System.out.println("\ntestConferenciaBOObtenerPorId");
    }

    private static void testConferenciaBOListarTodos() {
        System.out.println("\ntestConferenciaBOListarTodos");
    }

    private static void testConferenciaBOModificar(ArrayList<Integer> listaId) {
        System.out.println("\ntestConferenciaBOModificar");
    }

    private static void testConferenciaBOInsertar(ArrayList<Integer> listaId) {
        System.out.println("\ntestConferenciaBOInsertar");
    }

}
