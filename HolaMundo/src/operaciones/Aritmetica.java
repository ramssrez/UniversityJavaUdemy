package operaciones;

public class Aritmetica {
    //Atributos de la clase
    int a;
    int b;
    //Constructor vacio
    public Aritmetica() {
        System.out.println("Ejecutando Constructor vacio");
        /*
        Los valores por default son cero para los enteros
        por lo que no es necesario declararlos
        */
    }
    
    //Sobrecarga de constructores, agregar dos o mas constructores
    public Aritmetica(int a, int b/* argumetos de la clase*/){
        //Var no es permitido en los atributos de los metodos
        System.out.println("Ejecutando contructor con argumentos");
        this.a=a;
        this.b=b;
    }
    
    //Declaracion del metodo
    public void sumar (){
        int suma = a+b;
        System.out.println("suma:  " + suma );
    }
    public int sumarRetorno(){
        //int sumaRetun = a + b;
        return a+b;
    }
    
    //Argumentos cuando llega la información
    public int sumarArgumentos(int a, int b){
        this.a=a;  //Atributos de la clase
        this.b=b;
        //this apunta al abjeto, solo se usa dentro de la clase
        
        //Uso de un metodo en donde se reutiliz codigo
        return this.sumarRetorno();
    }
}
