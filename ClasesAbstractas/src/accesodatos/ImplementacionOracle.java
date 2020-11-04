package accesodatos;

public class ImplementacionOracle implements IAccesodatos {

    @Override
    public void insertar() {
        System.out.println("Insertar desde Oracle");
        //throw new UnsupportedOperationException("NO esta soportado aún"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        System.out.println("Listar desde Oracle");
    }

    @Override
    public void actualizar() {
        System.out.println("Actualizar desde Oracle");
    }

    @Override
    public void eliminar() {
        System.out.println("Eliminar desde Oracle");
    }

}
