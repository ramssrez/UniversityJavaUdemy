package figura;

import interfaces.IMedidas;

public class Rectangulo implements IMedidas {
    private double ancho;
    private  double altura;

    public Rectangulo(double ancho, double altura) {
        this.ancho = ancho;
        this.altura = altura;
    }

    @Override
    public double calcularPerimetro() {
        return ((2 * ancho) + ( 2 * altura) );
    }

    @Override
    public double calcularArea() {
        return ancho * altura;
    }
}
