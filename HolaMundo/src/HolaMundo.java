//Mi clase en Java
public class HolaMundo {
    public static void main(String args[]){
        //Definición de varables tipo entero
        int variableEntera = 10;
        System.out.println(variableEntera); 
        //Modificación del valor de la variable
        variableEntera = 5;
        System.out.println(variableEntera); 
        //Declaración de variables tipo String
        String variableCadena = "Saludos desde java";
        System.out.println(variableCadena);
        //Ejercicio de cambiar la variableCadena
        variableCadena = "Adios !!!!!";
        System.out.println(variableCadena);
        
        //Verion 10 de Java se puede utilizar var
        //var es inferencia de tipos de Java, de esta manera reconoce
        //el tipo de variable
        var variableDos = 15;
        System.out.println(variableDos);
        
        //Ejercicio con tipo de dato String
        var variableCadenaDos ="Nueva Cadena";
        System.out.println("variableCadenaDos = " + variableCadenaDos);
        
        //Reglas para declar variables.
        /*
        No se puede iniciar con numeros
        No se puede empezar con mayuscula, por convencion se uso minuscula
        Es posible usar variables con acento, pero no es recomendaod
        No se puede utilizar caracteres especiales
        El guion bajo es posible
        Usar el simbolo de dolar tambien es posible
        */
        
        //Las siguientes variables son permitidos
        var miVariable = 1;
        var _miVariable = 2;
        var $miVariable = 3;
    }
}
