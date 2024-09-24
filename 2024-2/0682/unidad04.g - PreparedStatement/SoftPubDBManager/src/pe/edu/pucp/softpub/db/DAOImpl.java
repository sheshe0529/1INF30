package pe.edu.pucp.softpub.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.config.DBManager;

public abstract class DAOImpl {

    protected String nombre_tabla;
    protected Connection conexion;
    protected PreparedStatement statement;
    protected ResultSet resultSet; 
    protected Boolean retornarLlavePrimaria;

    public DAOImpl(String nombre_tabla){
        this.nombre_tabla = nombre_tabla;
        this.retornarLlavePrimaria = false;
    }
    
    protected void cerrarConexion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.close();
        }
    }

    protected void iniciarTransaccion() throws SQLException {
        this.conexion = DBManager.getInstance().getConnection();
        this.conexion.setAutoCommit(false);
    }

    protected void comitarTransaccion() throws SQLException {
        this.conexion.commit();
    }

    protected void rollbackTransaccion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.rollback();
        }
    }

    protected Integer ejecutarModificacionesEnBD(String sql) throws SQLException {
        this.statement = this.conexion.prepareStatement(sql);
        return this.statement.executeUpdate(sql);
    }
    
    private void ejecutarConsultaEnBD(String sql) throws SQLException {
        this.statement = this.conexion.prepareStatement(sql);
        this.resultSet = this.statement.executeQuery();
    }

    public Integer insertar() {
        Integer resultado = 0;
        try {
            this.iniciarTransaccion();
            String sql = this.generarSQLParaInsercion();
            resultado = this.ejecutarModificacionesEnBD(sql);
            if (this.retornarLlavePrimaria){
                Integer id = this.retornarUltimoAutoGenerado();
                resultado = id;
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            try {
                this.rollbackTransaccion();
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    private String generarSQLParaInsercion() {
        String sql = "insert into ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" (");
        sql = sql.concat(this.obtenerListaAtributosParaInsertar());
        sql = sql.concat(" ) values (");
        sql = sql.concat(this.obtenerListaValoresParaInsertar());
        sql = sql.concat(")");      
        return sql;
    }

    protected abstract String obtenerListaAtributosParaInsertar();
    
    protected abstract String obtenerListaValoresParaInsertar();

    /*este método siempre se usa dentro de una transacción. */
    protected Integer retornarUltimoAutoGenerado() throws SQLException {
        Integer resultado = null;
        String sql = "select @@last_insert_id as id";
        this.ejecutarConsultaEnBD(sql);
        if (this.resultSet.next())
            resultado = this.resultSet.getInt("id");
        return resultado;
    }
    
}
