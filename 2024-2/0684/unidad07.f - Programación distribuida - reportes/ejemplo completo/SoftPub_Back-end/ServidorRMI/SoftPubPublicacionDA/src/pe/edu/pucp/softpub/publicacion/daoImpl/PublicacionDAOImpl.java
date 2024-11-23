package pe.edu.pucp.softpub.publicacion.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softpub.config.DAOImpl;
import pe.edu.pucp.softpub.publicacion.dao.PublicacionDAO;
import pe.edu.pucp.softpub.publicacion.model.Articulo;
import pe.edu.pucp.softpub.publicacion.model.Capitulo;
import pe.edu.pucp.softpub.publicacion.model.Conferencia;
import pe.edu.pucp.softpub.publicacion.model.Editorial;
import pe.edu.pucp.softpub.publicacion.model.Libro;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;
import pe.edu.pucp.softpub.publicacion.model.Tipo;

public class PublicacionDAOImpl extends DAOImpl implements PublicacionDAO {

    private Publicacion publicacion;
    private Tipo tipo;

    public PublicacionDAOImpl() {
        super("Publicacion");
        this.publicacion = null;
    }

    @Override
    public Integer insertar(Publicacion publicacion) {
        this.publicacion = publicacion;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "titulo, tipo, origen, volumen, numero, paginaInicio, paginaFin, fechaPublicacion, DOI, ISSN, ISBN, edicion, lugar, editorial, departamento, institucion, ciudad, estado";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.publicacion.getTitulo());
        this.incluirParametroString(2, this.publicacion.getTipo().toString());
        this.incluirParametroString(3, this.publicacion.getOrigen());
        this.incluirParametroString(4, this.publicacion.getVolumen());
        this.incluirParametroString(5, this.publicacion.getNumero());
        this.incluirParametroInt(6, this.publicacion.getPaginaInicio());
        this.incluirParametroInt(7, this.publicacion.getPaginaFin());
        this.incluirParametroDate(8, this.publicacion.getFechaPublicacion());
        this.incluirParametroString(9, this.publicacion.getDOI());
        this.incluirParametroString(10, this.publicacion.getISSN());
        this.incluirParametroString(11, this.publicacion.getISBN());
        this.incluirParametroString(12, this.publicacion.getEdicion());
        this.incluirParametroString(13, this.publicacion.getLugar());
        this.incluirParametroString(14, this.publicacion.getEditorial());
        this.incluirParametroString(15, this.publicacion.getDepartamento());
        this.incluirParametroString(16, this.publicacion.getInstitucion());
        this.incluirParametroString(17, this.publicacion.getCiudad());
        this.incluirParametroString(18, this.publicacion.getEstado());
    }

    @Override
    public Integer modificar(Publicacion publicacion) {
        return super.modificar();
    }    
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "titulo=?, tipo=?, origen=?, volumen=?, numero=?, paginaInicio=?, paginaFin=?, fechaPublicacion=?, DOI=?, ISSN=?, ISBN=?, edicion=?, lugar=?, editorial=?, departamento=?, institucion=?, ciudad=?, estado=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(19, this.publicacion.getIdPublicacion());
        this.incluirParametroString(1, this.publicacion.getTitulo());
        this.incluirParametroString(2, this.publicacion.getTipo().toString());
        this.incluirParametroString(3, this.publicacion.getOrigen());
        this.incluirParametroString(4, this.publicacion.getVolumen());
        this.incluirParametroString(5, this.publicacion.getNumero());
        this.incluirParametroInt(6, this.publicacion.getPaginaInicio());
        this.incluirParametroInt(7, this.publicacion.getPaginaFin());
        this.incluirParametroDate(8, this.publicacion.getFechaPublicacion());
        this.incluirParametroString(9, this.publicacion.getDOI());
        this.incluirParametroString(10, this.publicacion.getISSN());
        this.incluirParametroString(11, this.publicacion.getISBN());
        this.incluirParametroString(12, this.publicacion.getEdicion());
        this.incluirParametroString(13, this.publicacion.getLugar());
        this.incluirParametroString(14, this.publicacion.getEditorial());
        this.incluirParametroString(15, this.publicacion.getDepartamento());
        this.incluirParametroString(16, this.publicacion.getInstitucion());
        this.incluirParametroString(17, this.publicacion.getCiudad());
        this.incluirParametroString(18, this.publicacion.getEstado());

    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idPublicacion=?";
    }

    @Override
    public Integer eliminar(Publicacion publicacion) {
        return super.eliminar();
    }    
        
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.publicacion.getIdPublicacion());
    }
   
    @Override
    public ArrayList<Publicacion> listarTodos(Tipo tipo) {
        this.tipo = tipo;
        return (ArrayList<Publicacion>) super.listarTodos(null);
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idPublicacion, titulo, tipo, origen, volumen, numero, paginaInicio, paginaFin, fechaPublicacion, DOI, ISSN, ISBN, edicion, lugar, editorial, departamento, institucion, ciudad, estado";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.publicacion);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        switch (this.tipo){
            case Tipo.ARTICULO_EN_REVISTA -> this.publicacion = new Articulo();
            case Tipo.ARTICULO_EN_CONFERENCIA -> this.publicacion = new Conferencia();
            case Tipo.EDITORIAL -> this.publicacion = new Editorial();
            case Tipo.LIBRO -> this.publicacion = new Libro();
            case Tipo.CAPITULO_DE_LIBRO -> this.publicacion = new Capitulo();                
        }     
        this.publicacion.setIdPublicacion(this.resultSet.getInt("idPublicacion"));
        this.publicacion.setTitulo(this.resultSet.getString("titulo"));
        this.publicacion.setTipo(Tipo.valueOf(this.resultSet.getString("tipo")));
        this.publicacion.setOrigen(this.resultSet.getString("origen"));
        this.publicacion.setVolumen(this.resultSet.getString("volumen"));
        this.publicacion.setNumero(this.resultSet.getString("numero"));
        this.publicacion.setPaginaInicio(this.resultSet.getInt("paginaInicio"));
        this.publicacion.setPaginaFin(this.resultSet.getInt("paginaFin"));
        this.publicacion.setFechaPublicacion(this.resultSet.getTimestamp("fechaPublicacion"));
        this.publicacion.setDOI(this.resultSet.getString("DOI"));
        this.publicacion.setISSN(this.resultSet.getString("ISSN"));
        this.publicacion.setISBN(this.resultSet.getString("ISBN"));
        this.publicacion.setEdicion(this.resultSet.getString("edicion"));
        this.publicacion.setLugar(this.resultSet.getString("lugar"));
        this.publicacion.setEditorial(this.resultSet.getString("editorial"));
        this.publicacion.setDepartamento(this.resultSet.getString("departamento"));
        this.publicacion.setInstitucion(this.resultSet.getString("institucion"));
        this.publicacion.setCiudad(this.resultSet.getString("ciudad"));
        this.publicacion.setEstado(this.resultSet.getString("estado"));
    }

    @Override
    public Publicacion obtenerPorId(Integer idPublicacion) {
        super.obtenerPorId();
        return this.publicacion;
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.publicacion = null;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.publicacion.getIdPublicacion());
    }    
}
