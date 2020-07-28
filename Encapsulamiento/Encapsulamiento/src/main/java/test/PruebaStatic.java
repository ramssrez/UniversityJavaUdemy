package test;

import dominio.PersonaEstatic;

public class PruebaStatic {
    private int contador;
    //Con el static, ahce que no se crean objetos de esta clase, ademas de ingresar el metodo main
    public static void main(String[] args) {
        PersonaEstatic persona = new PersonaEstatic("Jose Jose");
        //System.out.println("persona = " + persona);
        
        PersonaEstatic personaDos = new PersonaEstatic("Karla Paula");
        //System.out.println("personaDos = " + personaDos);
        imprimir(persona);
        imprimir(personaDos);
        
    }
    
    public static void imprimir (PersonaEstatic personaStatic){
        System.out.println("personaStatic = " + personaStatic);
    }
    
    //Puede ingresar a los atributos de la clase estarica
    public int getContador(){
        imprimir(new PersonaEstatic("Julio"));
        return this.contador;
    }
    
}
