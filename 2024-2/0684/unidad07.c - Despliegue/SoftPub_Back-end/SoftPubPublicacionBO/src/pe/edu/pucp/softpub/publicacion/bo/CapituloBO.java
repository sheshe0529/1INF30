package pe.edu.pucp.softpub.publicacion.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.publicacion.model.Capitulo;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;
import pe.edu.pucp.softpub.publicacion.model.Tipo;

public class CapituloBO extends PublicacionBO{

    public Integer insertar(String titulo, String origen, Date fechaPublicacion, String DOI, String ISBN, String edicion, String lugar, String editorial) {        
        Capitulo capitulo = new Capitulo(null, titulo, origen, fechaPublicacion, DOI, ISBN, edicion, lugar, editorial);
        return this.publicacionDAO.insertar(capitulo);
    }
    
    public Integer modificar(Integer idPublicacion, String titulo, String origen, Date fechaPublicacion, String DOI, String ISBN, String edicion, String lugar, String editorial) {        
        Capitulo capitulo = new Capitulo(idPublicacion, titulo, origen, fechaPublicacion, DOI, ISBN, edicion, lugar, editorial);
        return this.publicacionDAO.modificar(capitulo);
    }
    
    public Integer eliminar(Integer idPublicacion) {        
        Capitulo capitulo = new Capitulo();
        capitulo.setIdPublicacion(idPublicacion);
        return this.publicacionDAO.eliminar(capitulo);
    }
    
    public ArrayList<Publicacion> listarTodos(){
        return this.publicacionDAO.listarTodos(Tipo.CAPITULO_DE_LIBRO);
    }
    
    public Publicacion obtenerPorId(Integer idPublicacion){
        return this.publicacionDAO.obtenerPorId(idPublicacion);
    }
}
