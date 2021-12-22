package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ramssrez
 */
@WebServlet("/ContadorVisitasServlet")
public class ServletContadorVisitas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Declaramos la variable contadors
        int contador = 0;

        //REvisar si existe la cookie contador 
        Cookie[] cookies = request.getCookies();

        //Buscamos si ya existe una cookie creada con anterioridad
        //Llamada visitanteRecurrente
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("contadorVisitas")) {
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }

        //Se incrementa el contador mas uno para cualquier de los dos caso planteados
        contador++;

        //Se agrega una respuesta al navegador
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));

        //Almacenamiento de la cookie por una hora
        c.setMaxAge(3600);
        response.addCookie(c);

        //Mandamos el mensaje al navegador
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Contador de visitas: " + contador);
        out.close();
    }

}
