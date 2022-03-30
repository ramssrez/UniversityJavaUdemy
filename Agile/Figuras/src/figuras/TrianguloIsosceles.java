package figuras;

import abstracts.Triangulo;

public class TrianguloIsosceles extends Triangulo {
    private double lado;
    private double base;

    public TrianguloIsosceles(double lado, double base) {
        this.lado = lado;
        this.base = base;
        this.altura = calcularAltura();
    }

    @Override
    public double calcularAltura() {
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
        return (base * altura) / 2;
    }

    @Override
    public String toString() {
        return "TrianguloIsosceles{" +
                "altura=" + altura +
                ", lado=" + lado +
                ", base=" + base +
                '}';
    }
}
