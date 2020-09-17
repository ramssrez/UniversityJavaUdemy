package dominio;

public class Empleado extends Persona{ //Extends es para heredar de la clase padre
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;

    public Empleado(String nombre, double sueldo) {
        super(nombre);
        this.sueldo = sueldo;
        this.idEmpleado=++Empleado.contadorEmpleado;
    }

    public int getIdEmpleaod() {
        return this.idEmpleado;
    }
     public double getSueldo() {
        return this.sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{idEmpleado=").append(this.idEmpleado);
        sb.append(", sueldo=").append(this.sueldo);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
