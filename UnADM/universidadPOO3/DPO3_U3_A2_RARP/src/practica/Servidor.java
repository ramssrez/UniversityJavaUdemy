package practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import objetos.PacienteAlta;

/**
 *
 * @author ramssrez
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("ESTO ES DESDE EL SERVIDOR");
        // TODO code application logic here
        //Declaración de variables para su utilización
        ServerSocket serverSocket = null;
        Socket socket = null;
        final int PUERTO = 5000;
        int contador = 1;

        //Uso del try/catch para el serverSocket
        try {
            //Inicialización del server con el puerto en donde va a estar funcionando, para este caso el puedto 5000
            serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            PacienteAlta pacienteAlta;

            while (true) {
                //Método en donde el servidor esta a la espera o escucha de las peticiones del cliente
                socket = serverSocket.accept();
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                pacienteAlta = (PacienteAlta) inputStream.readObject();
                System.out.println(pacienteAlta.toString());
                socket.close();
                contador++;
                System.out.println("contador: " + contador);
            }
        } catch (IOException ex) {
            System.out.println("Error Selección: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Selección: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
        
    }

}
