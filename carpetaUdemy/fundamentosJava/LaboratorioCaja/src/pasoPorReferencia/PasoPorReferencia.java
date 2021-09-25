
package pasoPorReferencia;

import clases.Persona;

public class PasoPorReferencia {
    public static void main(String[] args) {
        Persona personaUno = new Persona();
        Persona personaDos = null;
        personaUno.nombre = "Juan";
        System.out.println("personaUno nombre: " + personaUno.nombre);
        personaUno = cambiaValor(personaUno);
        System.out.println("personaUno cambio = " + personaUno.nombre);
        personaDos = cambiaValor(personaDos);
        System.out.println("personaDos = " + personaDos.nombre);
        
    }    
        public static Persona cambiaValor(Persona persona){
            /*
            Aqui esta apuntando al mismo objeto
            el paso por referencia es que el objeto que apunta  a la misma
            direccion de memoria
            Tambien es llamado paso por valor pero por referencia
            */
            if (persona == null){
                System.out.println("Valor de la persona invalido: null");
                return null;
            }
            persona.nombre = "Karla";
            persona.apellido = "Paredes";
            //return es para regresar valores o objetos
            
            /*
            En el caso de ser un void implicitamente 
            return ;
            */
            return persona;
            
        }
    }
