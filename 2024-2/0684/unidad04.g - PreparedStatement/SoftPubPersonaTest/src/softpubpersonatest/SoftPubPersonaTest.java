package softpubpersonatest;

import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.bo.EspecialidadBO;
import pe.edu.pucp.softpub.persona.bo.SeccionBO;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;

public class SoftPubPersonaTest {

    public static void main(String[] args) {
        //SeccionBOTest();
        EspecialidadBOTest();
    }

    private static void SeccionBOTest() {
        SeccionBO seccionBO = new SeccionBO();                
        
        //seccionBO.insertar("INF", "Informática", "Ingeniería");
        //seccionBO.insertar("TEL", "Telecomunicaciones", "Ingeniería");
    }

    private static void EspecialidadBOTest() {
        EspecialidadBO especialidadBO = new EspecialidadBO();
        
        ArrayList<Especialidad> listaEspecialidad;
        listaEspecialidad = especialidadBO.listarTodos();
        for(Especialidad especialidad: listaEspecialidad){
            System.out.print(especialidad.getIdEspecialidad() + " - ");
            System.out.println(especialidad.getEspecialidad());
        }
        //especialidadBO.insertar(1, "Ingeniería Informática", "Ciencias e Ingeniería", Nivel.PREGRADO);
        //especialidadBO.insertar(2, "Maestría en Informática", "Escuela de Posgrado", Nivel.MAESTRIA);
    }

}
