package domain;

public class Rectangulo extends FiguraGeometrica {

    public Rectangulo(String tipoFigura) {
        super(tipoFigura);
        System.out.println("Constructor de la clase Rectangulo");
    }

    @Override
    public void dibujar() {
        System.out.println("Sobreescritura del métod abstracto de figuraGeometrica");
        System.out.println("Se imprime un: " + this.getClass().getSimpleName());
    }
}
