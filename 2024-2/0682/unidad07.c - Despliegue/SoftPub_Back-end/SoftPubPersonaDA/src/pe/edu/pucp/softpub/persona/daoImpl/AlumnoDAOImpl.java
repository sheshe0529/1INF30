package pe.edu.pucp.softpub.persona.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softpub.config.DAOImpl;
import pe.edu.pucp.softpub.config.Tipo_Operacion;
import pe.edu.pucp.softpub.persona.dao.AlumnoDAO;
import pe.edu.pucp.softpub.persona.dao.PersonaDAO;
import pe.edu.pucp.softpub.persona.model.Alumno;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Genero;
import pe.edu.pucp.softpub.persona.model.Persona;

/**
 *
 * Autor: andres
 */
public class AlumnoDAOImpl extends DAOImpl implements AlumnoDAO {

    private Alumno alumno;

    public AlumnoDAOImpl() {
        super("Alumno");
        this.alumno = null;
    }

    @Override
    public Integer insertar(Alumno alumno) {
        this.alumno = alumno;
        Integer idPersona = null;
        Persona persona = new Persona();
        persona.setPaterno(this.alumno.getPaterno());
        persona.setMaterno(this.alumno.getMaterno());
        persona.setNombre(this.alumno.getNombre());
        persona.setGenero(this.alumno.getGenero());
        persona.setFechaCreacion(this.alumno.getFechaCreacion());
        persona.setUsuarioCreacion(this.alumno.getUsuarioCreacion());

        PersonaDAO personaDAO = new PersonaDAOImpl();
        Boolean existePersona = personaDAO.existePersona(persona);
        Boolean existeAlumno = false;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existePersona) {
                idPersona = personaDAO.insertar(persona, this.usarTransaccion, this.conexion);
                this.alumno.setIdPersona(idPersona);
            } else {
                idPersona = persona.getIdPersona();
                this.alumno.setIdPersona(idPersona);
                Boolean abreConexion = false;
                existeAlumno = this.existeAlumno(this.alumno, abreConexion);
            }
            if (!existeAlumno) {
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
        return "idPersona, idEspecialidad, matriculado";        
    }
    
    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.alumno.getIdPersona());
        this.incluirParametroInt(2, this.alumno.getEspecialidad().getIdEspecialidad());
        this.incluirParametroBoolean(3, this.alumno.getMatriculado());
    }

    @Override
    public Integer modificar(Alumno alumno) {
        Integer retorno = 0;
        this.alumno = alumno;
        Persona persona = new Persona();
        persona.setIdPersona(this.alumno.getIdPersona());
        persona.setPaterno(this.alumno.getPaterno());
        persona.setMaterno(this.alumno.getMaterno());
        persona.setNombre(this.alumno.getNombre());
        persona.setGenero(this.alumno.getGenero());
        persona.setFechaModificacion(this.alumno.getFechaModificacion());
        persona.setUsuarioModificacion(this.alumno.getUsuarioModificacion());

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
        return "idEspecialidad=?, matriculado=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(3, this.alumno.getIdPersona());
        this.incluirParametroInt(1, this.alumno.getEspecialidad().getIdEspecialidad());
        this.incluirParametroBoolean(2, this.alumno.getMatriculado());        
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
    public Integer eliminar(Alumno alumno) {
        Integer retorno = 0;
        this.alumno = alumno;
        Persona persona = new Persona();
        persona.setIdPersona(this.alumno.getIdPersona());        

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
        this.incluirParametroInt(1, this.alumno.getIdPersona());
    }

    @Override
    public ArrayList<Alumno> listarTodos() {
        return (ArrayList<Alumno>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" alu ");
        sql = sql.concat("join persona per on per.idPersona = alu.idPersona ");
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
        sql = sql.concat("alu.idEspecialidad, alu.matriculado");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.alumno);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.alumno = new Alumno();
        this.alumno.setIdPersona(this.resultSet.getInt("idPersona"));
        this.alumno.setPaterno(this.resultSet.getString("paterno"));
        this.alumno.setMaterno(this.resultSet.getString("materno"));
        this.alumno.setNombre(this.resultSet.getString("nombre"));
        this.alumno.setGenero(Genero.valueOf(this.resultSet.getString("genero")));
        this.alumno.setFechaCreacion(this.resultSet.getTimestamp("fechaCreacion"));
        this.alumno.setUsuarioCreacion(this.resultSet.getString("usuarioCreacion"));
        this.alumno.setFechaModificacion(this.resultSet.getTimestamp("fechaModificacion"));
        this.alumno.setUsuarioModificacion(this.resultSet.getString("usuarioModificacion"));
        this.alumno.setFechaEliminacion(this.resultSet.getTimestamp("fechaEliminacion"));
        
        Especialidad especialidad = new Especialidad();
        especialidad.setIdEspecialidad(this.resultSet.getInt("idEspecialidad"));
        this.alumno.setEspecialidad(especialidad);
        
        this.alumno.setMatriculado(this.resultSet.getInt("matriculado") == 1);
    }

    @Override
    public Alumno obtenerPorId(Integer idPersona) {
        this.alumno = new Alumno();
        this.alumno.setIdPersona(idPersona);
        super.obtenerPorId();
        return this.alumno;
    }

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" alu ");
        sql = sql.concat("join persona per on per.idPersona = alu.idPersona ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.alumno.getIdPersona());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.alumno = null;
    }
    
    @Override
    public Boolean existeAlumno(Alumno alumno) {
        Boolean abreConexion = true;
        return existeAlumno(alumno, abreConexion);
    }

    @Override
    public Boolean existeAlumno(Alumno alumno, Boolean abreConexion) {
        this.alumno = alumno;
        Integer idPersona = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select idPersona from alumno where ";
            sql = sql.concat("idPersona=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.alumno.getIdPersona());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idPersona = this.resultSet.getInt("idPersona");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe alumno - " + ex);
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
