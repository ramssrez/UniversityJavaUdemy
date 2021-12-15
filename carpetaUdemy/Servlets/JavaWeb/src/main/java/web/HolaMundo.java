package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author ramssrez
 */
//Anotación de la ruta de nuetra pagina
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet{

    //Uso del método doGet para poder reazliar la petición y el resultado
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Glassfishe realiza la petición
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Hola mundo desde Servlets");
    }
    
}
