package domain;

public class Persona {
    //Bloque de inicializacion estaticos y no estaticos antes del constructor

    private final int idPersona;
    private static int contadorPersona;

    //Este es una blosque de inicialización estatico
    static {
        System.out.println("Ejecución bloque statico");
        ++Persona.contadorPersona;
        //No es una variable estatica, por lo que no se puede realizar el proceso
        //idPersona = 10;
    }

    //este es un bloque de inicialización no estático, o dinamico, debe ser antes del constructor
    {
        System.out.println("Ejecución bloque no estatico");
        this.idPersona = Persona.contadorPersona++;
    }
    
    public Persona(){
        System.out.println("Ejecución del constructor"); 
    }

    public int getIdPersona() {
        return idPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + '}';
    }
    
    
    
}
