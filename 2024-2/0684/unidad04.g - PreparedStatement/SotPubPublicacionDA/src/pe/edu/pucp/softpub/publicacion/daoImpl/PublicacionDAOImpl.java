package pe.edu.pucp.softpub.publicacion.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.softpub.publicacion.dao.PublicacionDAO;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;

public class PublicacionDAOImpl implements PublicacionDAO{

    @Override
    public Integer insertar(Publicacion publicacion) {
        this.retornarLlavePrimaria = true;
        this.publicacion = publicacion;
        Integer id = insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    public Integer modificar(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Publicacion> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Publicacion obtenerPorId(Integer idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
