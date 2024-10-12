package pe.edu.pucp.softpub.grupo.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softpub.config.DAOImpl;
import pe.edu.pucp.softpub.grupo.dao.LineaDAO;
import pe.edu.pucp.softpub.grupo.model.Grupo;
import pe.edu.pucp.softpub.grupo.model.Linea;

public class LineaDAOImpl extends DAOImpl implements LineaDAO {

    private Linea linea;

    public LineaDAOImpl() {
        super("Linea");
        this.linea = null;
    }

    @Override
    public Integer insertar(Linea linea) {
        this.linea = linea;
        return super.insertar();
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idGrupo, idLinea, nombre";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.linea.getGrupo().getIdGrupo());
        this.incluirParametroInt(2, this.linea.getIdLinea());
        this.incluirParametroString(3, this.linea.getNombre());
    }

    @Override
    public Integer modificar(Linea linea) {
        this.linea = linea;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nombre=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idGrupo=? and idLinea=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(2, this.linea.getGrupo().getIdGrupo());
        this.incluirParametroInt(3, this.linea.getIdLinea());
        this.incluirParametroString(1, this.linea.getNombre());
    }

    @Override
    public Integer eliminar(Linea linea) {
        this.linea = linea;
        return super.modificar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.linea.getGrupo().getIdGrupo());
        this.incluirParametroInt(2, this.linea.getIdLinea());
    }

    @Override
    public ArrayList<Linea> listarTodos(Integer idGrupo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Linea obtenerPorId(Linea linea) {
        this.linea = linea;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
