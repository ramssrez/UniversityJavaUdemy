package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ramssrez
 */
@WebServlet("/ServletSesiones")
public class ServletSesiones extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        //Pedir el atributo contadorVisistas a la sesion
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        
        //Si es nulo es la primera vez que se visita el sitio
        if(contadorVisitas != null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        }else{
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        
        //Agregamos el nuevo valor a la sesión
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        //Mandamos la respuesta al cliente
        PrintWriter out= response.getWriter();
        out.print("no. accesos al recurso: " + contadorVisitas);
        out.print("<br>");
        out.print("Id de la sesión: " + sesion.getId());
        out.close();
    }
        
}
