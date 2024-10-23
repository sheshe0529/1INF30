package pe.edu.pucp.softpub.publicacion.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.publicacion.model.Conferencia;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;
import pe.edu.pucp.softpub.publicacion.model.Tipo;

public class ConferenciaBO extends PublicacionBO{

    public Integer insertar(String titulo, String origen, Integer paginaInicio, Integer paginaFin, Date fechaPublicacion, String DOI, String lugar, String ciudad, String estado) {        
        Conferencia conferencia = new Conferencia(null, titulo, origen, paginaInicio, paginaFin, fechaPublicacion, DOI, lugar, ciudad, estado);
        return this.publicacionDAO.insertar(conferencia);
    }
    
    public Integer modificar(Integer idPublicacion, String titulo, String origen, Integer paginaInicio, Integer paginaFin, Date fechaPublicacion, String DOI, String lugar, String ciudad, String estado) {        
        Conferencia conferencia = new Conferencia(idPublicacion, titulo, origen, paginaInicio, paginaFin, fechaPublicacion, DOI, lugar, ciudad, estado);
        return this.publicacionDAO.modificar(conferencia);
    }
    
    public Integer eliminar(Integer idPublicacion) {        
        Conferencia conferencia = new Conferencia();
        conferencia.setIdPublicacion(idPublicacion);
        return this.publicacionDAO.eliminar(conferencia);
    }
    
    public ArrayList<Publicacion> listarTodos(){
        return this.publicacionDAO.listarTodos(Tipo.ARTICULO_EN_CONFERENCIA);
    }
    
    public Publicacion obtenerPorId(Integer idPublicacion){
        return this.publicacionDAO.obtenerPorId(idPublicacion);
    }
}
