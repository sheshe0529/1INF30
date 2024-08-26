package pkg2024_1_lab02;

import java.util.Date;

public abstract class CitaMedica extends AtencionMedica{
    private String motivo;

    public CitaMedica(Paciente paciente, Medico medico, Date fecha_atencion, String motivo) {
        super(paciente, medico, fecha_atencion);
        this.motivo = motivo;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
