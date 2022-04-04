import com.adrian.reflection.classes.abstracts.Empleado;
import com.adrian.reflection.classes.constnts.PuestosEnum;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class CamposMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Class clasePersona = Class.forName("com.adrian.reflection.classes.abstracts.Persona");
        Empleado empleado = new Empleado();
        Field[] campos = clasePersona.getDeclaredFields();
        for (Field d : campos){
            System.out.println("Nombre: " + d.getName());
            System.out.println("Tipo datos: " + d.getType().getSimpleName());
            System.out.println("************************************");
        }

        Class classEmpleado = Class.forName("com.adrian.reflection.classes.abstracts.Empleado");
        Field[] camposEmpleado = classEmpleado.getDeclaredFields();
        for (Field d : camposEmpleado){
            d.setAccessible(true);
            System.out.println("Nombre: " + d.getName());
            System.out.println("Tipo datos: " + d.getType());
            System.out.println("Modificador Acceso: " + d.getModifiers());
            System.out.println("modificado acceso: " + Modifier.toString(d.getModifiers()));
            System.out.println("Valor " + d.get(empleado));
            System.out.println("************************************");
        }
        //campos[0].set(empleado, PuestosEnum.QA);
        //System.out.println(campos[0].get(empleado));
    }
}
