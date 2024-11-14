package pe.edu.pucp.softpub.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softpub.grupo.bo.GrupoBO;
import pe.edu.pucp.softpub.grupo.bo.LineaBO;
import pe.edu.pucp.softpub.grupo.bo.ProductosLineaBO;
import pe.edu.pucp.softpub.grupo.model.Grupo;
import pe.edu.pucp.softpub.grupo.model.Linea;
import pe.edu.pucp.softpub.persona.bo.AlumnoBO;
import pe.edu.pucp.softpub.persona.bo.EspecialidadBO;
import pe.edu.pucp.softpub.persona.bo.ProfesorBO;
import pe.edu.pucp.softpub.persona.bo.SeccionBO;
import pe.edu.pucp.softpub.persona.model.Alumno;
import pe.edu.pucp.softpub.persona.model.Categoria;
import pe.edu.pucp.softpub.persona.model.Dedicacion;
import pe.edu.pucp.softpub.persona.model.Especialidad;
import pe.edu.pucp.softpub.persona.model.Genero;
import pe.edu.pucp.softpub.persona.model.Nivel;
import pe.edu.pucp.softpub.persona.model.Profesor;
import pe.edu.pucp.softpub.persona.model.Seccion;
import pe.edu.pucp.softpub.publicacion.bo.ArticuloBO;
import pe.edu.pucp.softpub.publicacion.bo.CapituloBO;
import pe.edu.pucp.softpub.publicacion.bo.ConferenciaBO;
import pe.edu.pucp.softpub.publicacion.bo.EditorialBO;
import pe.edu.pucp.softpub.publicacion.bo.LibroBO;
import pe.edu.pucp.softpub.publicacion.model.Publicacion;

@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    private final SeccionBO seccionBO;
    private final EspecialidadBO especialidadBO;
    private final AlumnoBO alumnoBO;
    private final ProfesorBO profesorBO;
    private final ArticuloBO articuloBO;
    private final CapituloBO capituloBO;
    private final ConferenciaBO conferenciaBO;
    private final EditorialBO editorialBO;
    private final LibroBO libroBO;
    private final GrupoBO grupoBO;
    private final LineaBO lineaBO;
    private final ProductosLineaBO productosLineaBO;

    public ServicioWeb() {
        this.seccionBO = new SeccionBO();
        this.especialidadBO = new EspecialidadBO();
        this.alumnoBO = new AlumnoBO();
        this.profesorBO = new ProfesorBO();
        this.articuloBO = new ArticuloBO();
        this.capituloBO = new CapituloBO();
        this.conferenciaBO = new ConferenciaBO();
        this.editorialBO = new EditorialBO();
        this.libroBO = new LibroBO();
        this.grupoBO = new GrupoBO();
        this.lineaBO = new LineaBO();
        this.productosLineaBO = new ProductosLineaBO();
    }

    @WebMethod(operationName = "seccion_insertar")
    public Integer seccion_insertar(@WebParam(name = "idSeccion") String idSeccion, @WebParam(name = "nombre_seccion") String nombre_seccion, @WebParam(name = "departamento") String departamento) {
        return this.seccionBO.insertar(idSeccion, nombre_seccion, departamento);
    }

    @WebMethod(operationName = "seccion_modificar")
    public Integer seccion_modificar(@WebParam(name = "name") String idSeccion, @WebParam(name = "nombre_seccion") String nombre_seccion, @WebParam(name = "departamento") String departamento) {
        return this.seccionBO.modificar(idSeccion, nombre_seccion, departamento);
    }

    @WebMethod(operationName = "seccion_eliminar")
    public Integer seccion_eliminar(@WebParam(name = "idSeccion") String idSeccion) {
        return this.seccionBO.eliminar(idSeccion);
    }

    @WebMethod(operationName = "seccion_listarTodos")
    public ArrayList<Seccion> seccion_listarTodos() {
        return this.seccionBO.listarTodos();
    }

    @WebMethod(operationName = "seccion_obtenerPorId")
    public Seccion seccion_obtenerPorId(@WebParam(name = "idSeccion") String idSeccion) {
        return this.seccionBO.obtenerPorId(idSeccion);
    }

    @WebMethod(operationName = "especialidad_insertar")
    public Integer especialidad_insertar(@WebParam(name = "idEspecialidad") Integer idEspecialidad, @WebParam(name = "nombre_especialidad") String nombre_especialidad, @WebParam(name = "facultad") String facultad, @WebParam(name = "nivel") Nivel nivel) {
        return especialidadBO.insertar(idEspecialidad, nombre_especialidad, facultad, nivel);
    }

    @WebMethod(operationName = "especialidad_modificar")
    public Integer especialidad_modificar(@WebParam(name = "idEspecialidad") Integer idEspecialidad, @WebParam(name = "nombre_especialidad") String nombre_especialidad, @WebParam(name = "facultad") String facultad, @WebParam(name = "nivel") Nivel nivel) {
        return especialidadBO.modificar(idEspecialidad, nombre_especialidad, facultad, nivel);
    }

    @WebMethod(operationName = "especialidad_eliminar")
    public Integer especialidad_eliminar(@WebParam(name = "idEspecialidad") Integer idEspecialidad) {
        return especialidadBO.eliminar(idEspecialidad);
    }

    @WebMethod(operationName = "especialidad_listarTodos")
    public ArrayList<Especialidad> especialidad_listarTodos() {
        return especialidadBO.listarTodos();
    }

    @WebMethod(operationName = "especialidad_obtenerPorId")
    public Especialidad especialidad_obtenerPorId(@WebParam(name = "idEspecialidad") Integer idEspecialidad) {
        return especialidadBO.obtenerPorId(idEspecialidad);
    }

    @WebMethod(operationName = "alumno_insertar")
    public Integer alumno_insertar(@WebParam(name = "paterno") String paterno, @WebParam(name = "materno") String materno, @WebParam(name = "nombre") String nombre, @WebParam(name = "genero") Genero genero, @WebParam(name = "fechaCreacion") Date fechaCreacion, @WebParam(name = "usuarioCreacion") String usuarioCreacion, @WebParam(name = "matriculado") Boolean matriculado, @WebParam(name = "especialidad") Especialidad especialidad) {
        return this.alumnoBO.insertar(paterno, materno, nombre, genero, fechaCreacion, usuarioCreacion, matriculado, especialidad);
    }

    @WebMethod(operationName = "alumno_modificar")
    public Integer alumno_modificar(@WebParam(name = "idPersona") Integer idPersona, @WebParam(name = "paterno") String paterno, @WebParam(name = "materno") String materno, @WebParam(name = "nombre") String nombre, @WebParam(name = "genero") Genero genero, @WebParam(name = "fechaModificacion") Date fechaModificacion, @WebParam(name = "usuarioModificacion") String usuarioModificacion, @WebParam(name = "matriculado") Boolean matriculado, @WebParam(name = "especialidad") Especialidad especialidad) {
        return this.alumnoBO.modificar(idPersona, paterno, materno, nombre, genero, fechaModificacion, usuarioModificacion, matriculado, especialidad);
    }

    @WebMethod(operationName = "alumno_eliminar")
    public Integer alumno_eliminar(@WebParam(name = "idPersona") Integer idPersona) {
        return this.alumnoBO.eliminar(idPersona);
    }

    @WebMethod(operationName = "alumno_listarTodos")
    public ArrayList<Alumno> alumno_listarTodos() {
        return this.alumnoBO.listarTodos();
    }

    @WebMethod(operationName = "alumno_obtenerPorId")
    public Alumno alumno_obtenerPorId(@WebParam(name = "idPersona") Integer idPersona) {
        return this.alumnoBO.obtenerPorId(idPersona);
    }

    @WebMethod(operationName = "profesor_insertar")
    public Integer profesor_insertar(@WebParam(name = "paterno") String paterno, @WebParam(name = "materno") String materno, @WebParam(name = "nombre") String nombre, @WebParam(name = "genero") Genero genero, @WebParam(name = "fechaCreacion") Date fechaCreacion, @WebParam(name = "usuarioCreacion") String usuarioCreacion, @WebParam(name = "categoria") Categoria categoria, @WebParam(name = "dedicacion") Dedicacion dedicacion, @WebParam(name = "activo") Boolean activo, @WebParam(name = "seccion") Seccion seccion) {
        return this.profesorBO.insertar(paterno, materno, nombre, genero, fechaCreacion, usuarioCreacion, categoria, dedicacion, activo, seccion);
    }

    @WebMethod(operationName = "profesor_modificar")
    public Integer profesor_modificar(@WebParam(name = "idPersona") Integer idPersona, @WebParam(name = "paterno") String paterno, @WebParam(name = "materno") String materno, @WebParam(name = "nombre") String nombre, @WebParam(name = "genero") Genero genero, @WebParam(name = "fechaModificacion") Date fechaModificacion, @WebParam(name = "usuarioModificacion") String usuarioModificacion, @WebParam(name = "categoria") Categoria categoria, @WebParam(name = "dedicacion") Dedicacion dedicacion, @WebParam(name = "activo") Boolean activo, @WebParam(name = "seccion") Seccion seccion) {
        return this.profesorBO.modificar(idPersona, paterno, materno, nombre, genero, fechaModificacion, usuarioModificacion, categoria, dedicacion, activo, seccion);
    }

    @WebMethod(operationName = "profesor_eliminar")
    public Integer profesor_eliminar(@WebParam(name = "idPersona") Integer idPersona) {
        return this.profesorBO.eliminar(idPersona);
    }

    @WebMethod(operationName = "profesor_listarTodos")
    public ArrayList<Profesor> profesor_listarTodos() {
        return this.profesorBO.listarTodos();
    }

    @WebMethod(operationName = "profesor_obtenerPorId")
    public Profesor profesor_obtenerPorId(@WebParam(name = "idPersona") Integer idPersona) {
        return this.profesorBO.obtenerPorId(idPersona);
    }

    @WebMethod(operationName = "profesor_existeProfesor")
    public Boolean profesor_existeProfesor(@WebParam(name = "idPersona") Integer idPersona) {
        return this.profesorBO.existeProfesor(idPersona);
    }

    @WebMethod(operationName = "articulo_insertar")
    public Integer articulo_insertar(@WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "volumen") String volumen, @WebParam(name = "numero") String numero, @WebParam(name = "paginaInicio") Integer paginaInicio,
            @WebParam(name = "paginaFin") Integer paginaFin, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "ISSN") String ISSN) {
        return this.articuloBO.insertar(titulo, origen, volumen, numero, paginaInicio,
                paginaFin, fechaPublicacion, DOI, ISSN);
    }

    @WebMethod(operationName = "articulo_modificar")
    public Integer articulo_modificar(@WebParam(name = "idPublicacion") Integer idPublicacion, @WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "volumen") String volumen, @WebParam(name = "numero") String numero, @WebParam(name = "paginaInicio") Integer paginaInicio,
            @WebParam(name = "paginaFin") Integer paginaFin, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "ISSN") String ISSN) {
        return this.articuloBO.modificar(idPublicacion, titulo, origen, volumen, numero, paginaInicio,
                paginaFin, fechaPublicacion, DOI, ISSN);
    }

    @WebMethod(operationName = "articulo_eliminar")
    public Integer articulo_eliminar(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.articuloBO.eliminar(idPublicacion);
    }

    @WebMethod(operationName = "articulo_listarTodos")
    public ArrayList<Publicacion> articulo_listarTodos() {
        return this.articuloBO.listarTodos();
    }

    @WebMethod(operationName = "articulo_obtenerPorId")
    public Publicacion articulo_obtenerPorId(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.articuloBO.obtenerPorId(idPublicacion);
    }

    @WebMethod(operationName = "capitulo_insertar")
    public Integer capitulo_insertar(@WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "ISBN") String ISBN, @WebParam(name = "edicion") String edicion, @WebParam(name = "lugar") String lugar, @WebParam(name = "editorial") String editorial) {
        return this.capituloBO.insertar(titulo, origen, fechaPublicacion, DOI, ISBN, edicion, lugar, editorial);
    }

    @WebMethod(operationName = "capitulo_modificar")
    public Integer capitulo_modificar(@WebParam(name = "idPublicacion") Integer idPublicacion, @WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "ISBN") String ISBN, @WebParam(name = "edicion") String edicion, @WebParam(name = "lugar") String lugar, @WebParam(name = "editorial") String editorial) {
        return this.capituloBO.modificar(idPublicacion, titulo, origen, fechaPublicacion, DOI, ISBN, edicion, lugar, editorial);
    }

    @WebMethod(operationName = "capitulo_eliminar")
    public Integer capitulo_eliminar(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.capituloBO.eliminar(idPublicacion);
    }

    @WebMethod(operationName = "capitulo_listarTodos")
    public ArrayList<Publicacion> capitulo_listarTodos() {
        return this.capituloBO.listarTodos();
    }

    @WebMethod(operationName = "capitulo_obtenerPorId")
    public Publicacion capitulo_obtenerPorId(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.capituloBO.obtenerPorId(idPublicacion);
    }

    @WebMethod(operationName = "conferencia_insertar")
    public Integer conferencia_insertar(@WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "paginaInicio") Integer paginaInicio, @WebParam(name = "paginaFin") Integer paginaFin, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "lugar") String lugar, @WebParam(name = "ciudad") String ciudad, @WebParam(name = "estado") String estado) {
        return this.conferenciaBO.insertar(titulo, origen, paginaInicio, paginaFin, fechaPublicacion, DOI, lugar, ciudad, estado);
    }

    @WebMethod(operationName = "conferencia_modificar")
    public Integer conferencia_modificar(@WebParam(name = "idPublicacion") Integer idPublicacion, @WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "paginaInicio") Integer paginaInicio, @WebParam(name = "paginaFin") Integer paginaFin, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "lugar") String lugar, @WebParam(name = "ciudad") String ciudad, @WebParam(name = "estado") String estado) {
        return this.conferenciaBO.modificar(idPublicacion, titulo, origen, paginaInicio, paginaFin, fechaPublicacion, DOI, lugar, ciudad, estado);
    }

    @WebMethod(operationName = "conferencia_eliminar")
    public Integer conferencia_eliminar(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.conferenciaBO.eliminar(idPublicacion);
    }

    @WebMethod(operationName = "conferencia_listarTodos")
    public ArrayList<Publicacion> conferencia_listarTodos() {
        return this.conferenciaBO.listarTodos();
    }

    @WebMethod(operationName = "conferencia_obtenerPorId")
    public Publicacion conferencia_obtenerPorId(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.conferenciaBO.obtenerPorId(idPublicacion);
    }

    @WebMethod(operationName = "editorial_insertar")
    public Integer editorial_insertar(@WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "volumen") String volumen, @WebParam(name = "numero") String numero, @WebParam(name = "paginaInicio") Integer paginaInicio,
            @WebParam(name = "paginaFin") Integer paginaFin, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "ISSN") String ISSN) {
        return this.editorialBO.insertar(titulo, origen, volumen, numero, paginaInicio,
                paginaFin, fechaPublicacion, DOI, ISSN);
    }

    @WebMethod(operationName = "editorial_modificar")
    public Integer editorial_modificar(@WebParam(name = "idPublicacion") Integer idPublicacion, @WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "volumen") String volumen, @WebParam(name = "numero") String numero, @WebParam(name = "paginaInicio") Integer paginaInicio,
            @WebParam(name = "paginaFin") Integer paginaFin, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "ISSN") String ISSN) {
        return this.editorialBO.modificar(idPublicacion, titulo, origen, volumen, numero, paginaInicio,
                paginaFin, fechaPublicacion, DOI, ISSN);
    }

    @WebMethod(operationName = "editorial_eliminar")
    public Integer editorial_eliminar(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.editorialBO.eliminar(idPublicacion);
    }

    @WebMethod(operationName = "editorial_listarTodos")
    public ArrayList<Publicacion> editorial_listarTodos() {
        return this.editorialBO.listarTodos();
    }

    @WebMethod(operationName = "editorial_obtenerPorId")
    public Publicacion editorial_obtenerPorId(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.editorialBO.obtenerPorId(idPublicacion);
    }

    @WebMethod(operationName = "libro_insertar")
    public Integer libro_insertar(@WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "ISBN") String ISBN, @WebParam(name = "edicion") String edicion, @WebParam(name = "lugar") String lugar, @WebParam(name = "editorial") String editorial) {
        return this.libroBO.insertar(titulo, origen, fechaPublicacion, DOI, ISBN, edicion, lugar, editorial);
    }

    @WebMethod(operationName = "libro_modificar")
    public Integer libro_modificar(@WebParam(name = "idPublicacion") Integer idPublicacion, @WebParam(name = "titulo") String titulo, @WebParam(name = "origen") String origen, @WebParam(name = "fechaPublicacion") Date fechaPublicacion, @WebParam(name = "DOI") String DOI, @WebParam(name = "ISBN") String ISBN, @WebParam(name = "edicion") String edicion, @WebParam(name = "lugar") String lugar, @WebParam(name = "editorial") String editorial) {
        return this.libroBO.modificar(idPublicacion, titulo, origen, fechaPublicacion, DOI, ISBN, edicion, lugar, editorial);
    }

    @WebMethod(operationName = "libro_eliminar")
    public Integer libro_eliminar(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.libroBO.eliminar(idPublicacion);
    }

    @WebMethod(operationName = "libro_listarTodos")
    public ArrayList<Publicacion> libro_listarTodos() {
        return this.libroBO.listarTodos();
    }

    @WebMethod(operationName = "libro_obtenerPorId")
    public Publicacion libro_obtenerPorId(@WebParam(name = "idPublicacion") Integer idPublicacion) {
        return this.libroBO.obtenerPorId(idPublicacion);
    }

    @WebMethod(operationName = "grupo_insertar")
    public Integer grupo_insertar(@WebParam(name = "nombre") String nombre, @WebParam(name = "sigla") String sigla) {
        return this.grupoBO.insertar(nombre, sigla);
    }

    @WebMethod(operationName = "grupo_modificar")
    public Integer grupo_modificar(@WebParam(name = "idGrupo") Integer idGrupo, @WebParam(name = "nombre") String nombre, @WebParam(name = "sigla") String sigla) {
        return this.grupoBO.modificar(idGrupo, nombre, sigla);
    }

    @WebMethod(operationName = "grupo_eliminar")
    public Integer grupo_eliminar(@WebParam(name = "idGrupo") Integer idGrupo) {
        return this.grupoBO.eliminar(idGrupo);
    }

    @WebMethod(operationName = "grupo_listarTodos")
    public ArrayList<Grupo> grupo_listarTodos() {
        return this.grupoBO.listarTodos();
    }

    @WebMethod(operationName = "grupo_obtenerPorId")
    public Grupo grupo_obtenerPorId(@WebParam(name = "idGrupo") Integer idGrupo) {
        return this.grupoBO.obtenerPorId(idGrupo);
    }

    @WebMethod(operationName = "linea_insertar")
    public Integer linea_insertar(@WebParam(name = "idGrupo") Integer idGrupo, @WebParam(name = "idLinea") Integer idLinea, @WebParam(name = "nombre") String nombre) {
        return this.lineaBO.insertar(idGrupo, idLinea, nombre);
    }

    @WebMethod(operationName = "linea_modificar")
    public Integer linea_modificar(@WebParam(name = "idGrupo") Integer idGrupo, @WebParam(name = "idLinea") Integer idLinea, @WebParam(name = "nombre") String nombre) {
        return this.lineaBO.modificar(idGrupo, idLinea, nombre);
    }

    @WebMethod(operationName = "linea_eliminar")
    public Integer linea_eliminar(@WebParam(name = "idGrupo") Integer idGrupo, @WebParam(name = "idLinea") Integer idLinea) {
        return this.lineaBO.eliminar(idGrupo, idLinea);
    }

    @WebMethod(operationName = "linea_listarTodos")
    public ArrayList<Linea> linea_listarTodos(@WebParam(name = "idGrupo") Integer idGrupo) {
        return this.lineaBO.listarTodos(idGrupo);
    }

    @WebMethod(operationName = "linea_obtenerPorId")
    public Linea linea_obtenerPorId(@WebParam(name = "idGrupo") Integer idGrupo, @WebParam(name = "idLinea") Integer idLinea) {
        return this.lineaBO.obtenerPorId(idGrupo, idLinea);
    }
}
