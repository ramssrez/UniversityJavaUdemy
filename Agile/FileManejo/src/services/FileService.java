package services;

import enums.TypesFilesEnum;
import messages.Mensaje;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileService {
    public static void fileService() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del archivo");
        String nombreArchivo = sc.nextLine();
        StringBuilder sb = new StringBuilder(Mensaje.OPCIONES_ARCHIVOS);
        sb.append(imprimirOpciones());
        System.out.println(sb.toString());

        File file = new File(nombreArchivo + ".txt");
        if (file.createNewFile()){
            System.out.println("EL archivo ha sido creado");
        }else{
            System.out.println("El archivo ya ha sido creado7");
        }


        String pathname = "NewFile.txt";
        File f= new File(pathname);
        if(f.createNewFile())
            System.out.println("File created with filename: " + f.getName());
        else
            System.out.println("File already exists");

        System.out.println("File path: " + f.getAbsolutePath());
        /*
        TypesFilesEnum[] extensiones = ExtensionEnums.values();
        String nombreArchivo = askForInput(sc, Mensajes.PEDIR_NOMBRE_ARCHIVO);
        File archivo = new File(nombreArchivo);

        if (archivo.exists()) {
            String decision = askForInput(sc, Mensajes.CONFIRMACION_DELETE);
            if (decision.equalsIgnoreCase("si")) archivo.delete();
        } else {
            for (ExtensionEnums e : extensiones) {
                sb.append(String.format(Mensajes.FORMATO_OPCIONES_EXTENSION_ARCHIVO, e.getOption(), e.getName()));
            }

            System.out.println(Mensajes.ARCHIVO_NO_ENCONTRADO);
            File nuevaCarpeta = new File(askForInput(sc, Mensajes.PEDIR_NOMBRE_CARPETA));
            if (nuevaCarpeta.getName().isBlank() || nuevaCarpeta.getName().equals(null)) {
                archivo = new File(nombreArchivo + getNombre(sc, sb.toString()).getName());
            } else {
                nuevaCarpeta.mkdir();
                archivo = new File(nuevaCarpeta, nombreArchivo + getNombre(sc, sb.toString()).getName());
            }

            if (archivo.createNewFile()) System.out.println(Mensajes.ARCHIVO_CREADO_EXITOSAMENTE);
            else System.out.println(Mensajes.ARCHIVO_CREADO_ERROR);

        }

         */
    }
    public static StringBuilder imprimirOpciones(){
        TypesFilesEnum[] filesEnum = TypesFilesEnum.values();
        StringBuilder builder = new StringBuilder();
        for (TypesFilesEnum e : filesEnum) {
            builder.append(String.format(Mensaje.TIPOS_ARCHIVOS, e.getOption(), e.getName()));
        }
        return builder;
    }
    /*
    public static String askForInput(Scanner sc, String prompt) {
        System.out.println(prompt);
        String inputValue = sc.nextLine();
        return inputValue;
    }



     */
    /*
    public static TypesFilesEnum getNombre(Scanner sc,String mensaje) {
        boolean bandera = false;
        while (!bandera){
            try {
                System.out.println(mensaje);
                String s = sc.nextLine();
                if (s == null) {
                    throw new NullPointerException();
                }
                if (s.equals("")){
                    throw new NumberFormatException();
                }
                int option = Integer.parseInt(s);
                //bandera = true;
                return Stream.of(TypesFilesEnum.values()).filter(e -> e.getOption() == option).findFirst().orElseThrow(NoSuchElementException::new);
            }catch (NullPointerException e) {
                System.out.println("No se ha agregado un valor");
            }catch (NoSuchElementException e) {
                System.out.println("No se ha seleccionado una opción");
            }catch (NumberFormatException e){
                System.out.println("No se ha agregado un valor adecuado");
            }
            return null;
        }

        return null;

    }

     */
}
