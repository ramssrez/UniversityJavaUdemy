package services;

import enums.JugadoresEnum;

public class ManejoMatriz {
    private int filas;
    private int columnas;
    private String [] [] matriz;

    public ManejoMatriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new String[filas][columnas];
        llenarMatriz(matriz);
    }

    private void llenarMatriz(String [][] matriz){
        for (int i = 0; i<this.filas;i++){
            for (int j = 0; j<this.columnas; j++){
                matriz[i][j] = "-";
            }
        }
    }

    public void imprimirMatriz() {
        System.out.println("------------------------------");
        for(String[] x : this.matriz) {
            for(String y : x) {
                System.out.print(y + "\t");
            }
            System.out.println();
        }
    }

    public void insertarDato(int fila, int columna, JugadoresEnum jugadorActual) {
        this.matriz[fila][columna] = jugadorActual.getFicha();
    }

    public boolean validarEspacio(int fila, int columna){
        return matriz[fila][columna].equals("X") || matriz[fila][columna].equals("O");
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }
}
