package operaciones;

public class Aritmetica {
    int a;
    int b;
    
    
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
