package pe.edu.pucp.inf30.sesiones.publicaciones00;

import java.util.ArrayList;

/**
 *
 * Autor: Andrés Melgar
 */
public abstract class Publicacion {

    protected class Autor {

        private String apellidos;
        private String nombres;

        public Autor(String nombre_completo_autor) {
            Integer posicion_coma = nombre_completo_autor.indexOf(",");
            this.apellidos = nombre_completo_autor.substring(0, posicion_coma).trim();
            this.nombres = nombre_completo_autor.substring(posicion_coma + 1).trim();
        }

        @Override
        public String toString() {
            String copia_nombre = this.nombres;
            String abreviatura = "";
            Integer posicion_blanco;
            do {
                posicion_blanco = copia_nombre.indexOf(" ");
                if (!abreviatura.equals(""))
                    abreviatura = abreviatura.concat(" ");
                abreviatura = abreviatura.concat(copia_nombre.substring(0, 1));
                abreviatura = abreviatura.concat(".");
                if (posicion_blanco != -1) {
                    copia_nombre = copia_nombre.substring(posicion_blanco + 1).trim();
                }
            } while (posicion_blanco != -1);
            return abreviatura.concat(" ").concat(this.apellidos);
        }
    }

    public static Integer orden_presentacion = 1;
    protected String nombre;
    protected ArrayList<Autor> autores;
    protected Integer cantidad_autores;
    protected Integer año;

    public Publicacion(String nombre, String nombre_completo_autor, Integer año) {
        this.nombre = nombre;
        this.autores = new ArrayList<>();
        Autor autor = new Autor(nombre_completo_autor);
        this.autores.add(autor);
        this.cantidad_autores = 1;
        this.año = año;
    }

    public Publicacion(String nombre, String nombres_completos_autores[], Integer año) {
        this.nombre = nombre;
        this.autores = new ArrayList<>();
        for (String nombres_completos_autor_loop : nombres_completos_autores) {
            Autor autor = new Autor(nombres_completos_autor_loop);
            this.autores.add(autor);
        }
        this.cantidad_autores = this.autores.size();
        this.año = año;
    }

    public abstract void referenciar();
}
