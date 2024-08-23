package publicaciones_v04;

public class Tesis extends Publicacion{
    private Clase_de_Tesis clase;
    private String departamento;
    private String institucion;
    private String ciudad;
    private String estado;

    public Tesis(String nombre, String[] autores, Integer cantidad_autores, Integer año, Clase_de_Tesis clase, String departamento, String institucion, String ciudad, String estado) {
        super(nombre, autores, cantidad_autores, año);
        this.clase = clase;
        this.departamento = departamento;
        this.institucion = institucion;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public Tesis(String nombre, String autor, Integer año, Clase_de_Tesis clase, String departamento, String institucion, String ciudad, String estado) {
        super(nombre, autor, año);
        this.clase = clase;
        this.departamento = departamento;
        this.institucion = institucion;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    @Override
    public void referenciar() {
        String referencia = "[" + Publicacion.orden_presentacion + "] ";
        for(int i=0; i<this.cantidad_autores; i++){
            if (i!=0){
                if (i==this.cantidad_autores-1){
                    referencia = referencia.concat(" and ");
                }
                else{
                    referencia = referencia.concat(", ");
                }
            }
            referencia = referencia.concat(this.autores[i]);                    
        }
        referencia = referencia.concat(", ");
        referencia = referencia.concat(this.nombre);
        referencia = referencia.concat(", ");
        switch(this.clase){
            case Clase_de_Tesis.LICENCIATURA -> referencia = referencia.concat("Tesis de Licenciatura");
            case Clase_de_Tesis.MAESTRIA -> referencia = referencia.concat("Tesis de Licenciatura");
            case Clase_de_Tesis.DOCTORADO -> referencia = referencia.concat("Tesis de Doctorado");    
        }
        
        referencia = referencia.concat(", ");
        referencia = referencia.concat(this.departamento);
        referencia = referencia.concat(", ");
        referencia = referencia.concat(this.institucion);
        referencia = referencia.concat(", ");
        referencia = referencia.concat(this.ciudad);
        referencia = referencia.concat(", ");
        referencia = referencia.concat(this.estado);
        referencia = referencia.concat(", ");
        referencia = referencia.concat(this.año.toString());
        referencia = referencia.concat(".");
        System.out.println(referencia);
    }
    
    
}
