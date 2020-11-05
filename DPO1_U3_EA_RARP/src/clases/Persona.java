package clases;

public abstract class Persona {
    //Declaración de los atributos del objeto de tipo Personas
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    //Constructor vacío para la creación del objeto de tipo Personas
    public Persona() {
    }

    //Segundo constructor donde ingresa el parametro nombre, tiene el mismo nombre que el primer costructor,
    //pero con diferentes parametros de entrada, aqui se pude observar la sobrecarga de métodos
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    //Tercer constructor que tiene de parametros el nombre, apellido paterno y apellido materno
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public abstract void generarEdad(String fechaNacimiento);
    
    //Métodos getter y setter para el atributo nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Métodos getters y setters para el atributo apellido paterno
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    //Métodos getters y setters para el atributo apellido materno
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    //Sobreescritura del método toString para imprimir los atributos del objeto persona
    @Override
    public String toString() {
        return "Persona{" + "Nombre: " + nombre + ", Apellido Paterno: " + apellidoPaterno + ", Apellido Materno: " + apellidoMaterno + '}';
    }

}
