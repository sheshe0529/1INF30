package pe.edu.pucp.softpub.publicacion.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.publicacion.model.Articulo;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;
import pe.edu.pucp.softpub.publicacion.model.Tipo;

public class ArticuloBO extends PublicacionBO {
    
    public ArticuloBO(){
        super();
    }

    public Integer insertar(String titulo, String origen, String volumen, String numero, Integer paginaInicio,
            Integer paginaFin, Date fechaPublicacion, String DOI, String ISSN) {        
        Articulo articulo = new Articulo(null, titulo, origen, volumen, numero, paginaInicio, paginaFin, fechaPublicacion, DOI, ISSN);
        return this.publicacionDAO.insertar(articulo);
    }
    
    public Integer modificar(Integer idPublicacion, String titulo, String origen, String volumen, String numero, Integer paginaInicio,
            Integer paginaFin, Date fechaPublicacion, String DOI, String ISSN) {        
        Articulo articulo = new Articulo(idPublicacion, titulo, origen, volumen, numero, paginaInicio, paginaFin, fechaPublicacion, DOI, ISSN);
        return this.publicacionDAO.modificar(articulo);
    }
    
    public Integer eliminar(Integer idPublicacion) {        
        Articulo articulo = new Articulo();
        articulo.setIdPublicacion(idPublicacion);
        return this.publicacionDAO.eliminar(articulo);
    }
    
    public ArrayList<Publicacion> listarTodos(){
        return this.publicacionDAO.listarTodos(Tipo.ARTICULO_EN_CONFERENCIA);
    }
    
    public Publicacion obtenerPorId(Integer idPublicacion){
        return this.publicacionDAO.obtenerPorId(idPublicacion);
    }
}
