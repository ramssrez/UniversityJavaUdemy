import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MetodosMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Class claseEmpleado = Class.forName("com.adrian.reflection.classes.abstracts.Empleado");
        Method [] metodos = claseEmpleado.getDeclaredMethods();
        for (Method method : metodos){
            System.out.println("Nombre: " + method.getName());
            System.out.println("Retorno: " + method.getReturnType());
            System.out.println("Parametros" + Arrays.toString(method.getParameterTypes()));
            System.out.println("***********************");
        }
    }
}
