package pe.edu.pucp.softpub.publicacion.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.publicacion.model.Libro;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;
import pe.edu.pucp.softpub.publicacion.model.Tipo;

public class LibroBO extends PublicacionBO{

    public Integer insertar(String titulo, String origen, Date fechaPublicacion, String DOI, String ISBN, String edicion, String lugar, String editorial) {        
        Libro libro = new Libro(null, titulo, origen, fechaPublicacion, DOI, ISBN, edicion, lugar, editorial);
        return this.publicacionDAO.insertar(libro);
    }
    
    public Integer modificar(Integer idPublicacion, String titulo, String origen, Date fechaPublicacion, String DOI, String ISBN, String edicion, String lugar, String editorial) {        
        Libro libro = new Libro(idPublicacion, titulo, origen, fechaPublicacion, DOI, ISBN, edicion, lugar, editorial);
        return this.publicacionDAO.modificar(libro);
    }
    
    public Integer eliminar(Integer idPublicacion) {        
        Libro libro = new Libro();
        libro.setIdPublicacion(idPublicacion);
        return this.publicacionDAO.eliminar(libro);
    }
    
    public ArrayList<Publicacion> listarTodos(Tipo tipo){
        return this.publicacionDAO.listarTodos(Tipo.LIBRO);
    }
    
    public Publicacion obtenerPorId(Integer idPublicacion){
        return this.publicacionDAO.obtenerPorId(idPublicacion);
    }
}
