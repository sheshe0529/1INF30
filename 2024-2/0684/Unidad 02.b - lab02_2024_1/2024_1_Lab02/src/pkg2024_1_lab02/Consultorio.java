package pkg2024_1_lab02;

public class Consultorio  extends AmbienteClinico{
    private String numero;

    public Consultorio(Double metraje, char torre, Integer piso, String numero) {
        super(metraje, torre, piso);
        this.numero = numero;
    }
    
    

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String devolverInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
