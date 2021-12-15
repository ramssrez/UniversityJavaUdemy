package web;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        //Glassfishe realiza la petición
    }
    
}
