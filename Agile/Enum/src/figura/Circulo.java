package figura;

import interfaces.IMedidas;

public class Circulo implements IMedidas {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularPerimetro() {
        return Math.PI*2*radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI*Math.pow(radio,2);
    }
}
