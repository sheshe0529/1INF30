package pe.edu.pucp.softpub.persona.daoImp;

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
        return insertar();
    }

    @Override
    protected String obtenerListaDeAtributosParaInsert() {
        return "idEspecialidad, especialidad, facultad, nivel";
    }

    @Override
    protected String obtenerListaDeValoresParaInsert() {
        String sql = "";
        sql = sql.concat(this.especialidad.getIdEspecialidad().toString());
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.especialidad.getEspecialidad() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.especialidad.getFacultad() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.especialidad.getNivel().toString() + "'");
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
    public Especialidad obtenerPorId(Integer idEspecialidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
