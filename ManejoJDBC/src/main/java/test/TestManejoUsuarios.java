package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.seleccionar();
        imprimir(usuarios);       
    }
     public static void imprimir(List<Usuario> usuarios) {
        usuarios.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
