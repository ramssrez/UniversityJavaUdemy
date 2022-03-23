import enums.JugadoresEnum;
import services.ManejoMatriz;

public class PruabaMatriz {
    public static void main(String[] args) {
        ManejoMatriz matriz = new ManejoMatriz(3,3);
        matriz.imprimirMatriz();
        matriz.insertarDato(0,1, JugadoresEnum.JUGADOR_A);
        matriz.insertarDato(0,0, JugadoresEnum.JUGADOR_B);

        matriz.imprimirMatriz();
        System.out.println(matriz.validarEspacio(0,1));
        System.out.println(matriz.validarEspacio(0,2));

    }
}
