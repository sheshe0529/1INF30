package publicaciones_v02;

/**
 *
 * @author amelgar
 */
public class Libro extends Publicacion {
    private String edicion;
    private String lugar;
    private String editorial;

    public Libro(String nombre, String[] autores, Integer cantidad_autores, Integer año, String edicion, String lugar, String editorial) {
        super(nombre, autores, cantidad_autores, año);
        this.edicion = edicion;
        this.lugar = lugar;
        this.editorial = editorial;
    }

    public Libro(String nombre, String autor, Integer año, String edicion, String lugar, String editorial) {
        super(nombre, autor, año);
        this.edicion = edicion;
        this.lugar = lugar;
        this.editorial = editorial;
    }
    
    
}
