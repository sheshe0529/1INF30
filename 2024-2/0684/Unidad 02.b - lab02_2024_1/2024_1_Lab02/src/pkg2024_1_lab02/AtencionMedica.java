package pkg2024_1_lab02;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import static pkg2024_1_lab02.Estado_de_atencion.PROGRAMADA;

public abstract class AtencionMedica {
    private static Integer correlativo=1;
    private Integer identificador;
    private Paciente paciente;
    private Medico medico;
    private Date fecha_creacion;
    private Date fecha_atencion;
    private Estado_de_atencion estado;
    
    public AtencionMedica(Paciente paciente, Medico medico, Date fecha_atencion) {
        this.identificador=AtencionMedica.correlativo++;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha_creacion = new Date();
        this.fecha_atencion = fecha_atencion;
        this.estado = Estado_de_atencion.PROGRAMADA;
    }

    /**
     * @return the correlativo
     */
    public static Integer getCorrelativo() {
        return correlativo;
    }

    /**
     * @param aCorrelativo the correlativo to set
     */
    public static void setCorrelativo(Integer aCorrelativo) {
        correlativo = aCorrelativo;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the fecha_creacion
     */
    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * @param fecha_creacion the fecha_creacion to set
     */
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    /**
     * @return the fecha_atencion
     */
    public Date getFecha_atencion() {
        return fecha_atencion;
    }

    /**
     * @param fecha_atencion the fecha_atencion to set
     */
    public void setFecha_atencion(Date fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }

    /**
     * @return the estado
     */
    public Estado_de_atencion getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado_de_atencion estado) {
        this.estado = estado;
    }

    /**
     * @return the identificador
     */
    public Integer getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        String resultado = "ID: ".concat(this.identificador.toString().concat("- "));
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        resultado = resultado.concat("CREACION: ").concat(formateador.format(this.fecha_creacion)).concat(" - ");
        resultado = resultado.concat("ATENCION: ").concat(formateador.format(this.fecha_atencion)).concat(" - ");
        switch(this.estado){
            case PROGRAMADA -> resultado = resultado.concat("PROGRAMADA");
            case CONFIRMADA  -> resultado = resultado.concat("CONFIRMADA");
            case CANCELADA -> resultado = resultado.concat("CANCELADA");
            case EN_CURSO -> resultado = resultado.concat("EN CURSO");
        }
        resultado = resultado.concat("\n");
        resultado = resultado.concat("MEDICO: ");
        resultado = resultado.concat("PACIENTE: ");
        return resultado;
    }
}
