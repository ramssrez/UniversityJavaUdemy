package inyecciondependencias;

public class Pedido implements IConfirmarPedido{
    @Override
    public void confirmarPedido() {
        System.out.println("Confirmando el pedido");
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Se ha confirmado el pedido del producto");
    }
}
