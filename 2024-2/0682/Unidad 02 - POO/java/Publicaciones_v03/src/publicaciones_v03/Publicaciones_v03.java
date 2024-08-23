package publicaciones_v03;

public class Publicaciones_v03 {

    public static void main(String[] args) {
        Publicacion publicacion = new Articulo("A relational model of data large shared data banks", "Edgard Frank Cood", 1970, "Communications of ACM", 13, 6, "junio");
        publicacion.referenciar();
        
        //publicacion = new Publicacion("A relational model of data large shared data banks", "Edgard Frank Cood", 1970);
        //publicacion.referenciar();
        
        String autores[] = {"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"};
        publicacion = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 4, 1994, "1era edición", "Massachussetts", "Addison-Wesley Professional");
        publicacion.referenciar();
        
        publicacion = new Tesis("A system of logic based on ordinals", "Alan Mathison Turing", 1938, "Tesis de Doctorado", "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");
        publicacion.referenciar();
    }
    
}
