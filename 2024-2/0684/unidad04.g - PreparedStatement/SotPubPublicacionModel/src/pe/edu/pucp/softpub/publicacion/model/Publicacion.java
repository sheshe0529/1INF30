package pe.edu.pucp.softpub.publicacion.model;

import java.util.Date;

public class Publicacion {
    
    private Integer idPüblicacion;
    private String titulo;
    private Tipo tipo;
    private String origen;
    private String volumen;
    private String numero;
    private String paginaInicio;
    private String paginaFin;
    private Date fechaPublicacion;
    private String DOI;
    private String ISSN;
    private String ISBN;
    private String edicion;
    private String lugar;
    private String editorial;
    private String departamento;
    private String institucion;
    private String ciudad;
    private String estado;

    public Publicacion(Integer idPüblicacion, String titulo, Tipo tipo, String origen, String volumen, String numero, String paginaInicio, String paginaFin, Date fechaPublicacion, String DOI, String ISSN, String ISBN, String edicion, String lugar, String editorial, String departamento, String institucion, String ciudad, String estado) {
        this.idPüblicacion = idPüblicacion;
        this.titulo = titulo;
        this.tipo = tipo;
        this.origen = origen;
        this.volumen = volumen;
        this.numero = numero;
        this.paginaInicio = paginaInicio;
        this.paginaFin = paginaFin;
        this.fechaPublicacion = fechaPublicacion;
        this.DOI = DOI;
        this.ISSN = ISSN;
        this.ISBN = ISBN;
        this.edicion = edicion;
        this.lugar = lugar;
        this.editorial = editorial;
        this.departamento = departamento;
        this.institucion = institucion;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public Publicacion() {
        this.idPüblicacion = null;
        this.titulo = null;
        this.tipo = null;
        this.origen = null;
        this.volumen = null;
        this.numero = null;
        this.paginaInicio = null;
        this.paginaFin = null;
        this.fechaPublicacion = null;
        this.DOI = null;
        this.ISSN = null;
        this.ISBN = null;
        this.edicion = null;
        this.lugar = null;
        this.editorial = null;
        this.departamento = null;
        this.institucion = null;
        this.ciudad = null;
        this.estado = null;
    }
    
    /**
     * @return the idPüblicacion
     */
    public Integer getIdPüblicacion() {
        return idPüblicacion;
    }

    /**
     * @param idPüblicacion the idPüblicacion to set
     */
    public void setIdPüblicacion(Integer idPüblicacion) {
        this.idPüblicacion = idPüblicacion;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the volumen
     */
    public String getVolumen() {
        return volumen;
    }

    /**
     * @param volumen the volumen to set
     */
    public void setVolumen(String volumen) {
        this.volumen = volumen;
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

    /**
     * @return the paginaInicio
     */
    public String getPaginaInicio() {
        return paginaInicio;
    }

    /**
     * @param paginaInicio the paginaInicio to set
     */
    public void setPaginaInicio(String paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    /**
     * @return the paginaFin
     */
    public String getPaginaFin() {
        return paginaFin;
    }

    /**
     * @param paginaFin the paginaFin to set
     */
    public void setPaginaFin(String paginaFin) {
        this.paginaFin = paginaFin;
    }

    /**
     * @return the fechaPublicacion
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return the DOI
     */
    public String getDOI() {
        return DOI;
    }

    /**
     * @param DOI the DOI to set
     */
    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    /**
     * @return the ISSN
     */
    public String getISSN() {
        return ISSN;
    }

    /**
     * @param ISSN the ISSN to set
     */
    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
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

    /**
     * @return the institucion
     */
    public String getInstitucion() {
        return institucion;
    }

    /**
     * @param institucion the institucion to set
     */
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
         
           
}
