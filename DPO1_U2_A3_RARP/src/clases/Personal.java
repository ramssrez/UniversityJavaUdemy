package clases;

public class Personal {
    private char sexo;
    private int edad;
    private boolean isComorbilidad;
    
    public Personal(char sexo, int edad, boolean isComorbilidad){
        this.edad=edad;
        this.sexo = sexo;
        this.isComorbilidad = isComorbilidad;
    }
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    public char getSexo(){
        return this.sexo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Personal{sexo=").append(sexo);
        sb.append(", edad=").append(edad);
        sb.append(", isComorbilidad=").append(isComorbilidad);
        sb.append('}');
        return sb.toString();
    }
    
}
