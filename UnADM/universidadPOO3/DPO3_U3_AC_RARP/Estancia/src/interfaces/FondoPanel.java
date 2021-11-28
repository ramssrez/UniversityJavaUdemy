package interfaces;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ramssrez
 */
//Clase generada para poder ingesar el fondo de una imagen a un JPanel
public class FondoPanel extends JPanel{
    //Delcaración del objeto image
    private Image imagen;
    
    //Sobreescritura del método paint para agregar el fondo
    @Override
    public void paint(Graphics g){
        //Asignación de la imagen como imagen icon, en ella se agrega la dirección de la imagen
        imagen = new ImageIcon(getClass().getResource("/imagenes/divicionOpaco.png")).getImage();
        //Dibuajdo de la imagen ajustandose a las dimenciones de la pantalla
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
}
