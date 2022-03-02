public class Etiquetas {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 49, 50};
        int[] otrosNumeros = {9, 78, 7, 6, 5, 4, 3, 2, 21, 1};
        int cantidadPares = 0;
        for (int numero : numeros) {
            if (numero % 2 != 0) {
                continue;
            }
            cantidadPares++;
        }
        System.out.println("cantidadParaes = " + cantidadPares);


        //Ejercicio
        String frase = "Un gran poder conlleva a una gran responsabilidad";
        String palabra = "gran";
        int encontrado = 0;
        forExterior:
        for (int i = 0; i < frase.length(); i++) {
            int k = i;
            //System.out.println("frase = " + frase.charAt(i));
            for (int j = 0; j < palabra.length(); j++) {
                if (frase.charAt(k) != palabra.charAt(j)) {
                    continue forExterior;
                } else {
                    encontrado = encontrado + 1;
                }
            }
        }
        System.out.println("Se ha encontrado '" + palabra + "' " + encontrado + " veces");
    }
}
