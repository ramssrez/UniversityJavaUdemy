package mundopc;

import mx.com.gm.mundopc.*;

public class MundoPC {
    public static void main(String[] args) {
       Monitor monitoHP =new Monitor("Hp",13);
       Teclado tecladoHp = new Teclado("Bluoetooth","Hp");
       Raton ratonHp = new Raton("Bluetooth","HP");
       Computadora computadora = new Computadora("Computadora HP", monitoHP, tecladoHp, ratonHp);
       
       Monitor monitoGamer =new Monitor("Gamer",13);
       Teclado tecladoGamer = new Teclado("Bluoetooth","Hp");
       Raton ratonGamer = new Raton("Bluetooth","Gamer");
       Computadora computadoraGamer = new Computadora("Computadora gamer", monitoGamer, tecladoGamer, ratonGamer);
       
       Orden orden1 = new Orden();
       orden1.agregarComputadora(computadora);
       orden1.agregarComputadora(computadoraGamer);
       orden1.mostrarOrden();
    }
    
    
}
