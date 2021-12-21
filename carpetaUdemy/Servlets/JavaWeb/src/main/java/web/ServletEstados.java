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
@WebServlet("/ServletEstados")
public class ServletEstados extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Simulación los valores correctos
        String usuarioOk = "Juan";
        String passwordOk = "123";

        String usuaurio = req.getParameter("usuario");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();

        if (usuarioOk.equals(usuaurio) && passwordOk.equals(password)) {
            out.print("<h1>");
            out.print("Datos correctos");
            out.print("<br>Usuario: " + usuaurio);
            out.print("<br>Password: " + password);
            out.print("</h1>");
        }else{
            resp.sendError(resp.SC_UNAUTHORIZED,"Las credenciales son erroneas");
        }
        out.close();
    }

}
