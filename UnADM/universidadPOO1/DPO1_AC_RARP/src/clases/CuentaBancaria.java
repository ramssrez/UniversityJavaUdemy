package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CuentaBancaria {

    //Declaración de atributos del objeto CuentaBancaria
    private String nombreCliente;
    private String numeroCuenta;
    private double saldo;
    private int movimientoEntero;
    private Movimiento movimientos[] = new Movimiento[200];

    //Creación de un constructor vacío privado
    private CuentaBancaria() {
        movimientoEntero = 0;
    }

    //Creación de un costructor vacío con los atributos como el nombre, número de cuenta y saldo inicial
    public CuentaBancaria(String nombreCliente, String numeroCuenta, double saldo) {
        //Sentencia que se encarga de validar que los campos no se encentren vacíos 
        if ((nombreCliente.equals("")) || (numeroCuenta.equals(""))) {
            System.out.println("No se puede crear la cuenta, el nombre del usuario o el número de cuenta están vacíos");
        } else if (saldo < 0) {
            //Sentencia que se encarga de verificar que el ingreso sea positivo
            System.out.println("Se ha ingresado un saldo negativo, no se puede crear la cuenta");
        } else {
            //Asignación de los atributos de la clase con lo que ingresa al constructor
            this.nombreCliente = nombreCliente;
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
            //Mensaje de cuenta creada 
            System.out.println("Se ha creado una cuenta");
        }

    }

    //Métodos getters y setter del atributo nombreCliente
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    //Métodos getters y setters del atributo numeroCuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    //Métodos getters y setters del atributo saldo
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Método que se encarga de ingresar saldo a la cuenta
    public void asignarSaldoCuenta(double saldoIngresado) {
        //Sentencia que verifica que el saldo ingresado sea positivo
        if (saldoIngresado < 0) {
            System.out.println("Cantidad negativa, no es válida");
        } else {
            //Cambio del valor de saldo con la suma del ingresado
            this.saldo = this.saldo + saldoIngresado;
        }
        //LLamado del método que registra los movimientos de la cuenta
        crearMovimientos("Agregar Saldo");
    }

    //Método que se encarga de realizar un retiro de la cuenta bancaria
    public void retiroSaldoCuenta(double retiro) {
        //Sentencia que se encarga de verificar que el saldo no sea mayor al saldo de la cuenta
        if (retiro > this.saldo) {
            System.out.println("El monto a retirar excede al saldo de la cuenta");
        } else {
            //Sentencia que resta el saldo actual menos el retiro
            this.saldo = this.saldo - retiro;
        }
        //LLamado del método que registra los movimientos de la cuenta
        crearMovimientos("Retirar Saldo");
    }

    //Método que se encarga de consultar el saldo de la cuenta, en función del nombre del cliente y número de cuenta
    public double consultarSaldo(String nombre, String numeroCuenta) {
        double saldoRetorno = 0;
        //Sentencia que verifica si las credenciales son correctsas
        if ((this.nombreCliente.equals(nombre)) && (this.numeroCuenta.equals(numeroCuenta))) {
            //Retorno del saldo actual
            saldoRetorno = this.saldo;
        } else {
            //En caso negativo se manda un mensaje que los datos no son correctos
            System.out.println("Los datos no son correctos, verifica tus datos");
        }
        //LLamado del método que registra los movimientos de la cuenta
        crearMovimientos("Consultar Saldo");
        //Retorno del saldo en función de las credenciales obtenidas, en caso de que hayan sido erroneas se manda un cero
        return saldoRetorno;
    }

    //Método que se encarga de crear los movimientos de la cuenta.
    private void crearMovimientos(String motivo) {
        //Creación del objeto de tipo date, para observar los movimientos de la cuenta
        Date fecha = new Date();
        //Clase que se encarga de darle formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy - HH:mm:ss");
        //Asignación para poder modificar la fecha con el formato propuesto
        String fechaTexto = formato.format(fecha);
        //Creación del objeto de tipo movimiento para obseravr el motivo y la fecha
        Movimiento movimiento = new Movimiento(motivo, fechaTexto);
        //Asignación del arreglo para los movimientos
        movimientos[this.movimientoEntero] = movimiento;
        //Incremento del número de movimientos
        this.movimientoEntero = this.movimientoEntero + 1;
    }

    //método qeu se encarga de la impresión de los movimientos
    public void movimientos() {
        //Ciclo que recorre el arreglo de movimietnos
        for (int i = 0; i < movimientos.length; i++) {
            //Sentencia para que se pueda observar los movimientos no nulos
            if (movimientos[i] != null) {
                //Impresión de los movimientos
                System.out.println((i + 1) + ".- " + movimientos[i].toString());
            }
        }
    }

    //Método que imprime los atributos del objeto
    @Override
    public String toString() {
        return "CuentaBancaria{" + "nombreCliente=" + nombreCliente + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + '}';
    }

}
