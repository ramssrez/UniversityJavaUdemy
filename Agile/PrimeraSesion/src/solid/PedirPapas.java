package solid;

public class PedirPapas implements IPedirPapasFritas{
    @Override
    public void confirmarOrden() {
        System.out.println("Confirmando orden.......");
        System.out.println("Pagando la orden........");
    }

    @Override
    public void pedirPapasFritas() {
        System.out.println("Pidiendo papas fritas");
    }
}
