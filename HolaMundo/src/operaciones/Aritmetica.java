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
        int sumaRetun = a + b;
        return sumaRetun;
    }
    
    //Argumentos cuando llega la información
    public int sumarArgumentos(int arg1, int arg2){
        a=arg1;
        b=arg2;
        //Uso de un metodo en donde se reutiliz codigo
        return sumarRetorno();
    }
}
