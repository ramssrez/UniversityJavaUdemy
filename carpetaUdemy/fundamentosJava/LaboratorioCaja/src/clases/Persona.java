
package clases;

public class Persona {
    /*
    Todas las clase heredan de la clase Object
    Si se trata de ingresar a la clase desde otra clase,
    esta no la permitira porque se encuentra en otro paquete
    Se le agragaron la sintaxis public para poder acceder desde otro paquete
    */
   public String nombre ;
   public String apellido;
   public void desplegarInformacion(){
       System.out.println("El nombre: " + nombre);
       System.out.println("El apellido: " + apellido );
   }
}
