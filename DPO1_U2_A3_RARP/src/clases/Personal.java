package clases;

public class Personal {

    private char sexo;
    private int edad;
    private boolean tieneComorbilidad;
    private String tieneEnfermedad;

    public Personal(char sexo, int edad, String tieneEnfermedad) {
        this.edad = edad;
        this.sexo = sexo;
        this.tieneEnfermedad = tieneEnfermedad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getSexo() {
        return this.sexo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isTieneComorbilidad() {
        if (this.tieneEnfermedad.equals("SI") || this.tieneEnfermedad.equals("Si") || this.tieneEnfermedad.equals("si")) {
            this.tieneComorbilidad = true;
        } else {
            this.tieneComorbilidad = false;
        }
        return this.tieneComorbilidad;
    }

    public String getTieneEnfermedad() {
        return tieneEnfermedad;
    }

    public void setTieneEnfermedad(String tieneEnfermedad) {
        this.tieneEnfermedad = tieneEnfermedad;
    }

    @Override
    public String toString() {
        return "Personal{" + "sexo=" + sexo + ", edad=" + edad + ", tieneEnfermedad=" + tieneEnfermedad + '}';
    }
}
