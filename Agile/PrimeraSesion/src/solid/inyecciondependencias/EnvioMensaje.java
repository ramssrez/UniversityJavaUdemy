package solid.inyecciondependencias;

public class EnvioMensaje {
    public static void main(String[] args) {
        PedidoService pedidoService = new PedidoService();
        pedidoService.pedido().confirmarPedido();
        pedidoService.pedido().enviarMensaje();

        EntregaService entregaService = new EntregaService();
        entregaService.entrega().confirmarEntrega();
        entregaService.entrega().enviarMensaje();
    }
}
