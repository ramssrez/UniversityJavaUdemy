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

        /*
            Organizar la información de mejor a peor aerodinámica
            Valido el último de los rines mayor que 33.0% porcentaje absoluto seleccionas ese rin
            Mayor o igual a 67% del porcentaje absoluto, checar la mejor aerodinámica selecciono ese rin.
            Si no se cumple, se tendrá que hacer uso se la suma de los rines y seleccionar el peor.

         */
        RinClass rinClass = new RinClass("Katana", 25f, 1f);
        RinClass rinClass1 = new RinClass("Lagomera", 5f, 3f);
        RinClass rinClass2 = new RinClass("Pantera", 20f, 4f);
        RinClass rinClass3 = new RinClass("Sakura", 15f, 2);
        RinClass rinClass4 = new RinClass("Aries", 10f, 5f);
        List<RinClass> rines = new ArrayList<>();

        rines.add(rinClass);
        rines.add(rinClass1);
        rines.add(rinClass2);
        rines.add(rinClass3);
        rines.add(rinClass4);
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
                //return p1.getAerodinamica().compareTo(p2.getAerodinamica());
                return p2.getAerodinamica().compareTo(p1.getAerodinamica());
            }
        });

        
        System.out.println("Ordenamiento de mayor a menor");
        //Comparacion
        System.out.println("");
        for (RinClass rine : rines) {
            System.out.println("rine = " + rine);
        }
        
         //Ordenamiento de la lista de menor a mayor
        Collections.sort(rines, new Comparator<RinClass>() {
            @Override
            public int compare(RinClass p1, RinClass p2) {
                return p1.getAerodinamica().compareTo(p2.getAerodinamica());
                //return p2.getAerodinamica().compareTo(p1.getAerodinamica());
            }
        });

        System.out.println("Orrdenamietno de menor a mayor");
          System.out.println("");
        for (RinClass rine : rines) {
            System.out.println("rine = " + rine);
        }
        System.out.println("el ultimo valor " + rines.size());
        RinClass ultimoRin = rines.get(rines.size() - 1);
        System.out.println("ultimoRin = " + ultimoRin);
        System.out.println("");

        RinClass primerRin = rines.get(0);
        System.out.println("primerRin = " + primerRin);
        System.out.println("");
        List<RinClass> nuevalista = new ArrayList<>();
        if (ultimoRin.getPorcentajeAbsoluto() > 33) {
            System.out.println("El rin seleccionado es: " + ultimoRin.toString());
        } else if (primerRin.getPorcentajeAbsoluto() >= 67) {
            System.out.println("El rin seleccionado es: " + primerRin.toString());
        } else {
            var sumaAbsolutos = 0.0f;

            for (int i = 0; i < rines.size(); i++) {
                sumaAbsolutos = sumaAbsolutos + rines.get(i).getPorcentajeAbsoluto();
                nuevalista.add(rines.get(i));
                if (sumaAbsolutos >= 67) {
                    //(System.out.println("Los rines seleccionados son: " + rines.get(i - 1).toString());
                    //System.out.println("Los rines seleccionados son: " + rines.get(i).toString());
                    System.out.println("La suma de información es: " + sumaAbsolutos);
                    break;
                }
            }
            System.out.println("Los rines son");
            nuevalista.forEach(rin -> {
                System.out.println("rin " + rin.toString());
            });

        }
    }

}
