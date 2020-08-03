package dominio;
public class Empleado extends Persona{
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;

    public Empleado(String nombre, double sueldo) {
        super(nombre);
        this.sueldo = sueldo;
        this.idEmpleado=++Empleado.contadorEmpleado;
    }
    public double getSueldo(){
        return this.sueldo;
    }
    public void setSueldo(int sueldo){
        this.sueldo = sueldo;
    }
    public int getIdEmpleado(){
        return this.idEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleaod=" + idEmpleado + ", sueldo=" + sueldo + '}';
    }
    
}
