package practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramssrez
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Declaración de variables para su utilización
        ServerSocket serverSocket  = null;
        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5000;
        //Uso del try/catch para el serverSocket
        try {
            //Inicialización del server con el puerto en donde va a estar funcionando, para este caso el puedto 5000
            serverSocket  = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            
            while (true) {                
                //Método en donde el servidor esta a la espera o escucha de las peticiones del cliente
                socket = serverSocket.accept();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
