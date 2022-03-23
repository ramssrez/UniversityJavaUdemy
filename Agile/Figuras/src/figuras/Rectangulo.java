package figuras;

import interfaces.IMedidas;

public class Rectangulo implements IMedidas {

    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularPerimetro() {
        return (this.base * 2) + (this.altura * 2);
    }

    @Override
    public double calcularArea() {
        return this.base * this.altura;
    }
}
