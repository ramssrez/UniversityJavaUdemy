
//Importar la clase Scanner para usarla
public class HolaMundo {

    public static void main(String args[]) {
        //Tipos de primitivos booleanos tambien de tipo bandera
        boolean varBoolean = true;
        System.out.println("varBoolean = " + varBoolean);
        
        if (varBoolean == true){
            //Otra manera puede ser
            //if(varBoolean)
            System.out.println("Bandera Verdadera");
        }else{
            System.out.println("Bandera es Falsa");
        }
        
        var edad = 10;
        var esAdulto = edad>=18;
        System.out.println("esAdulto = " + esAdulto);
        if (esAdulto){
            System.out.println("Eres mayor de edad");
        }else{
            System.out.println("Eres menor de edad");
        }
        
    }
}
