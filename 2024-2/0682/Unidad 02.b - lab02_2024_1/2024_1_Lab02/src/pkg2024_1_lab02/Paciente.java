package pkg2024_1_lab02;

import java.util.ArrayList;

public class Paciente  extends Persona{
    private Integer HCE;
    private ArrayList<AtencionMedica> atencionesMedicas;

    public Paciente(String DNI, String nombre, String paterno, String materno, Integer HCE) {
        super(DNI, nombre, paterno, materno);
        this.HCE = HCE;
    }
    public void listarCitasMedicasProgramadas() {
        for (AtencionMedica atencionMedica: atencionesMedicas){
            if (atencionMedica instanceof CitaMedica)
                System.out.println(atencionMedica.toString());
        }
    }

    /**
     * @return the HCE
     */
    public Integer getHCE() {
        return HCE;
    }

    /**
     * @param HCE the HCE to set
     */
    public void setHCE(Integer HCE) {
        this.HCE = HCE;
    }

    /**
     * @return the atencionesMedicas
     */
    public ArrayList<AtencionMedica> getAtencionesMedicas() {
        return atencionesMedicas;
    }

    /**
     * @param atencionesMedicas the atencionesMedicas to set
     */
    public void setAtencionesMedicas(ArrayList<AtencionMedica> atencionesMedicas) {
        this.atencionesMedicas = atencionesMedicas;
    }

    @Override
    public String devolverInformacion() {
        return this.toString();
    }    
    
}
