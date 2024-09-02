package pe.edu.pucp.inf30.sesiones.publicaciones00;

/**
 *
 * Autor: andres
 * 
 * 01. Se trabajará el autor en una clase adicional para que el comportamiento de la 
 *     impresión se pueda manejar correctamente. Se crea la clase Autor anidada a la clase Publicacion.
 * 02. Se cambia el atributo autores para que sea de tipo ArrayList<Autor>. 
 *     Con esto se cambia: la implementación de los constructores, la llamada a 
 *     los constructores por el cambio de nombre, la implementación de las 
 *     sobreescrituras de los métodos referenciar.
 * 03. Se crea el tipo enumerado Clase_de_Tesis que permitirá saber qué tipo de eso.
 *     Se encuentra dentro de la clase Tesis.
 */
public class Publicaciones_v00 {

    public static void main(String[] args) {
        Publicacion publicaciones[] = new Publicacion[3];
        publicaciones[0] = new Articulo("A relational model of data for large shared data banks", "Codd, Edgar Frank", 1970, "Communications of the ACM", 13, 6, "junio");
        String autores[]= {"Gamma, Erich", "Helm, Richard", "Johnson, Ralph", "Vlissides, John"};        
        publicaciones[1] = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 1970, "1er edición", "Massachusetts", "Addison-Wesley Professional");
        publicaciones[2] = new Tesis("A system of logic based on ordinals", "Turing, Alan Mathison", 1938, Tesis.Clase_de_Tesis.DOCTORADO, "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");                
        
        for (Publicacion publicacion : publicaciones) {
            publicacion.referenciar();
            Publicacion.orden_presentacion++;
        }
    }
}
