package softpubpublicaciontest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.publicacion.bo.CapituloBO;

class CapituloBOTest {

    private static CapituloBO capituloBO;
    private static ArrayList<Integer> listaId;
    
    static void testCapituloBO() {
        System.out.println("\ntestCapituloBO");
        capituloBO = new CapituloBO();
        listaId = new ArrayList<>();
        testCapituloBOInsertar(listaId);
        testCapituloBOListarTodos();
        testCapituloBOModificar(listaId);
        testCapituloBOListarTodos();
        testCapituloBOObtenerPorId(listaId);
        testCapituloBOEliminar(listaId);
    }

    private static void testCapituloBOEliminar(ArrayList<Integer> listaId) {
        System.out.println("\ntestCapituloBOEliminar");
    }

    private static void testCapituloBOObtenerPorId(ArrayList<Integer> listaId) {
        System.out.println("\ntestCapituloBOObtenerPorId");
    }

    private static void testCapituloBOListarTodos() {
        System.out.println("\ntestCapituloBOListarTodos");
    }

    private static void testCapituloBOModificar(ArrayList<Integer> listaId) {
        System.out.println("\ntestCapituloBOModificar");
    }

    private static void testCapituloBOInsertar(ArrayList<Integer> listaId) {
        System.out.println("\ntestCapituloBOInsertar");
    }

}
