
package clases;
public class Prueba {
    //Inicio de la declaracion de objetos
    public static void main(String []arg){
        //Declaracipon de objetos con la classe persona
       Persona persona = new Persona();
       //Accesos a los atributos de la clase
       persona.nombre="Karla";
       persona.apellido="Paredes";
       //Acceso de los atributos de la clase
       persona.desplegarInformacion();
       
       Persona personaDos = new Persona();//Instancia de la personaDos u objeto
        System.out.println("personaDos = " + personaDos);
        //El resultado es el lugar de la memoria en donde se guardo
        System.out.println("persona = " + persona);
        
        personaDos.desplegarInformacion();
        //Nos dara información de null ya que no hay valores
        
        personaDos.nombre="Juan";
        personaDos.apellido = "Pérez";
        personaDos.desplegarInformacion();
    } 
}
