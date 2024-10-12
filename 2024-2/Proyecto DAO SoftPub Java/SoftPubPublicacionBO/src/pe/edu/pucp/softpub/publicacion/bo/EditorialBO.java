package pe.edu.pucp.softpub.publicacion.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.publicacion.model.Editorial;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;
import pe.edu.pucp.softpub.publicacion.model.Tipo;

public class EditorialBO extends PublicacionBO{

    public Integer insertar(String titulo, String origen, String volumen, String numero, Integer paginaInicio,
            Integer paginaFin, Date fechaPublicacion, String DOI, String ISSN) {        
        Editorial editorial = new Editorial(null, titulo, origen, volumen, numero, paginaInicio, paginaFin, fechaPublicacion, DOI, ISSN);
        return this.publicacionDAO.insertar(editorial);
    }
    
    public Integer modificar(Integer idPublicacion, String titulo, String origen, String volumen, String numero, Integer paginaInicio,
            Integer paginaFin, Date fechaPublicacion, String DOI, String ISSN) {        
        Editorial editorial = new Editorial(idPublicacion, titulo, origen, volumen, numero, paginaInicio, paginaFin, fechaPublicacion, DOI, ISSN);
        return this.publicacionDAO.modificar(editorial);
    }
    
    public Integer eliminar(Integer idPublicacion) {        
        Editorial editorial = new Editorial();
        editorial.setIdPublicacion(idPublicacion);
        return this.publicacionDAO.eliminar(editorial);
    }
    
    public ArrayList<Publicacion> listarTodos(Tipo tipo){
        return this.publicacionDAO.listarTodos(Tipo.EDITORIAL);
    }
    
    public Publicacion obtenerPorId(Integer idPublicacion){
        return this.publicacionDAO.obtenerPorId(idPublicacion);
    }
}
