package softpubgrupotest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.grupo.bo.GrupoBO;
import pe.edu.pucp.softpub.grupo.model.Grupo;

class GrupoBOTest {

    private static GrupoBO grupoBO;
    private static ArrayList<Grupo> listaGrupos;

    static void testGrupoBO() {
        System.out.println("\ntestGrupoBO");
        grupoBO = new GrupoBO();
        ArrayList<Integer> listaId = new ArrayList<>();
        testGrupoBOInsertar(listaId);
        testGrupoBOListarTodos();
        testGrupoBOModificar(listaId);
        testGrupoBOListarTodos();
        testGrupoBOObtenerPorId(listaId);
        testGrupoBOEliminar();
    }

    private static void testGrupoBOEliminar() {
        System.out.println("\ntestGrupoBOEliminar");
        for (Grupo grupo : listaGrupos) {
            grupoBO.eliminar(grupo.getIdGrupo());
        }
    }

    private static void testGrupoBOObtenerPorId(ArrayList<Integer> listaId) {
        System.out.println("\ntestGrupoBOObtenerPorId");
        for (Integer id : listaId) {
            Grupo grupo = grupoBO.obtenerPorId(id);
            System.out.println(grupo.getIdGrupo() + " - " + grupo.getNombre());
        }
    }

    private static void testGrupoBOModificar(ArrayList<Integer> listaId) {
        System.out.println("\ntestGrupoBOModificar");

        grupoBO.modificar(listaId.get(0), "Inteligencia Artificial PUCP", "IA-PUCP");
        grupoBO.modificar(listaId.get(1), "Ciclo de Vida y Ecología Industrial", "PELCAN");
        grupoBO.modificar(listaId.get(2), "Altas Energías", "GAE-PUCP");

    }

    private static void testGrupoBOListarTodos() {
        System.out.println("\ntestGrupoBOListarTodos");
        listaGrupos = grupoBO.listarTodos();
        for (Grupo grupo : listaGrupos) {
            System.out.print(grupo.getIdGrupo());
            System.out.print(", ");
            System.out.print(grupo.getNombre());
            System.out.print(", ");
            System.out.println(grupo.getSigla());
        }

    }

    private static void testGrupoBOInsertar(ArrayList<Integer> listaId) {
        System.out.println("\ntestGrupoBOInsertar");

        Integer id = grupoBO.insertar("Grupo de Inteligencia Artificial PUCP", "IA-PUCP");
        System.out.println("idGrupo: " + id);
        listaId.add(id);

        id = grupoBO.insertar("Red Peruana Ciclo de Vida y Ecología Industrial", "PELCAN");
        System.out.println("idGrupo: " + id);
        listaId.add(id);

        id = grupoBO.insertar("Grupo de Altas Energías", "GAE-PUCP");
        System.out.println("idGrupo: " + id);
        listaId.add(id);
    }
}
