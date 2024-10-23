package pe.edu.pucp.softpub.grupo.model;

import java.util.ArrayList;

/**
 *
 * Autor: andres
 */
public class Grupo {

    private Integer idGrupo;
    private String nombre;
    private String sigla;
    protected ArrayList<Linea> lineas;

    public Grupo(Integer idGrupo, String nombre, String sigla) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.sigla = sigla;
        this.lineas = null;
    }

    public Grupo() {
        this.idGrupo = null;
        this.nombre = null;
        this.sigla = null;
        this.lineas = null;
    }

    /**
     * @return the idGrupo
     */
    public Integer getIdGrupo() {
        return idGrupo;
    }

    /**
     * @param idGrupo the idGrupo to set
     */
    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
