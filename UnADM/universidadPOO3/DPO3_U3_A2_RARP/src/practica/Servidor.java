package practica;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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
        int contador = 0;
        String dr1 = "Dr. Juan Sanchez Sanchez";
        String dr2 = "Dra. Irma Fernandez Fernandez";
        String dr3 = "Dr. Carlos Leon Leon";
        String dr4 = "Dra. Rosa Mercado Mercado";
        String dr5 = "Dr. Rodrigo Leyva Leyva";
        String dr6 = "Dra. Sofia Lazcano Lazcano";
        String dr7 = "Dr. Gerardo Martinez Martinez";
        String dr8 = "Dra. Alma Diaz Diaz";
        String dr9 = "Dr. Jose Rodriguez Rodrioguez";
        String dr10 = "Dra. Selena Sanchez Sanchez";

        String[] doctores = {dr1, dr2, dr3, dr4, dr5, dr6, dr7, dr8, dr9, dr10};

        //Uso del try/catch para el serverSocket
        try {
            //Inicialización del server con el puerto en donde va a estar funcionando, para este caso el puedto 5000
            serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            PacienteAlta pacienteAlta;

            while (true) {
                //Método en donde el servidor esta a la espera o escucha de las peticiones del cliente
                socket = serverSocket.accept();
                
                if (contador == 10) {
                    contador = 0;
                }
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                pacienteAlta = (PacienteAlta) inputStream.readObject();
                pacienteAlta.setDoctorAsignado(doctores[contador]);
                String consultorio = String.valueOf(contador + 2);
                pacienteAlta.setNumeroConsultorio(consultorio);
                String turno = String.valueOf(contador + 1);
                pacienteAlta.setNumeroTurno(turno);
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
