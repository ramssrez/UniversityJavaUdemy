package solid;

public class PedirCombo implements IPedirCombo{
    @Override
    public void confirmarOrden() {
        System.out.println("Confirmando orden.......");
        System.out.println("Pagando la orden........");
    }

    @Override
    public void pedirCombo() {
        System.out.println("Pidiendo combo");
    }
}
