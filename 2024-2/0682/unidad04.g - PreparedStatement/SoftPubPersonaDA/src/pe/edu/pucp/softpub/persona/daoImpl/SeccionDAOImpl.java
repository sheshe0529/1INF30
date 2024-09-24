package pe.edu.pucp.softpub.persona.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.config.DBManager;
import pe.edu.pucp.softpub.db.DAOImpl;
import pe.edu.pucp.softpub.persona.dao.SeccionDAO;
import pe.edu.pucp.softpub.persona.model.Seccion;

public class SeccionDAOImpl extends DAOImpl implements SeccionDAO{

    private Seccion seccion;
    
    public SeccionDAOImpl() {
        super("Seccion");
        this.seccion = null;
    }
    
    @Override
    public Integer insertar(Seccion seccion) {
        this.seccion = seccion;
        return this.insertar();
    }
    
    @Override
    protected String obtenerListaAtributosParaInsertar() {
        return "idSeccion, seccion, departamento";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
                
        sql = sql.concat("'" + this.seccion.getIdSeccion() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.seccion.getSeccion() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.seccion.getDepartamento() + "'");
        return sql;
    }    

    @Override
    public Integer modificar(Seccion seccion) {
        Integer resultado = 0;
        try {            
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "update Seccion set ";            
            sql = sql.concat("seccion = '" + seccion.getSeccion() + "'");
            sql = sql.concat(", ");
            sql = sql.concat("departamento = '" + seccion.getDepartamento()+ "'");
            sql = sql.concat(" where ");
            sql = sql.concat("idSeccion = '" + seccion.getIdSeccion() + "'");            
            //TODO se debe refactorizar este código, enviar a DAOImpl
            //this.statement = this.conexion.createStatement();
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
