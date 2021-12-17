package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ramssrez
 */
@WebServlet("/ServletFormulario")
public class ServletFormularios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("usuario");
        System.out.println("usuario = " + usuario);

        String password = request.getParameter("password");
        System.out.println("password = " + password);

        String tecnologias[] = request.getParameterValues("tecnologia");
        System.out.println("tecnologias = " + tecnologias);

        String genero = request.getParameter("genero");
        System.out.println("genero = " + genero);

        String ocupacion = request.getParameter("ocupacion");
        System.out.println("ocupacion = " + ocupacion);

        String musica[] = request.getParameterValues("musica");
        System.out.println("musica = " + musica);

        String comentario = request.getParameter("comentarios");
        System.out.println("comentario = " + comentario);

        out.print("<html>");

        out.print("<head>");
        out.print("<title>Resultado Servlet</title>");
        out.print("</head>");

        out.print("<body>");
        out.print("<h1>Parametros procesados por el Servlet</h1>");
        out.print("<table border='1'>");

        //Tabla de usuario
        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");

        //Tabla de password
        out.print("<tr>");
        out.print("<td>");
        out.print("Password");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");

        //Tabla de tecnología
        out.print("<tr>");
        out.print("<td>");
        out.print("Tecnologias");
        out.print("</td>");
        out.print("<td>");
        for (String tecnologia : tecnologias) {
            out.print(tecnologia);
            out.print(" / ");
        }
        out.print("</td>");
        out.print("</tr>");

        //Tabla de género
        out.print("<tr>");
        out.print("<td>");
        out.print("Género");
        out.print("</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");

        //Tabla de ocupación
        out.print("<tr>");
        out.print("<td>");
        out.print("Ocupación");
        out.print("</td>");
        out.print("<td>");
        out.print(ocupacion);
        out.print("</td>");
        out.print("</tr>");

        //Tabla de música
        out.print("<tr>");
        out.print("<td>");
        out.print("Música favorita");
        out.print("</td>");
        out.print("<td>");
        if (musica != null) {
            for (String m : musica) {
                out.print(m);
                out.print(" / ");
            }
        } else {
            out.print("Música no seleccionada");
        }
        out.print("</td>");
        out.print("</tr>");

        //Tabla de comentarios
        out.print("<tr>");
        out.print("<td>");
        out.print("Comentarios");
        out.print("</td>");
        out.print("<td>");
        out.print(comentario);
        out.print("</td>");
        out.print("</tr>");

        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
    }

}
