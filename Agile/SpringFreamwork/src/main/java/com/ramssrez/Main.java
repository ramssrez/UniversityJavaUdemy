package com.ramssrez;

import com.ramssrez.interfaces.IFigura;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //IFigura circulo = new Circulo();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* Otra forma de realizar la creación del path con el xml
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        */
        /*
        Los beans tienen un atributo llamada scope, el primero es con singleton
        que hace que se creee una sola instancia de un objeto, por lo que si
        comparamos ambos objetos va apuntar a la misma ruta de memoria
        El segundo es prototype que crea dos objetos diferentes
         */



        IFigura f1 = context.getBean("figura",IFigura.class);
        IFigura f2 = context.getBean("figura",IFigura.class);
        boolean soniguales = f1 == f2;


        System.out.println("f1 y f2 son iguales: " +soniguales);
        System.out.println("f1 = " + f1);;
        System.out.println("f2 = " + f2);

        f1.imprimirNombre();


        context.close();
    }
}
