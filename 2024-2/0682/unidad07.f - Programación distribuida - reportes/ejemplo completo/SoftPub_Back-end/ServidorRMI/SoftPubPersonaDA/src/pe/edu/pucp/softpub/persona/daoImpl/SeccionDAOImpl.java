package pe.edu.pucp.softpub.persona.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.softpub.persona.dao.SeccionDAO;
import pe.edu.pucp.softpub.persona.model.Seccion;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.softpub.config.DAOImpl;

public class SeccionDAOImpl extends DAOImpl implements SeccionDAO {

    private Seccion seccion;

    public SeccionDAOImpl() {
        super("Seccion");
        this.seccion = null;
    }

    @Override
    public Integer insertar(Seccion seccion) {
        this.seccion = seccion;
        return super.insertar();
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idSeccion, seccion, departamento";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.seccion.getIdSeccion());
        this.incluirParametroString(2, this.seccion.getSeccion());
        this.incluirParametroString(3, this.seccion.getDepartamento());
    }

    @Override
    public Integer modificar(Seccion seccion) {
        this.seccion = seccion;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "seccion=?, departamento=?";        
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idSeccion=?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(3, this.seccion.getIdSeccion());
        this.incluirParametroString(1, this.seccion.getSeccion());
        this.incluirParametroString(2, this.seccion.getDepartamento());
    }    

    @Override
    public Integer eliminar(Seccion seccion) {
        this.seccion = seccion;
        return super.eliminar();
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroString(1, seccion.getIdSeccion());
    }

    @Override
    public ArrayList<Seccion> listarTodos() {
        return (ArrayList<Seccion>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idSeccion, seccion, departamento";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.seccion);
    }

    @Override
    public Seccion obtenerPorId(String idSeccion) {
        this.seccion = new Seccion();
        this.seccion.setIdSeccion(idSeccion);
        super.obtenerPorId();
        return this.seccion;
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroString(1, seccion.getIdSeccion());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.seccion = new Seccion();
        this.seccion.setIdSeccion(this.resultSet.getString("idSeccion"));
        this.seccion.setSeccion(this.resultSet.getString("seccion"));
        this.seccion.setDepartamento(this.resultSet.getString("departamento"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.seccion = null;
    }        
}
