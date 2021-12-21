package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ramssrez
 */
@WebServlet("/CookiesServlet")
public class ServletCookies extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Nuevo usuario para el caso de la visira por primera vez
        boolean nuevoUsuario = true;
        Cookie [] cookies = request.getCookies();
        
        //Buscamos si ya existe una cookie creada con anterioridad
        //Llamada visitanteRecurrente
        
        if (cookies != null) {
            for (Cookie c : cookies) {
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    //Si ya existe la cookie es un usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }else{
            mensaje = "Gracias por visitar nuevamente nuestro sitio";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje: " + mensaje);
        out.close();
    }
    
    
}
