package softpubpublicaciontest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.publicacion.bo.ArticuloBO;

class ArticuloBOTest {

    private static ArticuloBO articuloBO;
    private static ArrayList<Integer> listaId;
    
    static void testArticuloBO() {
        System.out.println("\ntestPublicacionBO");
        articuloBO = new ArticuloBO();
        listaId = new ArrayList<>();
        testArticuloBOInsertar(listaId);
        testArticuloBOListarTodos();
        testArticuloBOModificar(listaId);
        testArticuloBOListarTodos();
        testArticuloBOObtenerPorId(listaId);
        testArticuloBOEliminar(listaId);
    }

    private static void testArticuloBOEliminar(ArrayList<Integer> listaId) {
        System.out.println("\ntestArticuloBOEliminar");
    }

    private static void testArticuloBOObtenerPorId(ArrayList<Integer> listaId) {
        System.out.println("\ntestArticuloBOObtenerPorId");
    }

    private static void testArticuloBOListarTodos() {
        System.out.println("\ntestArticuloBOListarTodos");
    }

    private static void testArticuloBOModificar(ArrayList<Integer> listaId) {
        System.out.println("\ntestArticuloBOModificar");
    }

    private static void testArticuloBOInsertar(ArrayList<Integer> listaId) {
        System.out.println("\ntestArticuloBOInsertar");
        String titulo = "Bootstrapping semi-supervised annotation method for potential suicidal messages";        
        String origen = "Internet Interventions";
        String volumen = "28";
        String numero = "100519";
        Integer paginaInicio = null;
        Integer paginaFin = null;
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaPublicacion = null;
        try {
            fechaPublicacion = formateador.parse("2022-03-07");
        } catch (ParseException ex) {
            Logger.getLogger(ArticuloBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String DOI = "10.1016/j.invent.2022.100519";
        String ISSN = "22147829";
      
        Integer id = articuloBO.insertar(titulo, origen, volumen, numero, paginaInicio, paginaFin, fechaPublicacion, DOI, ISSN);
        System.out.println("idPublicacion: " + id);
        listaId.add(id);
    }

}
