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
        this.apellido = apellido;
        this.nombre=nombre;
    }
    
}
