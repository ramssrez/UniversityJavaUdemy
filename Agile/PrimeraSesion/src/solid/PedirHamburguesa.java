package solid;

public class PedirHamburguesa implements IPedirHamburguesa{
    @Override
    public void confirmarOrden() {
        System.out.println("Confirmando orden.......");
        System.out.println("Pagando la orden........");
    }

    @Override
    public void pedirHamburguesa() {
        System.out.println("Pidiendo Hamburguesa");
    }
}
