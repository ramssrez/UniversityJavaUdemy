public class ArgsDos {
    public static void main(String[] args) {
        long val1 = Integer.parseInt(args[0]);
        System.out.println("val1 = " + val1);
        long val2 = Integer.parseInt(args[1]);
        System.out.println("val2 = " + val2);
        long val3 = Integer.parseInt(args[2]);
        System.out.println("val3 = " + val3);
        long val4 = Integer.parseInt(args[3]);
        System.out.println("val4 = " + val4);
        long val5 = Integer.parseInt(args[4]);
        System.out.println("val5 = " + val5);
        long suma = val1+val2+val3+val4+val5;

        //1024 1048576 1073741824 33554432 2147483647
        //Leer 5 números de los argumentos y sumar los 5 núemero e imprimir el resultado
        System.out.println("La suma es:  " + suma);

    }
}
