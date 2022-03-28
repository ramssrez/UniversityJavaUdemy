import services.GatoService;

public class GatoMain {

    /**
     * Validar si la coordenada ingresada, esté vacía, si ya se encuentra ocupada, pedirle al mismo jugador otra coordenada
     * Validar si el juego termina por que todas las casillas se encuentran ocupadas
     * Validar si el juego termina por que hay un ganador
     */
    public static void main(String[] args) {
        GatoService.play();
    }
}