public class EjercicioArreglos {
    public static void main(String[] args) {
        int[] enteros = new int[4];
        enteros[0] = 2;
        enteros[1] = 9;
        enteros[2] = 7;
        enteros[3] = 3;
        float suma = enteros[0] + enteros [2] + enteros[3] + enteros[1];
        System.out.println("suma = " + suma);
        float division = suma/enteros.length;
        System.out.println("El promedio es = " + division);
    }
}
