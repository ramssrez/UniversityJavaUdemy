
public class HolaMundo {

    public static void main(String args[]) {
        var nombre = "Karla";
        //caracter especial de salto de línea       \n
        System.out.println("Nueva Linea: \n" + nombre);

        //Caracter de tabulador     \t
        System.out.println("Tabulado: \t" + nombre);
        
        //Caracter de Retroceso     \b
        System.out.println("Retroceso: \b" + nombre);
        
        //Comilla Simple        \'
        System.out.println("Comilla Simple \'" + nombre + "\'");
        
        //Comilla doble
        System.out.println("Comilla Doble: \"" + nombre + "\"" );

    }
}
