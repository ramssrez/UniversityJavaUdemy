package figura;

import interfaces.IMedidas;

public class Cuadrado implements IMedidas {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4*this.lado;
    }

    @Override
    public double calcularArea() {
        return lado*lado;
    }
}
