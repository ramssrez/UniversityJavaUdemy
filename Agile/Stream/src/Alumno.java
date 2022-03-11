public class Alumno {
    private String nombre;
    private int calificacion;
    private boolean aprobado;
    public Alumno(){

    }
    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    @Override
    public String toString() {
        return  "*****************" + "\n" + "Nombre: " + nombre + "\n" +
                "Calificacion: " + calificacion + "\n" +
                "Aprobado?: " + aprobado;

    }
}
