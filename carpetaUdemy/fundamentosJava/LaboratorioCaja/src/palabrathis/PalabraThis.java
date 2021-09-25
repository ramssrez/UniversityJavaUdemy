package palabrathis;
public class PalabraThis {
    public static void main(String [] args){
        Persona persona = new Persona("Karla", "Paredes");
        System.out.println("persona = " + persona);
        System.out.println("Persona nombre: " + persona.nombre);
        System.out.println("Persona apellido:  " + persona.apellido);
    }
}

class Persona {
    /*
    Como no tien identificador de acceso, las palabras reservadas son
    default o package
    */
    String nombre ;
    String apellido;

    Persona(String nombre, String apellido) {
        //super(); llamada al constructor de la clase padre (Objest)
        System.out.println("Constructor de la clase Persona");
        this.apellido = apellido;
        this.nombre=nombre;
        System.out.println("Objeto persona con la palabra this:" + this);
        new Imprimir().imprimir(this); //Imprimir imprimir = new Imprimir();
        
    }
    
}

class Imprimir{
    public Imprimir(){
        super();// constructor de la clase object (padre) para reservar memoria
    }
    public void imprimir(Persona persona){
        System.out.println("persona desde imprimir" + persona);
        //El this de esta parte es para el objeto de tipo imprimir
        System.out.println("Impresión del objeto actual (this)= " + this);
    }
}
