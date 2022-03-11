import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        Collection<String> nombres = new ArrayList<>();
        nombres.add("Adrian");
        nombres.add("Juan");
        nombres.add("Alejandro");
        for (String nombre : nombres){
            System.out.println(nombre);
        }
        Collections.sort(nombres);
        */
        /*
        String [] nombres= {"Adrian","Juan","Alejandro","Pepe"};
        List<Integer> edades = new ArrayList<>();
        int edadCorrectas =0;

        for (String nombre : nombres){
            try {
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de: " + nombre));
                edades.add(edad);
                edadCorrectas++;

            }catch (NumberFormatException e){
                System.out.println("La edad de " + nombre + " es invalida");
            }
         }
        Integer min = Collections.min(edades);
        Integer max = Collections.max(edades);
        Integer promedio = 0;
        for (Integer edad : edades){
            promedio += edad;
        }

        promedio /=edades.size();
        System.out.println("El promedio es: " + promedio);

        System.out.println("La minima edad del grupo es: " + min);
        System.out.println("La maxima edad del grupo es: " + max);
        System.out.println("Edades correctas: " +edadCorrectas);


         */

        String [] nombres  = new String[100];
        List<User> userList = new ArrayList<>();
        List<Integer> edades = new ArrayList<>();
        int edadCorrectas =0;

        try {
            String nombresTotal = JOptionPane.showInputDialog("Ingrese el nombre de las persona");
            nombres = nombresTotal.split(",");
        }catch (Exception e){
            System.out.println("e = " + e);
        }

        for (String nombre : nombres){
            try {
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad de " + nombre));
                User user = new User(nombre,edad);
                userList.add(user);
                edades.add(edad);
                edadCorrectas++;
            }catch (NumberFormatException e){
                System.out.println("La edad de " + nombre + " es invalida");
            }
        }
        Integer min = Collections.min(edades);
        Integer max = Collections.max(edades);
        Integer promedio = 0;
        for (Integer edad : edades){
            promedio += edad;
        }
        promedio /=edades.size();
        System.out.println("El promedio es: " + promedio);

        System.out.println("La minima edad del grupo es: " + min);
        System.out.println("La maxima edad del grupo es: " + max);
        System.out.println("Edades correctas: " +edadCorrectas);

        System.out.println("Los usuarios son: ");
        for (User user : userList){
            System.out.println(user.toString());
        }


    }
}
