package ejerciciointerfaces;

public class Amex implements IPagarTarjetaCredito{
    @Override
    public void calcularPago() {
        System.out.println("Calculando el pago");
    }

    @Override
    public void pagarTarjetaCredito() {
        System.out.println("Realizando el pago con la tarjeta de credito");
    }
}
