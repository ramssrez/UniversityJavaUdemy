public class Principal {
    public static void main(String[] args) {
        double[] precios = new double[3];
        //Asignación de valores
        precios[0] = 35.2;
        precios[1] = 47.9;
        precios[2] = 25.2;

        double sumaPrecios = precios[0]+precios[1]+precios[2];
        //Obtención de valores y la impresión en consola
        System.out.println("precios[0] = " + precios[0]);
        System.out.println("precios[1] = " + precios[1]);
        System.out.println("precios[2] = " + precios[2]);
        System.out.println("sumaPrecios = " + sumaPrecios);

        //Paso por valor
        boolean valor = true;
        System.out.println("valor = " + valor);
        testPasoValor(valor);
        System.out.println("valor = " + valor);

        //Paso por referencia
        testPasoReferencia(precios);
        System.out.println("precios[0] = " + precios[0]);
        System.out.println("precios[1] = " + precios[1]);
        System.out.println("precios[2] = " + precios[2]);

    }
    public static void testPasoValor(boolean esValido){
        esValido = !esValido;
        System.out.println("esValido = " + esValido);
    }

    public static void testPasoReferencia(double[] doubles){
        System.out.println("**********Desde el método***************");
        doubles[0] = 0;
        System.out.println("doubles = " + doubles[0]);
        System.out.println("doubles = " + doubles[1]);
        System.out.println("doubles = " + doubles[2]);
        System.out.println("*************************");
    }
}
