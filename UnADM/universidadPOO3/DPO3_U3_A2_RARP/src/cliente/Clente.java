package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
        System.out.println("ESTO ES DESDE EL CLIENTE");
        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket socket = new Socket(HOST, PUERTO);
            //Implementación de loos puentes para conectar con el servidor
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Hola mundo desde el cliente");

            //Uso del método para leer lo que manda el servidor
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            socket.close();

        } catch (IOException ex) {
            System.out.println("Error Selección: " + ex.getMessage());
            ex.printStackTrace(System.out);;
        }
    }

}
