package domain;

public abstract class FiguraGeometrica {

    private String tipoFigura;

    protected FiguraGeometrica(String tipoFigura) {
        System.out.println("Constructor de la clase abtracte");
        this.tipoFigura = tipoFigura;
    }

    //No se abren argumentos, solo se declara el método sin procedimiento
    public abstract void dibujar();

    public String getTipoFigura() {
        System.out.println("Método get del tipo de figura");
        return tipoFigura;
    }

    public void setTipoFigura(String tipoFigura) {
        System.out.println("Método set del tipo de dato");
        this.tipoFigura = tipoFigura;
    }

    @Override
    public String toString() {
        return "FiguraGeometrica{" + "tipoFigura=" + tipoFigura + '}';
    }

}
