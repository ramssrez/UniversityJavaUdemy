import sun.applet.Main;

public class Variables {
    public static final String TEXTO_ESTATICO = "El texto no cambia";
    private String textoNoEstatico = "El texto cambia";
    private int numeroNoEstatico;
    private char charNoEstatico;

    public static void main(String[] args) {
        System.out.println(Variables.TEXTO_ESTATICO);
        Variables var = new Variables();
        System.out.println(var.textoNoEstatico);
        System.out.println(var.numeroNoEstatico);
        System.out.println(var.charNoEstatico);
        var.textoNoEstatico = "Este es nuevo texto";
        System.out.println("var = " + var.textoNoEstatico);
    }
}
