
package dominio;
public class Persona {
   protected String nombre; //protected es para hacer herencia para los metodos
   protected char genero;
   protected int edad;
   protected String direccion;
   
   //De esta manera podemos instanciar una clase persona sin necesidad de los atributos
   public Persona(){
       
   }
   //Constructor con un argumento
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    //Constructor con varios argumentos
    public Persona(String nombre, char genero, int edad, String direccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }
   
   public String  getNombre(){
       return this.nombre;
   }
   public void setNombre(String nombre){
       this.nombre=nombre;
   }
   public char getGenero(){
       return this.genero;
   }
   public void setGenero(char genero){
       this.genero = genero;
   }
   public int getEdad (){
       return this.edad;
   }
   public void setEdad(int edad){
       this.edad = edad;
   }
   public String getDireccion(){
       return this.direccion;
   }
   public void setDireccion(String direccion){
       this.direccion=direccion;
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{nombre=").append(nombre);
        sb.append(", genero=").append(genero);
        sb.append(", edad=").append(edad);
        sb.append(", direccion=").append(direccion);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
   
   
}
