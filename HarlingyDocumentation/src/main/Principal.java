package main;

import clases.RinClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        //Generación de objetos de tipo Rin
        //Katana, 20%, 0.008
        //Lagomera, 30%, 0.005
        //Pantera, 10%, 0.013       

        RinClass rinClass = new RinClass("Katana", 20f, 0.008f);
        RinClass rinClass1 = new RinClass("Lagomera", 30f, 0.005f);
        RinClass rinClass2 = new RinClass("Pantera", 10f, 0.013f);
        List<RinClass> rines = new ArrayList<>();

        rines.add(rinClass);
        rines.add(rinClass1);
        rines.add(rinClass2);
        float sumaRelative = 0.0f;
        rines.forEach(rin -> {
            System.out.println("rin" + rin);
        });
        System.out.println("");
        for (RinClass rin : rines) {
            sumaRelative = sumaRelative + rin.getPorcentajeRelativo();
            System.out.println("suma " + sumaRelative);
        }
        System.out.println("suma " + sumaRelative);
        //CAlculo del porcentaje absoluto
        System.out.println("");
        for (RinClass rin : rines) {
            var absoluto = (rin.getPorcentajeRelativo() * 100f) / sumaRelative;
            rin.setPorcentajeAbsoluto(absoluto);
        }

        //Ordenamiento de la lista de mayor a menor
        Collections.sort(rines, new Comparator<RinClass>() {
            @Override
            public int compare(RinClass p1, RinClass p2) {
                return p1.getAerodinamica().compareTo(p2.getAerodinamica());
            }
        });

        //Comparacion
        System.out.println("");
        for (RinClass rine : rines) {
            System.out.println("rine = " + rine);
        }
//        var sumaAbsolutos = 0.0f;
//        var peorAero = 0.0;
//
//        for (RinClass rin : rines) {
//
//            if (rin.getPorcentajeAbsoluto() >= 33.0f) {
//                if (peorAero < rin.getAerodinamica()) {
//                    peorAero = rin.getAerodinamica();
//                    System.out.println("Este es el rin: " + rin.getNombre());
//                }
//
//            } else if (rin.getPorcentajeAbsoluto() <= 67.0f) {
//                System.out.println("Se toma este rin: " + rin.getNombre());
//            }
//
//        }
//
//        System.out.println("Peor aero " + peorAero);

    }

}
