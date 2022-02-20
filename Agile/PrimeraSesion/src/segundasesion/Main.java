package segundasesion;

public class Main {
    public static void main(String[] args) {
//        CuentaCheques cuentaBancaria = new CuentaCheques(1000.0,5.0);
//        System.out.println("Balance inicial = " + cuentaBancaria.getBalance());
//        System.out.println("Retiro: 600");
//        cuentaBancaria.reducirFondos(600.0);
//        System.out.println("Nuevo balance: " + cuentaBancaria.getBalance());
//        System.out.println("Retiro: 600");
//        cuentaBancaria.reducirFondos(600.0);
//        System.out.println("Nuevo balance: " + cuentaBancaria.getBalance());
//        cuentaBancaria.imprimirEstadoCuenta();

        TarjetaCredito credito = new TarjetaCredito(1000.0);
        System.out.println("Saldo inicial = " + credito.getSaldo());
        System.out.println("Linea de credito " + credito.getLineaCredito());
        System.out.println("Cargando 600.0");
        credito.cargarTarjeta(600.0);
        System.out.println("Nuevo saldo = " + credito.getSaldo());
        credito.cargarTarjeta(600.0);
        System.out.println("Nuevo saldo = " + credito.getSaldo());
        credito.cargarTarjeta(600.0);
        //System.out.println("Nuevo saldo = " + credito.getSaldo());
        //System.out.println("Pagar 600....");
        //credito.pagarTarjeta(600.0);
        //System.out.println("Nuevo saldo = " + credito.getSaldo());
        //credito.imprimirEstadoCuenta();

        //Cuenta de cheque: Comisión por retiro
        //Cuenta por inersión: +intereses
        //CuentaCheques cuentaCheques = new CuentaCheques(1000.0, 5.0);
        //cuentaCheques.getBalance();
        //cuentaCheques.imprimirEstadoCuenta();

        //1. Si todos los productos financieros tienen salado en 0, impirmir Cancelación autorizada.
        //2.- Por cada producto financiero que no tenga saldo en 0 imprimir su estado de cuenta
        //2.1 Al final de todos los estado de cuenta imprimir cancelacion denegada.
        CuentaBancaria cuentaInversion = new CuentaInversion(1000.0,0.05);
        CuentaBancaria cuentaCheques = new CuentaCheques(1000.0,5.0);

        //Cliente cliente = new Cliente();
//        cliente.agregarProducto(credito);
//        cliente.agregarProducto(cuentaCheques);
//        cliente.agregarProducto(cuentaInversion);
//        if(cliente.cancelarServicio()){
//            System.out.println("Cancelación autorizada");
//        }else{
//            for(ProductoFinanciero producto : cliente.getProductos()){
//                if (producto.getSaldo()!=0.0){
//                    producto.imprimirEstadoCuenta();
//                }
//            }
//            System.out.println("Cancelación no autorizada");
//        }
        Cliente cliente = new Cliente("Raúl","1234",10000);
        Configuracion configuracion = new Configuracion();
        configuracion.setMaxLineaCreditoPorIngresoMensual(4.0);
        AdministradorProducto adminitradorProducto = new AdministradorProducto(configuracion);
        adminitradorProducto.agregarProducto(cliente, credito);
        System.out.println(String.format("El cliente %s ha solicitado cancelar sus cuentas", cliente.getNumCliente()));
        if(adminitradorProducto.puedeCancelar(cliente)){
            System.out.println("Cancelación autorizada");
        }else{
            System.out.println("Cancelación denegada");
        }
    }
}
