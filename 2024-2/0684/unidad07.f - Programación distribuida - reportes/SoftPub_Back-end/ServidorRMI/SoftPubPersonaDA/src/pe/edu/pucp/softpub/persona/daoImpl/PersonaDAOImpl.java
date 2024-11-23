package pe.edu.pucp.softpub.persona.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softpub.config.DAOImpl;
import pe.edu.pucp.softpub.persona.dao.PersonaDAO;
import pe.edu.pucp.softpub.persona.model.Genero;
import pe.edu.pucp.softpub.persona.model.Persona;

public class PersonaDAOImpl extends DAOImpl implements PersonaDAO {

    private Persona persona;

    public PersonaDAOImpl() {
        super("Persona");
        this.persona = null;
    }

    @Override
    public Integer insertar(Persona persona) {
        this.persona = persona;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }
    
    @Override
    public Integer insertar(Persona persona, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(persona);
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "paterno, materno, nombre, genero, fechaCreacion, usuarioCreacion, fechaModificacion, usuarioModificacion, fechaEliminacion";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.persona.getPaterno());
        this.incluirParametroString(2, this.persona.getMaterno());
        this.incluirParametroString(3, this.persona.getNombre());
        this.incluirParametroString(4, this.persona.getGenero().toString());
        this.incluirParametroDate(5, this.persona.getFechaCreacion());
        this.incluirParametroString(6, this.persona.getUsuarioCreacion());
        this.incluirParametroDate(7, this.persona.getFechaModificacion());
        this.incluirParametroString(8, this.persona.getUsuarioModificacion());
        this.incluirParametroDate(9, this.persona.getFechaEliminacion());
    }        

    @Override
    public Integer modificar(Persona persona) {
        this.persona = persona;
        return super.modificar();
    }
    
    @Override
    public Integer modificar(Persona persona, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(persona);
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idPersona=?";
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "paterno=?, materno=?, nombre=?, genero=?, fechaModificacion=?, usuarioModificacion=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(7, this.persona.getIdPersona());
        this.incluirParametroString(1, this.persona.getPaterno());
        this.incluirParametroString(2, this.persona.getMaterno());
        this.incluirParametroString(3, this.persona.getNombre());
        this.incluirParametroString(4, this.persona.getGenero().toString());
        this.incluirParametroDate(5, this.persona.getFechaModificacion());
        this.incluirParametroString(6, this.persona.getUsuarioModificacion());
    }

    @Override
    public Integer eliminar(Persona persona) {
        this.persona = persona;
        return super.eliminar();
    }
    
    @Override
    public Integer eliminar(Persona persona, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.eliminar(persona);
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.persona.getIdPersona());
    }

    @Override
    public ArrayList<Persona> listarTodos() {
        return (ArrayList<Persona>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idPersona, paterno, materno, nombre, genero, fechaCreacion, usuarioCreacion, fechaModificacion, usuarioModificacion, fechaEliminacion";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.persona);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.persona = new Persona();
        this.persona.setIdPersona(this.resultSet.getInt("idPersona"));
        this.persona.setPaterno(this.resultSet.getString("paterno"));
        this.persona.setMaterno(this.resultSet.getString("materno"));
        this.persona.setNombre(this.resultSet.getString("nombre"));
        this.persona.setGenero(Genero.valueOf(this.resultSet.getString("genero")));
        this.persona.setFechaCreacion(this.resultSet.getTimestamp("fechaCreacion"));
        this.persona.setUsuarioCreacion(this.resultSet.getString("usuarioCreacion"));
        this.persona.setFechaModificacion(this.resultSet.getTimestamp("fechaModificacion"));
        this.persona.setUsuarioModificacion(this.resultSet.getString("usuarioModificacion"));
        this.persona.setFechaEliminacion(this.resultSet.getTimestamp("fechaEliminacion"));
    }

    @Override
    public Persona obtenerPorId(Integer idPersona) {
        this.persona = new Persona();
        this.persona.setIdPersona(idPersona);
        this.obtenerPorId();
        return this.persona;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.persona.getIdPersona());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.persona = null;
    }

    @Override
    public Boolean existePersona(Persona persona) {
        this.persona = persona;
        Integer idPersona = null;
        try {
            this.abrirConexion();
            String sql = "select idPersona from persona where ";
            sql = sql.concat("paterno=? ");
            sql = sql.concat("and materno=? ");
            sql = sql.concat("and nombre=?");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.persona.getPaterno());
            this.incluirParametroString(2, this.persona.getMaterno());
            this.incluirParametroString(3, this.persona.getNombre());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idPersona = this.resultSet.getInt("idPersona");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe persona - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.persona.setIdPersona(idPersona);
        return idPersona != null;
    }
}
