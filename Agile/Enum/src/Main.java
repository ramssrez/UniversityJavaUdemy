import contants.Mensajes;
import contants.TipoFigurasEnum;
import figura.Circulo;
import figura.Cuadrado;
import figura.Rectangulo;
import interfaces.IMedidas;

import javax.swing.*;

public class Main {
    /*public static final String FIGURA_CIRCULO = "Circulo";
    public static final String FIGURA_CUADRADO = "Cuadrado";
    public static final String FIGURA_RECTANGULO = "Rectangulo";*/

    public static void main(String[] args) {
        String nombreFigura = JOptionPane.showInputDialog(Mensajes.INGRESO_NOMBRE_FIGURA);
        TipoFigurasEnum figura  = getNombreFigura(nombreFigura);
        IMedidas medidas = null;

        /*if (nombreFigura.equalsIgnoreCase(FIGURA_CIRCULO)) {
            double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el radio en cm"));
            medidas = new Circulo(radio);
        } else if (nombreFigura.equalsIgnoreCase(FIGURA_CUADRADO)) {
            double lado = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el lado en cm"));
            medidas = new Cuadrado(lado);
        } else if (nombreFigura.equalsIgnoreCase(FIGURA_RECTANGULO)) {
            double base = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la base en cm"));
            double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la altura en cm"));
            medidas = new Rectangulo(base, altura);
        }*/
        /*if (nombreFigura.equalsIgnoreCase(TipoFigurasEnum.CIRCULO.name())) {
            double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el radio en cm"));
            medidas = new Circulo(radio);
        } else if (nombreFigura.equalsIgnoreCase(TipoFigurasEnum.CUADRADO.name())) {
            double lado = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el lado en cm"));
            medidas = new Cuadrado(lado);
        } else if (nombreFigura.equalsIgnoreCase(TipoFigurasEnum.RECTANGULO.name())) {
            double base = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la base en cm"));
            double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la altura en cm"));
            medidas = new Rectangulo(base, altura);
        }*/
        switch (figura) {
            case CIRCULO:
                double radio = Double.parseDouble(JOptionPane.showInputDialog(String.format(Mensajes.INGRESO_RADIO, Mensajes.UNIDAD_MEDIDA_CM)));
                medidas = new Circulo(radio);
                break;

            case CUADRADO:
                double lado = Double.parseDouble(JOptionPane.showInputDialog(String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                medidas = new Cuadrado(lado);
                break;

            case RECTANGULO:
                double base = Double.parseDouble(JOptionPane.showInputDialog(String.format(Mensajes.INGRESO_BASE, Mensajes.UNIDAD_MEDIDA_CM)));
                double altura = Double.parseDouble(JOptionPane.showInputDialog(String.format(Mensajes.INGRESO_ALTURA, Mensajes.UNIDAD_MEDIDA_CM, Mensajes.UNIDAD_MEDIDA_CM, Mensajes.UNIDAD_MEDIDA_CM, Mensajes.UNIDAD_MEDIDA_CM)));
                medidas = new Rectangulo(base, altura);
                break;
        }
        String mensaje = "La figura ingresada fue " + nombreFigura + ", que tiene como perímetro: " + medidas.calcularPerimetro() + " y área: " + medidas.calcularArea();
        //mensaje = String.format()
        System.out.printf(String.format("ESto es una parametr %s ",medidas.calcularArea()));
        JOptionPane.showMessageDialog(null,mensaje);


        //String mensaje = "La figura ingresada fue " + nombreFigura + ", que tiene como perímetro: " + medidas.calcularPerimetro() + " y área: " + medidas.calcularArea();

        System.out.println(mensaje);
    }

    public static TipoFigurasEnum getNombreFigura(String nombreFigura) {
        TipoFigurasEnum[] tipoFigurasEnums = TipoFigurasEnum.values();

        for (TipoFigurasEnum tipoFigurasEnum : tipoFigurasEnums) {
            if (tipoFigurasEnum.name().equalsIgnoreCase(nombreFigura)) {
                return tipoFigurasEnum;
            }
        }

        return null;
    }

}
