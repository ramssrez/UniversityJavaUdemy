package clases;

public class Personal {
    private char sexo;
    private int edad;
    private boolean tieneComorbilidad;
    private String tieneEnfermedad;
    public Personal(char sexo, int edad, boolean tieneComorbilidad){
        this.edad=edad;
        this.sexo = sexo;
        this.tieneComorbilidad = tieneComorbilidad;
    }
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    public char getSexo(){
        return this.sexo;
    }
    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isTieneComorbilidad() {
        return this.tieneComorbilidad;
    }

    public void setTieneComorbilidad(boolean tieneComorbilidad) {
        this.tieneComorbilidad = tieneComorbilidad;
    }

    public String getTieneEnfermedad() {
        return tieneEnfermedad;
    }

    public void setTieneEnfermedad(String tieneEnfermedad) {
        this.tieneEnfermedad = tieneEnfermedad;
    }
    
    @Override
    public String toString() {
        if(this.tieneComorbilidad){
            tieneEnfermedad = "SI";
        }else{
            tieneEnfermedad = "NO";
        }
        return "Personal{" + "sexo=" + sexo + ", edad=" + edad + ", tieneEnfermedad=" + tieneEnfermedad + '}';
    }
    
}
