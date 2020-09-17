
package test;

import dominio.Cliente;
import dominio.Empleado;
import java.util.Date;

public class TestHerecia {
    public static void main(String[] args) {
        Empleado empeado1 = new Empleado("Juan",10000.0);
        System.out.println("empeado1 = " + empeado1);
        
        Cliente cliente1 = new Cliente(new Date(), true, "Karla",'F', 28, "Sturno 15");
        System.out.println("cliente1 = " + cliente1);
    }
}
 