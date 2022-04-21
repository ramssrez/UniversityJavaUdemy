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
        Medidas medidas = context.getBean("medidas",Medidas.class);
        medidas.realizarCalculos("reactangulo","cm");
    }
}
