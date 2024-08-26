package publicaciones_v01;

public class Publicaciones_v01 {
    
    public static void main(String[] args) {
        Publicacion publicacion = new Publicacion("A relational model of data large shared data banks", "Edgard Frank Cood", 1970);
        publicacion.referenciar();
        
        String autores[] = {"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"};
        publicacion = new Publicacion("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 4, 1994);
        publicacion.referenciar();
        
        publicacion = new Publicacion("A system of logic based on ordinals", "Alan Mathison Turing", 1938);
        publicacion.referenciar();
    }
    
}
