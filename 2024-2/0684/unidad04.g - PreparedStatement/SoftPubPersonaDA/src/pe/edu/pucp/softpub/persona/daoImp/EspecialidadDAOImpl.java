package pe.edu.pucp.softpub.persona.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.db.DAOImpl;
import pe.edu.pucp.softpub.persona.dao.EspecialidadDAO;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Nivel;

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
        ArrayList<Especialidad> listaEspecialidad = new ArrayList();
        try {
            this.abrirConexion();
            String sql = "select idEspecialidad, especialidad, facultad, nivel from Especialidad";
            this.ejecutarConsultaEnBD(sql);
            while (this.resultset.next()) {
                Especialidad especialidad_local = new Especialidad();
                especialidad_local.setIdEspecialidad(this.resultset.getInt("idEspecialidad"));
                especialidad_local.setEspecialidad(this.resultset.getString("especialidad"));
                especialidad_local.setFacultad(this.resultset.getString("facultad"));
                especialidad_local.setNivel(Nivel.valueOf(this.resultset.getString("nivel")));
                listaEspecialidad.add(especialidad_local);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(EspecialidadDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaEspecialidad;
    }

    @Override
    public Especialidad obtenerPorId(Integer idEspecialidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
