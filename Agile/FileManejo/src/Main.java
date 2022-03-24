import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File directorio = new File("./");
        String [] archivos = directorio.list();

        //Creación de una nueva carpeta
        File nuevaCarpeta = new File("./NuevaCarpeta");
        if (!nuevaCarpeta.exists()){
            boolean carpetaCreada = nuevaCarpeta.mkdir();
            File crearArchivo = new File("Hola Mundo.txt");
            crearArchivo.createNewFile(nuevaCarpeta,"Hola Munso.txt");
            System.out.println("Carpeta creado " + carpetaCreada);
            System.out.println("Archivo creado = " + crearArchivo);
        }
        nuevaCarpeta.mkdir();
        System.out.println(nuevaCarpeta.mkdir());

        //Lectura de los archivos
        for (String archivo : archivos){
            System.out.println("archivo = " + archivo);
        }
    }
}
