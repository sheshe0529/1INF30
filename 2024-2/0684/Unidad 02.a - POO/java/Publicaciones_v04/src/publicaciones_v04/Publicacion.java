package publicaciones_v04;

public abstract class Publicacion {
    public static Integer orden_presentacion = 1;
    protected String nombre;
    protected String autores[];
    protected Integer cantidad_autores;
    protected Integer año;

    public Publicacion(String nombre, String[] autores, Integer cantidad_autores, Integer año) {
        this.nombre = nombre;
        this.autores = autores;
        this.cantidad_autores = cantidad_autores;
        this.año = año;
    }
    
    public Publicacion(String nombre, String autor, Integer año) {
        this.nombre = nombre;
        this.autores = new String[1];
        this.autores[0] = autor;
        this.cantidad_autores = 1;
        this.año = año;
    }

    public abstract void referenciar();    
    
}
