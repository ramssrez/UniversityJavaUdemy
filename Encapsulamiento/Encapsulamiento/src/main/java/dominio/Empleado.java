
package dominio;


public class Empleado extends Persona{
    private int idEmpleaod;
    private double sueldo;
    
    public Empleado(){
        
    }
    public double getSueldo(){
        return this.sueldo;
    }
    public void setSueldo(int sueldo){
        this.sueldo = sueldo;
    }
    public int getIdEmpleado(){
        return this.idEmpleaod;
    }
}
