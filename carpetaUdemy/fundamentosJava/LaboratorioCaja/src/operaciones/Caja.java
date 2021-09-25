package operaciones;

public class Caja {
    //Atributos de la clase
    int ancho;
    int alto;
    int profundo;
    public Caja(){
        
    }
    public Caja (int ancho, int alto, int profundo){
        this.alto=alto;
        this.ancho=ancho;
        this.profundo=profundo;
        volumen();
    }
    
    public String volumen(){
        System.out.println("Uso del metodo volumen");
       return "El volume es: " + ((this.alto*this.ancho*this.profundo)); 
    }
    public void volumenReturn(){
        System.out.println("Uso de metodo Return");
        int volumen = this.alto*this.ancho*this.profundo;
        System.out.println("El vlumen es: " + volumen);
    }
    public int volumenArguemntos(int a, int b, int c){
        System.out.println("Uso de metodo con argumentos");
        this.alto=a;
        this.ancho=b;
        this.profundo=c;
        return (a*b*c);
    }
}
