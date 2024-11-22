package pe.edu.pucp.softpub.persona.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softpub.config.DAOImpl;
import pe.edu.pucp.softpub.persona.dao.EspecialidadDAO;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;

/**
 *
 * Autor: andres
 */
public class EspecialidadDAOImpl extends DAOImpl implements EspecialidadDAO {

    private Especialidad especialidad;

    public EspecialidadDAOImpl() {
        super("Especialidad");
        this.especialidad = null;
    }

    @Override
    public Integer insertar(Especialidad especialidad) {
        this.especialidad = especialidad;
        return super.insertar();
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idEspecialidad, especialidad, facultad, nivel";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.especialidad.getIdEspecialidad());
        this.incluirParametroString(2, this.especialidad.getEspecialidad());
        this.incluirParametroString(3, this.especialidad.getFacultad());
        this.incluirParametroString(4, this.especialidad.getNivel().toString());
    }

    @Override
    public Integer modificar(Especialidad especialidad) {
        this.especialidad = especialidad;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "especialidad=?, facultad=?, nivel=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idEspecialidad=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(4, this.especialidad.getIdEspecialidad());
        this.incluirParametroString(1, this.especialidad.getEspecialidad());
        this.incluirParametroString(2, this.especialidad.getFacultad());
        this.incluirParametroString(3, this.especialidad.getNivel().toString());
    }

    @Override
    public Integer eliminar(Especialidad especialidad) {
        this.especialidad = especialidad;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.especialidad.getIdEspecialidad());
    }

    @Override
    public ArrayList<Especialidad> listarTodos() {
        return (ArrayList<Especialidad>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idEspecialidad, especialidad, facultad, nivel";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.especialidad = new Especialidad();
        this.especialidad.setIdEspecialidad(resultSet.getInt("idEspecialidad"));
        this.especialidad.setEspecialidad(resultSet.getString("especialidad"));
        this.especialidad.setFacultad(resultSet.getString("facultad"));
        this.especialidad.setNivel(Nivel.valueOf(resultSet.getString("nivel")));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.especialidad);
    }

    @Override
    public Especialidad obtenerPorId(Integer idEspecialidad) {
        this.especialidad = new Especialidad();
        this.especialidad.setIdEspecialidad(idEspecialidad);
        super.obtenerPorId();
        return this.especialidad;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.especialidad.getIdEspecialidad());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.especialidad = null;
    }
}
