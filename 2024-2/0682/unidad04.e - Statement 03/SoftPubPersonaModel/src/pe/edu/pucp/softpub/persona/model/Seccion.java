package pe.edu.pucp.softpub.persona.model;

public class Seccion {
    private String idSeccion;
    private String seccion;
    private String departamento;

     public Seccion() {
        this.idSeccion = null;
        this.seccion = null;
        this.departamento = null;
    }
     
    public Seccion(String idSeccion, String seccion, String departamento) {
        this.idSeccion = idSeccion;
        this.seccion = seccion;
        this.departamento = departamento;
    }        

    /**
     * @return the idSeccion
     */
    public String getIdSeccion() {
        return idSeccion;
    }

    /**
     * @param idSeccion the idSeccion to set
     */
    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    /**
     * @return the seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
