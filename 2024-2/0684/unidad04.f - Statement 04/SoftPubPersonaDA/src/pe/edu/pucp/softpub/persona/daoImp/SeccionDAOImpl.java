package pe.edu.pucp.softpub.persona.daoImp;

import java.util.ArrayList;
import pe.edu.pucp.softpub.db.DAOImpl;
import pe.edu.pucp.softpub.persona.dao.SeccionDAO;
import pe.edu.pucp.softpub.persona.model.Seccion;

public class SeccionDAOImpl extends DAOImpl implements SeccionDAO{

    private Seccion seccion;
    
    public SeccionDAOImpl() {
        super("Seccion");
        seccion =  null;
    }
        
    @Override
    public Integer insertar(Seccion seccion) {
        this.seccion = seccion;
        return this.insertar();
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsert() {
        return "idSeccion, seccion, departamento";
    }

    @Override
    protected String obtenerListaDeValoresParaInsert() {
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
