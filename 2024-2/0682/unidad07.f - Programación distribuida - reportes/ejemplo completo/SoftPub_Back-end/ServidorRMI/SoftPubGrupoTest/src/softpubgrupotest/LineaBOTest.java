package softpubgrupotest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.grupo.bo.GrupoBO;
import pe.edu.pucp.softpub.grupo.bo.LineaBO;
import pe.edu.pucp.softpub.grupo.model.Linea;

class LineaBOTest {

    private static GrupoBO grupoBO;
    private static LineaBO lineaBO;

    static void testLineaBO() {
        System.out.println("\ntestLineaBO");
        grupoBO = new GrupoBO();
        lineaBO = new LineaBO();
        ArrayList<Integer> listaIdGrupo = new ArrayList<>();
        testLineaBOInsertar(listaIdGrupo);
        testLineaBOListarTodos(listaIdGrupo);
        testLineaBOModificar(listaIdGrupo);
        testLineaBOListarTodos(listaIdGrupo);
        testLineaBOObtenerPorId(listaIdGrupo);
        testLineaBOEliminar(listaIdGrupo);
    }

    private static void testLineaBOEliminar(ArrayList<Integer> listaIdGrupo) {
        System.out.println("\ntestLineaBOEliminar");
        for (Integer idGrupo : listaIdGrupo) {
            lineaBO.eliminar(idGrupo, 1);
            lineaBO.eliminar(idGrupo, 2);
            lineaBO.eliminar(idGrupo, 3);
            grupoBO.eliminar(idGrupo);
        }
    }

    private static void testLineaBOObtenerPorId(ArrayList<Integer> listaIdGrupo) {
        System.out.println("\ntestLineaBOObtenerPorId");
        Linea linea = lineaBO.obtenerPorId(listaIdGrupo.get(0), 2);
        System.out.println("línea obtenida: " + linea.getNombre());
        
        linea = lineaBO.obtenerPorId(listaIdGrupo.get(1), 3);
        System.out.println("línea obtenida: " + linea.getNombre());
        
        linea = lineaBO.obtenerPorId(listaIdGrupo.get(1), 10);
        if (linea == null)
            System.out.println("línea inexistente");
        else
            System.out.println("línea obtenida: " + linea.getNombre());
    }

    private static void testLineaBOListarTodos(ArrayList<Integer> listaIdGrupo) {
        System.out.println("\ntestLineaBOListarTodos");
        for (Integer idGrupo : listaIdGrupo) {
            System.out.println("\ntestLineaBOListarTodos - idGrupo : " + idGrupo);
            ArrayList<Linea> listaLineas = lineaBO.listarTodos(idGrupo);
            for (Linea linea : listaLineas) {
                System.out.print(linea.getGrupo().getIdGrupo());
                System.out.print(", ");
                System.out.print(linea.getIdLinea());
                System.out.print(", ");
                System.out.println(linea.getNombre());
            }
        }
    }

    private static void testLineaBOModificar(ArrayList<Integer> listaIdGrupo) {
        System.out.println("\ntestLineaBOModificar");
        lineaBO.modificar(listaIdGrupo.get(0), 1, "Bioinformatics");
        lineaBO.modificar(listaIdGrupo.get(0), 2, "PLN");
        lineaBO.modificar(listaIdGrupo.get(0), 3, "Web Semántica");
        
        lineaBO.modificar(listaIdGrupo.get(1), 1, "Ciclo de Vida");
        lineaBO.modificar(listaIdGrupo.get(1), 2, "Carbono");
        lineaBO.modificar(listaIdGrupo.get(1), 3, "Huella");
    }

    private static void testLineaBOInsertar(ArrayList<Integer> listaIdGrupo) {
        System.out.println("\ntestLineaBOInsertar");
        Integer idGrupo = grupoBO.insertar("Grupo de Inteligencia Artificial PUCP", "IA-PUCP");
        System.out.println("idGrupo: " + idGrupo);
        listaIdGrupo.add(idGrupo);

        lineaBO.insertar(idGrupo, 1, "BioInformática");
        lineaBO.insertar(idGrupo, 2, "Procesamiento de Lenguaje Natural");
        lineaBO.insertar(idGrupo, 3, "Ingeniería del Conocimiento");

        idGrupo = grupoBO.insertar("Red Peruana Ciclo de Vida y Ecología Industrial", "PELCAN");
        System.out.println("idGrupo: " + idGrupo);
        listaIdGrupo.add(idGrupo);

        lineaBO.insertar(idGrupo, 1, "Análisis de Ciclo de Vida Ambiental");
        lineaBO.insertar(idGrupo, 2, "Huella de Carbono");
        lineaBO.insertar(idGrupo, 3, "Huella Hídrica");
    }

}
