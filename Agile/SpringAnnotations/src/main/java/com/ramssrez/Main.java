package com.ramssrez;

import com.ramssrez.beans.Medidas;
import com.ramssrez.config.SpringConfig;
import com.ramssrez.interfaces.IFigura;
import com.ramssrez.interfaces.IMedidas;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //IMedidas medidas = context.getBean("medidas",IMedidas.class);
        //medidas.realizarCalculos("reactangulo","cm");

        IFigura iFigura = context.getBean("circulo",IFigura.class);
        iFigura.imprimirNombre();
        iFigura.proceso();

    }
}
