package pe.edu.pucp.softpub.grupo.model;

import java.util.ArrayList;

/**
 *
 * Autor: andres
 */
public class Linea {

    private Grupo grupo;
    private Integer idLinea;
    private String nombre;
    protected ArrayList<ProductosLinea> productos;

    public Linea(Grupo grupo, Integer idLinea, String nombre) {
        this.grupo = grupo;
        this.idLinea = idLinea;
        this.nombre = nombre;
        this.productos = null;
    }
    
    public Linea() {
        this.grupo = null;
        this.idLinea = null;
        this.nombre = null;
        this.productos = null;
    }

    /**
     * @return the grupo
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the idLinea
     */
    public Integer getIdLinea() {
        return idLinea;
    }

    /**
     * @param idLinea the idLinea to set
     */
    public void setIdLinea(Integer idLinea) {
        this.idLinea = idLinea;
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
}
