package solid.inyecciondependencias;

public class Entrega implements IConfirmarEntrega{
    @Override
    public void confirmarEntrega() {
        System.out.println("Confirmando la entrega");
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Se ha entregado el producto");
    }
}
