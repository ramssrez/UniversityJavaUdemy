import enums.JugadoresEnum;

import java.util.Scanner;
import java.util.stream.Stream;

public class GatoMain {

    /**
     * Validar si la coordenada ingresada, esté vacía, si ya se encuentra ocupada, pedirle al mismo jugador otra coordenada
     * Validar si el juego termina por que todas las casillas se encuentran ocupadas
     * Validar si el juego termina por que hay un ganador
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean juegoTerminado = false;
        String[][] tablero = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
        int ronda = 1;
        JugadoresEnum jugadorActual = obtenerJugadorActual(ronda);

        do {
            System.out.println("Ingresa las coordenadas en formato x,y: ");
            String dato = sc.nextLine();
            Integer[] coordenadas = obtenerCoordenadas(dato);
            insertarFicha(tablero, coordenadas[0], coordenadas[1], jugadorActual);
            jugadorActual = obtenerJugadorActual(++ronda);
            imprimirTablero(tablero);
        } while (!juegoTerminado);
    }

    public static void imprimirTablero(String[][] tablero) {
        System.out.println("------------------------------");
        for(String[] x : tablero) {
            for(String y : x) {
                System.out.print(y + "\t");
            }
            System.out.println();
        }
    }

    public static void insertarFicha(String[][] tablero, int x, int y, JugadoresEnum jugadorActual) {
        tablero[x][y] = jugadorActual.getFicha();
    }

    public static Integer[] obtenerCoordenadas(String dato) {
        return Stream.of(dato.split(",")).map(d -> Integer.parseInt(d)).toArray(Integer[]::new);
    }

    public static JugadoresEnum obtenerJugadorActual(int ronda) {
        return ronda % 2 == 0 ? JugadoresEnum.JUGADOR_B : JugadoresEnum.JUGADOR_A;
    }
}