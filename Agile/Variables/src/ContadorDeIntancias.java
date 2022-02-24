public class ContadorDeIntancias {
    public static int NUM_INSTANCIAS = 0;
    private int instanciasID;

    public ContadorDeIntancias (){
        instanciasID = NUM_INSTANCIAS++;
    }

    public static int getNumInstancias() {
        return NUM_INSTANCIAS;
    }

    public int getInstanciasID() {
        return instanciasID;
    }

    public void setInstanciasID(int instanciasID) {
        this.instanciasID = instanciasID;
    }

    public static void main(String[] args) {
        ContadorDeIntancias intancias = new ContadorDeIntancias();
        ContadorDeIntancias intancias1 = new ContadorDeIntancias();
        ContadorDeIntancias intancias2 = new ContadorDeIntancias();

        System.out.println("intancias1 = " + intancias1.instanciasID);
        System.out.println("intancias = " + intancias.instanciasID);
        System.out.println("intancias2 = " + intancias2.instanciasID);
        System.out.println(" = " + intancias1.getInstanciasID());

        System.out.println(ContadorDeIntancias.getNumInstancias());



    }
}
