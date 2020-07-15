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
    
    public void restar(){
        int resta = a-b;
        System.out.println("resta = " + resta);
    }
}
