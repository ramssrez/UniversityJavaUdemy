package accesodatos;

public class ImplementacionMySql implements IAccesodatos {

    @Override
    public void insertar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Insertar desde MySql");
    }

    @Override
    public void listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Listar desde MySql");
    }

    @Override
    public void actualizar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Actualizar desde MySql");
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("No se encuentra soportado aun."); //To change body of generated methods, choose Tools | Templates.
    }

}
