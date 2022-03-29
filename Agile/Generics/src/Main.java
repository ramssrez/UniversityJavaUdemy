import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List numberList = new ArrayList<>();
    public static void main(String[] args) {
        FigurasServicesImpl figurasServices = new FigurasServicesImpl();
        EmpleadoServicesImpl empleadoServices = new EmpleadoServicesImpl();

        figurasServices.realizarOperaciones();
        empleadoServices.registrarEmpleado();

        Utils.imprimirRegistros();
    }

}
