package clases;
/*
Inicio de la parte de la creacion de clases
en este comenzamos relizando en un paquete llamado clases
si no existe el paquete nos va a marcar un error
*/

//palabra reservada public para poder tener acceso a esta clase
public class Persona {
    //Declaración de atributos en una clase
   String nombre ;
   String apellido;
   
   /*
   Los metodos pueden recibir elementos y estos son llamados
   argumentos y puede regrasar un valor llamado valor de retorno
   */
   public void desplegarInformacion(){
       System.out.println("El nombre: " + nombre);
       System.out.println("El apellido: " + apellido );
   }
}
