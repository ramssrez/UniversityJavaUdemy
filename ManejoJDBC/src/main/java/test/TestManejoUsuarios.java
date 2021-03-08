package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        //Instancia de la calse DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //Insertar un nuevo registro a la tabla
        //Usuario usuarioNuevo = new Usuario("raul.lopez", "698");
        //usuarioDAO.insertar(usuarioNuevo);
        
        //Actualizar un registro
        //Usuario usuarioActualizar = new Usuario(4, "snadra.sanchez", "5862");
        //usuarioDAO.actualizar(usuarioActualizar);
        
        //Eliminar un registro de la tabla
        Usuario usuarioEliminar = new Usuario(5);
        usuarioDAO.eliminar(usuarioEliminar);
        
        List<Usuario> usuarios = usuarioDAO.seleccionar();
        imprimir(usuarios);       
    }
     public static void imprimir(List<Usuario> usuarios) {
        usuarios.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
