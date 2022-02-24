import java.math.BigDecimal;

public class PuntoFlotante {
    public static void main(String[] args) {
        double val1 = 0.05 + 0.01;
        double val2 = 1-0.42;
        double val3 = 123.3/100;
        BigDecimal val4 = new BigDecimal("0.05");
        System.out.println(val4);
        System.out.println("val1 = " + val1);
        System.out.println("val2 = " + val2);
        System.out.println("val3 = " + val3);
        System.out.println(val3 *100);

        //Strings para la versión uno
        System.out.println("Los strings son iguales? " + args[0]==args[1]);
        System.out.println("Los strings son iguales equal? " + args[0].equals(args[1]));

    }
}
