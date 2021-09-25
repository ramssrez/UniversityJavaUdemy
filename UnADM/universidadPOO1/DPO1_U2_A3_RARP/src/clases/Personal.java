package clases;

public class Personal {

    //Declaración de atributos del objeto Personal
    private char sexo;
    private int edad;
    private boolean tieneComorbilidad;
    private String tieneEnfermedad;

    //Constructor del objeto Personal
    public Personal(char sexo, int edad, String tieneEnfermedad) {
        this.edad = edad;
        this.sexo = sexo;
        this.tieneEnfermedad = tieneEnfermedad;
    }

    //Métodos getter y setter para el atributo sexo
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getSexo() {
        return this.sexo;
    }

    //Métodos getter y setter para el atributo edad
    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

      //Métodos getter para el atributo tieneComorbilidad
    public boolean isTieneComorbilidad() {
        //Cambio de string en boolean con el uso de esta condicional y los datos de entrada
        if (this.tieneEnfermedad.equals("SI") || this.tieneEnfermedad.equals("Si") || this.tieneEnfermedad.equals("si")) {
            this.tieneComorbilidad = true;
        } else {
            this.tieneComorbilidad = false;
        }
        return this.tieneComorbilidad;
    }

      //Métodos getter y setter para el atributo tieneEnfermedad
    public String getTieneEnfermedad() {
        return tieneEnfermedad;
    }

    public void setTieneEnfermedad(String tieneEnfermedad) {
        this.tieneEnfermedad = tieneEnfermedad;
    }

    @Override
    public String toString() {
        return "{" + "sexo=" + sexo + ", edad=" + edad + ", Comorbilidad?=" + tieneEnfermedad + '}';
    }
}
