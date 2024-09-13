package softpubpersonatest;

import pe.edu.pucp.softpub.persona.bo.EspecialidadBO;
import pe.edu.pucp.softpub.persona.bo.SeccionBO;
import pe.edu.pucp.softpub.persona.model.Nivel;

public class SoftPubPersonaTest {

    public static void main(String[] args) {
        //SeccionBOTest();
        EspecialidadBOTest();
    }

    private static void SeccionBOTest() {
        SeccionBO seccionBO = new SeccionBO();
        seccionBO.insertar("INF", "Informática", "Ingeniería");
        seccionBO.insertar("TEL", "Telecomunicaciones", "Ingeniería");
        
        //seccionBO.modificar("INF", "Ingeniería Informática", "Ingeniería");
        //seccionBO.modificar("TEL", "Ingeniería de las Telecomunicaciones", "Ingeniería");
    }

    private static void EspecialidadBOTest() {
        EspecialidadBO especialidadBO = new EspecialidadBO();
        especialidadBO.insertar(1, "Informática", "Ciencias e Ingeniería", Nivel.PREGRADO);
        especialidadBO.insertar(2, "Maestría en Informática", "Escuela de Posgrado", Nivel.DOCTORADO);
    }
    
}
