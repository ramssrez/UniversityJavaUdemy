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
@WebServlet("/GeneracionExcel")
public class ServletGeneracionExcel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //vnd Vendor Specific

        //Indicacion del tipo de repuseta al navegador
        response.setContentType("application/vnd.ms-excel"); 
        response.setHeader("Content-Disposition", "attachment;filename=ejemploExcel.xls");
        //NOta: Para el uso de excel usar excel poi.apache.org

        //Se indica al navegador que no guarde cache
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);

        //Se despliega información al cliente.
        PrintWriter out = response.getWriter();
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=SUMA(b2:b3)");
        out.close();

    }

}
