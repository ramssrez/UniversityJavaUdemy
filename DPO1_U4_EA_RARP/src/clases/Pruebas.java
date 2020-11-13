package clases;

public class Pruebas {

    public static void main(String[] args) {
        //Creación de la matriz
        int suma = 0;
        int asiento[][] = new int[6][30];
        char filas[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < asiento.length; i++) {
            for (int j = 0; j < asiento[i].length; j++) {
                suma = suma + 1;
                asiento[i][j] = suma;
            }
        }

        //Impresion de la matriz
        for (int i = 0; i < asiento.length; i++) {
            //System.out.print("fila : " + filas[i] + " ");
            for (int j = 0; j < asiento[i].length; j++) {
                if ((asiento[i][j]) == 61 || (asiento[i][j] == 62) || (asiento[i][j] == 63) || (asiento[i][j] == 91) || (asiento[i][j] == 92) || (asiento[i][j] == 93)
                        || (asiento[i][j]) == 4 || (asiento[i][j] == 34) || (asiento[i][j] == 64) || (asiento[i][j] == 94) || (asiento[i][j] == 124) || (asiento[i][j] == 154)
                        ||(asiento[i][j]) == 17 || (asiento[i][j] == 167) ) {
                    System.out.print("  0  ");
                } else {
                    System.out.print(asiento[i][j] + "    ");
                }

            }
            System.out.println("");
        }

    }

}
