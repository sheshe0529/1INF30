package pe.edu.pucp.softpub.persona.daoImp;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.config.DBManager;
import pe.edu.pucp.softpub.persona.dao.SeccionDAO;
import pe.edu.pucp.softpub.persona.model.Seccion;

public class SeccionDAOImpl implements SeccionDAO{
    
    private Connection conexion;
    private Statement statement;
    private ResultSet resultset;

    @Override
    public Integer insertar(Seccion seccion) {
        Integer resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "insert into Seccion(idSeccion, seccion, departamento) values (";
            sql = sql.concat("'" + seccion.getIdSeccion() + "'");
            sql = sql.concat(",");
            sql = sql.concat("'" + seccion.getSeccion() + "'");
            sql = sql.concat(",");
            sql = sql.concat("'" + seccion.getDepartamento() + "'");
            sql = sql.concat(")");
            this.statement = this.conexion.createStatement();
            resultado = this.statement.executeUpdate(sql);
            this.conexion.commit();
        } catch (SQLException ex) {
            if (this.conexion != null){
                try {
                    this.conexion.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(SeccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(SeccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                if (this.conexion != null)
                    this.conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SeccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public Integer modificar(Seccion seccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Seccion seccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Seccion> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Seccion obtenerPorId(String idSeccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
