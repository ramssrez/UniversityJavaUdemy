package inyecciondependencias;

public class PedidoService{
    public static IConfirmarPedido pedido(){
        return new Pedido();
    }
}
