package objetos;

/**
 *
 * @author ramssrez
 */
public class Personal {
    private int id;
    private String nombre;
    private String apellidos;
    private String area;
    private String edad;
    private String numeroEmpleado;
    private String puesto;
    private String sueldo;

    public Personal() {
    }

    public Personal(String nombre, String apellidos, String area, String edad, String numeroEmpleado, String puesto, String sueldo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.area = area;
        this.edad = edad;
        this.numeroEmpleado = numeroEmpleado;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Personall{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", area=" + area + ", edad=" + edad + ", numeroEmpleado=" + numeroEmpleado + ", puesto=" + puesto + ", sueldo=" + sueldo + '}';
    }
    
    

}
