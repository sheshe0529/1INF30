package softpubpublicaciontest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.publicacion.bo.EditorialBO;

class EditorialBOTest {

    private static EditorialBO editorialBO;
    private static ArrayList<Integer> listaId;
    
    static void testEditorialBO() {
        System.out.println("\ntestEditorialBO");
        editorialBO = new EditorialBO();
        listaId = new ArrayList<>();
        testEditorialBOInsertar(listaId);
        testEditorialBOListarTodos();
        testEditorialBOModificar(listaId);
        testEditorialBOListarTodos();
        testEditorialBOObtenerPorId(listaId);
        testEditorialBOEliminar(listaId);
    }

    private static void testEditorialBOEliminar(ArrayList<Integer> listaId) {
        System.out.println("\ntestEditorialBOEliminar");
    }

    private static void testEditorialBOObtenerPorId(ArrayList<Integer> listaId) {
        System.out.println("\ntestEditorialBOObtenerPorId");
    }

    private static void testEditorialBOListarTodos() {
        System.out.println("\ntestEditorialBOListarTodos");
    }

    private static void testEditorialBOModificar(ArrayList<Integer> listaId) {
        System.out.println("\ntestEditorialBOModificar");
    }

    private static void testEditorialBOInsertar(ArrayList<Integer> listaId) {
        System.out.println("\ntestEditorialBOInsertar");
    }

}
