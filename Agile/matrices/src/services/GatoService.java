package services;

import enums.JugadoresEnum;

import java.util.Scanner;
import java.util.stream.Stream;

public class GatoService {
    public static void play(){
        Scanner sc = new Scanner(System.in);
        boolean juegoTerminado = false;
        ManejoMatriz tablero = new ManejoMatriz(3,3);
        int ronda = 1;
        int contador = 0;
        JugadoresEnum jugadorActual = obtenerJugadorActual(ronda);
        while (!juegoTerminado){
            try {
                if (contador == 9){
                    System.out.println("Juego terminado");
                    juegoTerminado = true;
                    System.out.println(tablero.obtenerGanador());
                    break;
                }
                if(tablero.hayGanador()){
                    System.out.println("Juego terminado");
                    juegoTerminado = true;
                    System.out.println(tablero.obtenerGanador());
                    break;
                }
                System.out.println("Ingresa las coordenadas en formato x,y: ");
                String dato = sc.nextLine();
                Integer[] coordenadas = obtenerCoordenadas(dato);
                if (!tablero.validarEspacio(coordenadas[0],coordenadas[1])){
                    tablero.insertarDato(coordenadas[0],coordenadas[1],jugadorActual);
                    jugadorActual = obtenerJugadorActual(++ronda);
                    tablero.imprimirMatriz();
                }else{
                    System.out.println("Casilla llena, ingresa otra casilla");
                }
                contador++;

            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Ingresa en formato de números");
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Ingresa los datos en formato x,y");
            }
        }
    }

    private static Integer[] obtenerCoordenadas(String dato) {
        return Stream.of(dato.split(",")).map(d -> Integer.parseInt(d)).toArray(Integer[]::new);
    }

    private static JugadoresEnum obtenerJugadorActual(int ronda) {
        return ronda % 2 == 0 ? JugadoresEnum.JUGADOR_B : JugadoresEnum.JUGADOR_A;
    }
}
