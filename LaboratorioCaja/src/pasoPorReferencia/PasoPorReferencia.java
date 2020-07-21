
package pasoPorReferencia;

import clases.Persona;

public class PasoPorReferencia {
    public static void main(String[] args) {
        Persona personaUno = new Persona();
        personaUno.nombre = "Juan";
        System.out.println("personaUno nombre: " + personaUno.nombre);
        cambiaValor(personaUno);
        System.out.println("personaUno = " + personaUno.nombre);
        
    }    
        public static void cambiaValor(Persona persona){
            /*
            Aqui esta apuntando al mismo objeto
            el paso por referencia es que el objeto que apunta  a la misma
            direccion de memoria
            Tambien es llamado paso por valor pero por referencia
            */
            persona.nombre = "Karla";            
        }
    }
