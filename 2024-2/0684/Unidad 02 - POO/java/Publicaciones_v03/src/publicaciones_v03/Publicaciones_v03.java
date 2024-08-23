package publicaciones_v03;

public class Publicaciones_v03 {
 
    public static void main(String[] args) {
        Publicacion publicaciones[] = new Publicacion[3]; 
        publicaciones[0] = new Articulo("A relational model of data for large shared data banks", "Edgard Frank Codd", 1970, "Communications of ACM", 13, 6, "junio");
        String autores[]={"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"};
        publicaciones[1] =  new Libro("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 4, 1993, "1era edición", "Massachusetts", "Addison-Wesley Professional");
        publicaciones[2] =  new Tesis("A systema of logic based on ordinals", "Alan Mathison Turing", 1938, "Tesis de doctorado", "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");
        
        for(int i=0; i<3; i++){
            publicaciones[i].referenciar();
            Publicacion.orden_presentacion++;
        }
    }
    
}
