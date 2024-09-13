package pe.edu.pucp.softpub.persona.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.softpub.db.DAOImpl;
import pe.edu.pucp.softpub.persona.dao.EspecialidadDAO;
import pe.edu.pucp.softpub.persona.model.Especialidad;

public class EspecialidadDAOImpl extends DAOImpl implements EspecialidadDAO {

    private Especialidad especialidad;

    public EspecialidadDAOImpl() {
        super("Especialidad");
        this.especialidad = null;
    }

    @Override
    public Integer insertar(Especialidad especialidad) {
        this.especialidad = especialidad;
        return this.insertar();
    }

    @Override
    protected String obtenerListaAtributosParaInsertar() {
        return "idEspecialidad, especialidad, facultad, nivel";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat(especialidad.getIdEspecialidad().toString());
        sql = sql.concat(", ");
        sql = sql.concat("'" + especialidad.getEspecialidad() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + especialidad.getFacultad() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + especialidad.getNivel().toString() + "'");
        return sql;
    }

    @Override
    public Integer modificar(Especialidad especialidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Especialidad especialidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Especialidad> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Especialidad obtenerPorId(String idEspecialidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
