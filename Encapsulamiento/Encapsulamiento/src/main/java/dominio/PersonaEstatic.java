package dominio;

public class PersonaEstatic {

    private int idPersona;
    private static int contadorPersonas;
    private String name;

    public PersonaEstatic(String name) {
        this.name = name;
        //incrementar el contador
        PersonaEstatic.contadorPersonas++;
        //Asignar un nuevo valor a la variable idPersona
        this.idPersona = PersonaEstatic.contadorPersonas;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }

    public static void setContadorPersonas(int contadorPersonas) {
        PersonaEstatic.contadorPersonas = contadorPersonas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override  //Anotación que es subescribir
    public String toString() {
        return "PersonaEstatic{" + "idPersona=" + idPersona + ", name=" + name + '}';
    }

}
