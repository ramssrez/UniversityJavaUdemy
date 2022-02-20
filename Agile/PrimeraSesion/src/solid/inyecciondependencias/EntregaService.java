package solid.inyecciondependencias;

public class EntregaService {
    public static IConfirmarEntrega entrega(){
        return new Entrega();
    }
}
