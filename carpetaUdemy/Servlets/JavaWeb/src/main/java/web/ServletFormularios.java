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

        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Password");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");

        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
    }

}
