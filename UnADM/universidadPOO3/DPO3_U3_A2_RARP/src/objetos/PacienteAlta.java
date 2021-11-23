
package objetos;

import java.io.Serializable;

/**
 *
 * @author ramssrez
 */
public class PacienteAlta implements Serializable{
    private String nombre;
    private String numeroSocial;
    private String sintomas;
    private String doctorAsignado;
    private String numeroConsultorio;
    private String numeroTurno;

    public PacienteAlta() {
    }

    public PacienteAlta(String nombre, String numeroSocial, String sintomas) {
        this.nombre = nombre;
        this.numeroSocial = numeroSocial;
        this.sintomas = sintomas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroSocial() {
        return numeroSocial;
    }

    public void setNumeroSocial(String numeroSocial) {
        this.numeroSocial = numeroSocial;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDoctorAsignado() {
        return doctorAsignado;
    }

    public void setDoctorAsignado(String doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    public String getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(String numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public String getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(String numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    @Override
    public String toString() {
        return "PacienteAlta{" + "nombre=" + nombre + ", numeroSocial=" + numeroSocial + ", sintomas=" + sintomas + ", doctorAsignado=" + doctorAsignado + ", numeroConsultorio=" + numeroConsultorio + ", numeroTurno=" + numeroTurno + '}';
    }
    
    
}
