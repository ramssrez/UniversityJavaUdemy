public class ForEach {
    public static void main(String[] args) {
        String [] nombres = {"Raúl", "Adrian", "Alberto","Gerson","Arturo","Pablo","Marco"};
        for (String nombre : nombres){
            System.out.println(nombre);
        }
        //Ejercicio apra identificar si es par o impar un número
        //int [] numeros = {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90};
        int[] numeros = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,20,25,30,35,49,50};
        for (int numero : numeros){
            String mensaje = (numero%2==0)? numero + " es par": numero + " es impar";
            System.out.println(mensaje);
        }
    }
}
