package cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramssrez
 */
public class Clente {

    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;

        try {
            Socket sc = new Socket(HOST, PUERTO);
        } catch (IOException ex) {
            System.out.println("Error Selección: " + ex.getMessage());
            ex.printStackTrace(System.out);;
        }
    }

}
