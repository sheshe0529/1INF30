package pe.edu.pucp.softpub.persona.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softpub.config.DAOImpl;
import pe.edu.pucp.softpub.config.Tipo_Operacion;
import pe.edu.pucp.softpub.persona.dao.PersonaDAO;
import pe.edu.pucp.softpub.persona.dao.ProfesorDAO;
import pe.edu.pucp.softpub.persona.model.Categoria;
import pe.edu.pucp.softpub.persona.model.Dedicacion;
import pe.edu.pucp.softpub.persona.model.Genero;
import pe.edu.pucp.softpub.persona.model.Persona;
import pe.edu.pucp.softpub.persona.model.Profesor;
import pe.edu.pucp.softpub.persona.model.Seccion;

public class ProfesorDAOImpl extends DAOImpl implements ProfesorDAO {

    private Profesor profesor;

    public ProfesorDAOImpl() {
        super("Profesor");
        this.profesor = null;
    }

    @Override
    public Integer insertar(Profesor profesor) {
        this.profesor = profesor;
        Integer idPersona = null;
        Persona persona = new Persona();
        persona.setPaterno(this.profesor.getPaterno());
        persona.setMaterno(this.profesor.getMaterno());
        persona.setNombre(this.profesor.getNombre());
        persona.setGenero(this.profesor.getGenero());
        persona.setFechaCreacion(this.profesor.getFechaCreacion());
        persona.setUsuarioCreacion(this.profesor.getUsuarioCreacion());

        PersonaDAO personaDAO = new PersonaDAOImpl();
        Boolean existePersona = personaDAO.existePersona(persona);
        Boolean existeProfesor = false;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existePersona) {
                idPersona = personaDAO.insertar(persona, this.usarTransaccion, this.conexion);
                this.profesor.setIdPersona(idPersona);
            } else {
                idPersona = persona.getIdPersona();
                this.profesor.setIdPersona(idPersona);
                Boolean abreConexion = false;
                existeProfesor = this.existeProfesor(this.profesor, abreConexion);
            }
            if (!existeProfesor) {
                super.insertar();
            }
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
        this.usarTransaccion = true;
        return idPersona;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idPersona, idSeccion, categoria, dedicacion, activo";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.profesor.getIdPersona());
        this.incluirParametroString(2, this.profesor.getSeccion().getIdSeccion());
        this.incluirParametroString(3, this.profesor.getCategoria().toString());
        this.incluirParametroString(4, this.profesor.getDedicacion().toString());
        this.incluirParametroBoolean(5, this.profesor.getActivo());
    }

    @Override
    public Integer modificar(Profesor profesor) {
        Integer retorno = 0;
        this.profesor = profesor;
        Persona persona = new Persona();
        persona.setIdPersona(this.profesor.getIdPersona());
        persona.setPaterno(this.profesor.getPaterno());
        persona.setMaterno(this.profesor.getMaterno());
        persona.setNombre(this.profesor.getNombre());
        persona.setGenero(this.profesor.getGenero());
        persona.setFechaModificacion(this.profesor.getFechaModificacion());
        persona.setUsuarioModificacion(this.profesor.getUsuarioModificacion());

        PersonaDAO personaDAO = new PersonaDAOImpl();

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            personaDAO.modificar(persona, this.usarTransaccion, this.conexion);
            retorno = super.modificar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar modificar - " + ex);
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
        this.usarTransaccion = true;
        return retorno;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "idSeccion=?, categoria=?, dedicacion=?, activo=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(5, this.profesor.getIdPersona());
        this.incluirParametroString(1, this.profesor.getSeccion().getIdSeccion());
        this.incluirParametroString(2, this.profesor.getCategoria().toString());
        this.incluirParametroString(3, this.profesor.getDedicacion().toString());
        this.incluirParametroBoolean(4, this.profesor.getActivo());
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "idPersona=?";
        } else {
            sql = "per.idPersona=?";
        }
        return sql;
    }

    @Override
    public Integer eliminar(Profesor profesor) {
        Integer retorno = 0;
        this.profesor = profesor;
        Persona persona = new Persona();
        persona.setIdPersona(this.profesor.getIdPersona());        

        PersonaDAO personaDAO = new PersonaDAOImpl();
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            retorno = super.eliminar();
            personaDAO.eliminar(persona, this.usarTransaccion, this.conexion);            
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar eliminar - " + ex);
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
        this.usarTransaccion = true;
        return retorno;
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.profesor.getIdPersona());
    }

    @Override
    public ArrayList<Profesor> listarTodos() {
        return (ArrayList<Profesor>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" pro ");
        sql = sql.concat("join persona per on per.idPersona = pro.idPersona ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "per.idPersona, per.paterno, per.materno, per.nombre, ";
        sql = sql.concat("per.genero, per.fechaCreacion, per.usuarioCreacion, ");
        sql = sql.concat("per.fechaModificacion, per.usuarioModificacion, per.fechaEliminacion, ");
        sql = sql.concat("pro.idSeccion, pro.categoria, pro.dedicacion, pro.activo");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.profesor);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.profesor = new Profesor();
        this.profesor.setIdPersona(this.resultSet.getInt("idPersona"));
        this.profesor.setPaterno(this.resultSet.getString("paterno"));
        this.profesor.setMaterno(this.resultSet.getString("materno"));
        this.profesor.setNombre(this.resultSet.getString("nombre"));
        this.profesor.setGenero(Genero.valueOf(this.resultSet.getString("genero")));
        this.profesor.setFechaCreacion(this.resultSet.getTimestamp("fechaCreacion"));
        this.profesor.setUsuarioCreacion(this.resultSet.getString("usuarioCreacion"));
        this.profesor.setFechaModificacion(this.resultSet.getTimestamp("fechaModificacion"));
        this.profesor.setUsuarioModificacion(this.resultSet.getString("usuarioModificacion"));
        this.profesor.setFechaEliminacion(this.resultSet.getTimestamp("fechaEliminacion"));

        Seccion seccion = new Seccion();
        seccion.setIdSeccion(this.resultSet.getString("idSeccion"));
        this.profesor.setSeccion(seccion);

        this.profesor.setCategoria(Categoria.valueOf(this.resultSet.getString("categoria")));
        this.profesor.setDedicacion(Dedicacion.valueOf(this.resultSet.getString("dedicacion")));
        this.profesor.setActivo(this.resultSet.getInt("activo") == 1);
    }

    @Override
    public Profesor obtenerPorId(Integer idPersona) {
        this.profesor = new Profesor();
        this.profesor.setIdPersona(idPersona);
        super.obtenerPorId();
        return this.profesor;
    }

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" pro ");
        sql = sql.concat("join persona per on per.idPersona = pro.idPersona ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.profesor.getIdPersona());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.profesor = null;
    }

    @Override
    public Boolean existeProfesor(Profesor profesor) {
        Boolean abreConexion = true;
        return existeProfesor(profesor, abreConexion);
    }

    @Override
    public Boolean existeProfesor(Profesor profesor, Boolean abreConexion) {
        this.profesor = profesor;
        Integer idPersona = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select idPersona from profesor where ";
            sql = sql.concat("idPersona=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.profesor.getIdPersona());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idPersona = this.resultSet.getInt("idPersona");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe profesor - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idPersona != null;
    }
}
