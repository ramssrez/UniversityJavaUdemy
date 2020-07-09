
//Importar la clase Scanner para usarla
public class HolaMundo {

    public static void main(String args[]) {
        //Tipos de primitivos tipo char
        char caracter = 'a';
        System.out.println("caracter = " + caracter);
        //Checar lista de carcteres de tipo unicode
        
        //Usando el sisteme unicode de latinoamerica
        char varChar = '\u0021';
        System.out.println("varChar = " + varChar);
        
        //De esta marera usando los decimales a los que estan asociados
        char varCharDecinal = 33;
        System.out.println("varChardecinal = " + varCharDecinal);
        
        //Usando el simbolo pero con comillas simples
        char varCharSimbolo = '!';
        System.out.println("varCharSimbolo = " + varCharSimbolo);
        
        /*
        Se observo la forma en como se puede poner un simbolo
        con la estructura unicode, decimal y con el mismo simbolo
        al que estamos buscando   
        */
        
        System.out.println("Usando var");
        
        var varChar1 ='\u0021';
        System.out.println("varChar = " + varChar1);
        
        //En esta parte va a imprimir un entero, por lo que no reconoce un char
        var varCharDecinal1 = 33;
        System.out.println("varChardecinal = " + varCharDecinal1);
        
        var varCharSimbolo1 = '!';
        System.out.println("varCharSimbolo = " + varCharSimbolo1);
        
        int varEnteraSimbolo = '!';
        System.out.println("varEnteraSimbolo = " + varEnteraSimbolo);
        
        int letra = 'a';
        System.out.println("letra = " + letra);
    }
}
