package pe.edu.pucp.softpub.grupo.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softpub.config.DAOImpl;
import pe.edu.pucp.softpub.grupo.dao.GrupoDAO;
import pe.edu.pucp.softpub.grupo.model.Grupo;

public class GrupoDAOImpl extends DAOImpl implements GrupoDAO {

    private Grupo grupo;

    public GrupoDAOImpl() {
        super("Grupo");
        this.grupo = null;
    }

    @Override
    public Integer insertar(Grupo grupo) {
        this.grupo = grupo;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "nombre, sigla";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.grupo.getNombre());
        this.incluirParametroString(2, this.grupo.getSigla());
    }

    @Override
    public Integer modificar(Grupo grupo) {
        this.grupo = grupo;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nombre=?, sigla=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idGrupo=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(3, this.grupo.getIdGrupo());
        this.incluirParametroString(1, this.grupo.getNombre());
        this.incluirParametroString(2, this.grupo.getSigla());
    }

    @Override
    public Integer eliminar(Grupo grupo) {
        this.grupo = grupo;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.grupo.getIdGrupo());
    }

    @Override
    public ArrayList<Grupo> listarTodos() {
        return (ArrayList<Grupo>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idGrupo, nombre, sigla";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.grupo);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.grupo = new Grupo();
        grupo.setIdGrupo(this.resultSet.getInt("idGrupo"));
        grupo.setNombre(this.resultSet.getString("nombre"));
        grupo.setSigla(this.resultSet.getString("sigla"));
    }

    @Override
    public Grupo obtenerPorId(Integer idGrupo) {
        this.grupo = new Grupo();
        this.grupo.setIdGrupo(idGrupo);
        super.obtenerPorId();
        return this.grupo;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.grupo.getIdGrupo());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.grupo = null;
    }

    public Integer insertar_con_sp(Grupo grupo) {
        Integer resultado = null;
        try {
            this.iniciarTransaccion();
            String sql = "{call INSERTAR_GRUPO (?, ?, ?)}";
            this.statement = this.conexion.prepareCall(sql);
            this.incluirParametroString("pi_nombre", grupo.getNombre());
            this.incluirParametroString("pi_sigla", grupo.getSigla());
            this.statement.executeUpdate();
            resultado = this.statement.getInt("ps_idGrupo");
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        return resultado;
    }
}
