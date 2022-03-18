package figura;

import interfaces.IAltura;
import interfaces.IMedidas;

public class TrianguloIsosceles implements IAltura, IMedidas {
    private double base;
    private double lado;

    public TrianguloIsosceles(double base, double lado) {
        this.base = base;
        this.lado = lado;
    }

    @Override
    public double altura() {
        double ladoCuadrado = Math.pow(lado,2);
        double baseCuadrado = Math.pow(base,2);
        double dentroRaiz = ladoCuadrado-(baseCuadrado/4);
        return Math.sqrt(dentroRaiz);
    }

    @Override
    public double calcularPerimetro() {
        return base + (2 * lado);
    }

    @Override
    public double calcularArea() {
        return (base * altura()) / 2;
    }
}
