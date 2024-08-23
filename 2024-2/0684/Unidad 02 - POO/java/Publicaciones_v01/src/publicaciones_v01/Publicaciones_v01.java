package publicaciones_v01;

public class Publicaciones_v01 {

    public static void main(String[] args) {
        Publicacion publicacion = new Publicacion("A relational model of data for large shared data banks", "Edgard Frank Codd", 1970);
        publicacion.referenciar();
        
        String autores[]={"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"};
        publicacion = new Publicacion("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 4, 1993);
        publicacion.referenciar();
        
        publicacion = new Publicacion("A systema of logic based on ordinals", "Alan Mathison Turing", 1938);
        publicacion.referenciar();
    }
    
}
