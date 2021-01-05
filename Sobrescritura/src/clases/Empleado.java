package clases;

import java.util.Objects;

public class Empleado {
    private String nombre;
    private double sueldo;
    
    public Empleado(String nombre, double sueldo){
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    
    public String obtenerDetalles (){
        return "Nombre: " + this.nombre + ", sueldo: " + this.sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

//    @Override
//    public String toString() {
//        return "Empleado{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}';
//    }

    @Override
    public int hashCode() {
        //Genera un número unico con los valores de los atributos del objeto
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.sueldo) ^ (Double.doubleToLongBits(this.sueldo) >>> 32));
        System.out.println(hash);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        //Compara contenido de los objetos
        
        if (this == obj) {
            //Si tienen la mismas referencia en memoria
            System.out.println("Tienen la mismas referencia en memoria clase Empleado");
            return true;
        }
        if (obj == null) {
            //Los objetos son distintos
            System.out.println("Los objetos no son iguales en referencua de memoria clase Empleaso");
            return false;
        }
        if (getClass() != obj.getClass()) {
            //Esto para los objetos que son ditintos getClass() retorna el tipo de la clase
            System.out.println("Los objetos son diferentes y no son del mismo tipo clase Empleado");
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (Double.doubleToLongBits(this.sueldo) != Double.doubleToLongBits(other.sueldo)) {
            //Si los atributos de ambos objetos son distintos vuelve falso
            System.out.println("Los objetos no son igulaes en atributos clase Empleado");
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        System.out.println("No entro en ninguna opcion clase Emppleado");
        return true;
    }
    
    
    
}
