package main;

public class Principal {

    public static void main(String[] args) {
        System.out.println("args = " + args);
        int arreglo[][][][] = new int[1][3][4][5];
        //Uso de arreglos multi
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                for (int k = 0; k < arreglo[i][j].length; k++) {
                    for (int l = 0; l < arreglo[i][j][k].length; l++) {
                        arreglo[i][j][k][l] = 1;
                    }
                }
            }
        }

        //Impresion del arreglo
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < arreglo[i].length; j++) {
                System.out.println("j = " + j);
                for (int k = 0; k < arreglo[i][j].length; k++) {
                    System.out.println("k = " + k);
                    for (int l = 0; l < arreglo[i][j][k].length; l++) {
                        System.out.println("l = " + l);
                        System.out.println("i: " +i + "j: " + j + "k: " + k + "l: " + l + " = "+ arreglo[i][j][k][l]);
                    }
                }
            }
        }
    }
}
