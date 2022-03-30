package figuras;

import abstracts.Triangulo;

public class TrianguloEquilatero extends Triangulo {
    private double lado;

    public TrianguloEquilatero(double lado) {
        this.lado = lado;
        this.altura = calcularAltura();
    }
    @Override
    public double calcularAltura() {
        return (Math.sqrt(3) * lado) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return lado * 3;
    }

    @Override
    public double calcularArea() {
        return (this.lado * this.altura) / 2;
    }

    @Override
    public String toString() {
        return "TrianguloEquilatero{" +
                "altura=" + altura +
                ", lado=" + lado +
                '}';
    }
}
