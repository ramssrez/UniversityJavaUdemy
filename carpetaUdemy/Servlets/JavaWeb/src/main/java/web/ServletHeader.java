package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ramssrez
 */
@WebServlet("/ServletHeaders")
public class ServletHeader extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //Impresión del metodo http usado
        String metodoHttp = request.getMethod();
        System.out.println("metodoHttp = " + metodoHttp);

        //Impresión de la uri utilizado
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);
        
        Enumeration cabeceros = request.getHeaderNames();
        while(cabeceros.hasMoreElements()){
            String nombreCabecero = (String) cabeceros.nextElement();
            System.out.println("nombreCabecero = " + nombreCabecero + " : " + request.getHeader(nombreCabecero));
        }
    }

}
