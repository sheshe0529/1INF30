package publicaciones_v04;

public class Libro extends Publicacion {
    private String edicion;
    private String lugar;
    private String editorial;

    public Libro(String nombre, String[] autores, Integer cantidad_autores, Integer año, String edicion, String lugar, String editorial) {
        super(nombre, autores, cantidad_autores, año);
        this.edicion = edicion;
        this.lugar = lugar;
        this.editorial = editorial;
    }

    public Libro(String nombre, String autor, Integer año, String edicion, String lugar, String editorial) {
        super(nombre, autor, año);
        this.edicion = edicion;
        this.lugar = lugar;
        this.editorial = editorial;
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
        referencia = referencia.concat(". ");
        referencia = referencia.concat(this.edicion);
        referencia = referencia.concat(".");
        referencia = referencia.concat(this.lugar);
        referencia = referencia.concat(".");
        referencia = referencia.concat(this.editorial);
        referencia = referencia.concat(". ");        
        referencia = referencia.concat(this.año.toString());
        referencia = referencia.concat(".");
        System.out.println(referencia);
    }
    
    
}
