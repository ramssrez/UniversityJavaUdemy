package clases;

public enum TipoEscritura {
    CLASICO("Escritura a mano"),
    MODERNOS("Escritura Digital");
    
    private final String descripcion;
    private TipoEscritura(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
}
