package pe.edu.pucp.softpub.publicacion.bo;

import java.util.Date;
import pe.edu.pucp.softpub.publicacion.dao.PublicacionDAO;
import pe.edu.pucp.softpub.publicacion.daoImpl.PublicacionDAOImpl;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;
import pe.edu.pucp.softpub.publicacion.model.Tipo;

public abstract class PublicacionBO {

    protected final PublicacionDAO publicacionDAO;

    public PublicacionBO() {
        this.publicacionDAO = new PublicacionDAOImpl();
    }

    protected Integer insertar(String titulo, Tipo tipo, String origen, String volumen,
            String numero, Integer paginaInicio,
            Integer paginaFin, Date fechaPublicacion, String DOI,
            String ISSN, String ISBN, String edicion, String lugar,
            String editorial, String departamento,
            String institucion, String ciudad, String estado) {
        Publicacion publicacion = new Publicacion(null, titulo, tipo, origen, volumen, numero, paginaInicio, paginaFin, fechaPublicacion, DOI, ISSN, ISBN, edicion, lugar, editorial, departamento, institucion, ciudad, estado);
        return this.publicacionDAO.insertar(publicacion);
    }
}
