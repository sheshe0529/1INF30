package softpubpublicaciontest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.publicacion.bo.LibroBO;

class LibroBOTest {

    private static LibroBO libroBO;
    private static ArrayList<Integer> listaId;
    
    static void testLibroBO() {
        System.out.println("\ntestLibroBO");
        libroBO = new LibroBO();
        listaId = new ArrayList<>();
        testLibroBOInsertar(listaId);
        testLibroBOListarTodos();
        testLibroBOModificar(listaId);
        testLibroBOListarTodos();
        testLibroBOObtenerPorId(listaId);
        testLibroBOEliminar(listaId);
    }

    private static void testLibroBOEliminar(ArrayList<Integer> listaId) {
        System.out.println("\ntestLibroBOEliminar");
    }

    private static void testLibroBOObtenerPorId(ArrayList<Integer> listaId) {
        System.out.println("\ntestLibroBOObtenerPorId");
    }

    private static void testLibroBOListarTodos() {
        System.out.println("\ntestLibroBOListarTodos");
    }

    private static void testLibroBOModificar(ArrayList<Integer> listaId) {
        System.out.println("\ntestLibroBOModificar");
    }

    private static void testLibroBOInsertar(ArrayList<Integer> listaId) {
        System.out.println("\ntestLibroBOInsertar");
    }

}
