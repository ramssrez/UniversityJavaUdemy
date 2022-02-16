package tercerasesion;

import javax.swing.*;

public abstract class Shape extends JComponent {
    private int x, y, width, height;

    public Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
    public void scale(float scale){
        this.width = (int)(width*scale);
        this.height = (int)(height*scale);
    }

}
