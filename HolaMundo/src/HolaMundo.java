//Mi clase en Java
public class HolaMundo {
    public static void main(String args[]){
        var usuario = "Juan";
        var titulo = "Ingeniero";
        var union = titulo + " " +usuario;
        //Conquetanación en Java
        System.out.println("union = " + union);
        var i = 3;
        var j = 4;
        System.out.println(i+j); //Se realiza la suma de numeros
        System.out.println(i+j+usuario);
        /*
        De izquierda a derecha se evalua las expresiones
        */
        System.out.println(usuario +i+j); //Contexto Cadena
        /*
        Si primero encuentra una cadena, todo lo demas lo va a concatenar
        */
        System.out.println(usuario + (i+j));
        /*
        El parentesis cambia la dirección de lo que se esta evaluando
        dando prioridad al parentesis
        */
        
    }
}
