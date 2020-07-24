
package test;
import dominio.Persona;
public class PersonaPrueba {
    public static void main(String[] args) {
        Persona personaUno = new Persona("Juan", 5000.00,false);
        System.out.println("personaUno = " + personaUno.getNombre());
        personaUno.setNombre("Juann Carlos");
        System.out.println("personaUno = " + personaUno.getNombre());
        System.out.println("personaUno sueldo = " + personaUno.getSueldo());
        System.out.println("personaUno eliminado = " + personaUno.isEliminado());
        
        Persona personaDos = new Persona("Karla", 6000.00,true);
        System.out.println("personaDos nombre = " + personaDos.getNombre());
        System.out.println("personaDos sueldo= " + personaDos.getSueldo());
        System.out.println("personaDos eliminado = " + personaDos.isEliminado());
        
        personaDos.setEliminado(true);
        personaDos.setNombre("Karla Paola");
        personaDos.setSueldo(6500.00);
        System.out.println("personaDos nombre = " + personaDos.getNombre());
        System.out.println("personaDos sueldo= " + personaDos.getSueldo());
        System.out.println("personaDos eliminado = " + personaDos.isEliminado());
        
        System.out.println("Persona Uno: " + personaUno.toString());
        System.out.println("Pesona Dos: " + personaDos.toString());
         
    }
}
 