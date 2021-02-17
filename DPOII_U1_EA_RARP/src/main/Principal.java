package main;

import windows.Inicio;
import windows.Login;

public class Principal {

    public static void main(String[] args) {
        var grafico = new Login();
        grafico.setTitle("Inicio de sesión");
        grafico.setVisible(true);
        var grafico2 = new Inicio();
        grafico2.setTitle("Inicio");
        grafico2.setVisible(true);   
    }

}
