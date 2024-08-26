package publicaciones_v02;

/**
 *
 * @author amelgar
 */
public class Tesis  extends Publicacion{
    private String clase;
    private String departamento;
    private String institucion;
    private String ciudad;
    private String estado;

    public Tesis(String nombre, String[] autores, Integer cantidad_autores, Integer año, String clase, String departamento, String institucion, String ciudad, String estado) {
        super(nombre, autores, cantidad_autores, año);
        this.clase = clase;
        this.departamento = departamento;
        this.institucion = institucion;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public Tesis(String nombre, String autor, Integer año, String clase, String departamento, String institucion, String ciudad, String estado) {
        super(nombre, autor, año);
        this.clase = clase;
        this.departamento = departamento;
        this.institucion = institucion;
        this.ciudad = ciudad;
        this.estado = estado;
    }
    
    
}
