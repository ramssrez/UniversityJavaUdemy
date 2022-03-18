package figura;

import interfaces.IAltura;
import interfaces.IMedidas;

public class TrianguloEquilatero implements IAltura, IMedidas {
    private double lado;

    public TrianguloEquilatero(double lado) {
        this.lado = lado;
    }

    @Override
    public double altura() {
        return (Math.sqrt(3) * lado) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 3 * lado;
    }

    @Override
    public double calcularArea() {
        return (lado * altura())/2;
    }
}
