package softpubgrupotest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.grupo.bo.GrupoBO;

class GrupoBoTest {
    
    private static GrupoBO grupoBo;

    static void testGrupoBo() {
        System.out.println("\ntestGrupoBo");
        grupoBo = new GrupoBO();
        ArrayList<Integer> listaId = new ArrayList<>();
        testGrupoBoInsertar(listaId);
    }

    private static void testGrupoBoInsertar(ArrayList<Integer> listaId) {
        Integer id = grupoBo.insertar("Grupo de Inteligencia Artificial PUCP", "IA-PUCP");
        System.out.println("idGrupo: " + id);
        listaId.add(id);
    }

}
