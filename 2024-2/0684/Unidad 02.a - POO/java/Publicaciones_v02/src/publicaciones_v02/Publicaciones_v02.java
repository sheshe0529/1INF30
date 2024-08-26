package publicaciones_v02;

public class Publicaciones_v02 {

    public static void main(String[] args) {
        Publicacion publicacion = new Articulo("A relational model of data for large shared data banks", "Edgard Frank Codd", 1970, "Communications of ACM", 13, 6, "junio");
        publicacion.referenciar();
        
        String autores[]={"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"};
        publicacion = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 4, 1993, "1era edición", "Massachusetts", "Addison-Wesley Professional");
        publicacion.referenciar();
        
        publicacion = new Tesis("A systema of logic based on ordinals", "Alan Mathison Turing", 1938, "Tesis de doctorado", "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");
        publicacion.referenciar();
    }
    
}
