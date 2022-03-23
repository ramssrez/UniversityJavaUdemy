import enums.JugadoresEnum;
import services.ManejoMatriz;

public class PruabaMatriz {
    public static void main(String[] args) {
        ManejoMatriz matriz = new ManejoMatriz(3,3);
        matriz.imprimirMatriz();
        matriz.insertarDato(0,1, JugadoresEnum.JUGADOR_A);
        matriz.imprimirMatriz();
    }
}
