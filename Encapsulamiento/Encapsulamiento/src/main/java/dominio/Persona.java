
package dominio;
public class Persona {
   private String nombre;
   private char genero;
   private int edad;
   private String direccion;
   
   public Persona(){
       
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
        return "Persona{" + "nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + ", direccion=" + direccion + '}';
    }
   
   
}
