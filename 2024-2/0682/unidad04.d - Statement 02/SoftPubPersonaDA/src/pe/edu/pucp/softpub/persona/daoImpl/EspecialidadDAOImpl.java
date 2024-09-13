package pe.edu.pucp.softpub.persona.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.config.DBManager;
import pe.edu.pucp.softpub.persona.dao.EspecialidadDAO;
import pe.edu.pucp.softpub.persona.model.Especialidad;

public class EspecialidadDAOImpl implements EspecialidadDAO{

    private Connection conexion;
    private Statement statement;
    private ResultSet resultSet;
    
    @Override
    public Integer insertar(Especialidad especialidad) {
        Integer resultado = 0;
        try {            
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "insert into Especialidad (idEspecialidad, especialidad, facultad, nivel) values(";
            sql = sql.concat("'" + especialidad.getIdEspecialidad()+ "'");
            sql = sql.concat(", ");
            sql = sql.concat("'" + especialidad.getEspecialidad()+ "'");
            sql = sql.concat(", ");
            sql = sql.concat("'" + especialidad.getFacultad()+ "'");
            sql = sql.concat(", ");
            sql = sql.concat("'" + especialidad.getNivel().toString()+ "'");
            sql = sql.concat(")");
            this.statement = this.conexion.createStatement();
            resultado = this.statement.executeUpdate(sql);
            this.conexion.commit();
        } catch (SQLException ex) {
            try {
                if (this.conexion != null)
                    this.conexion.rollback();
                Logger.getLogger(SeccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(SeccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally{
            if (this.conexion != null)
                try {
                    this.conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SeccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
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
