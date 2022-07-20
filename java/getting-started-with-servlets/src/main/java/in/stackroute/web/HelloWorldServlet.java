package in.stackroute.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create a Servlet
 * 1. Create a Servlet class called HelloWorldServlet
 * 2. Extent HelloWorldServlet class from HttpServlet class
 * 3. Override do...() methods
 * 4. Configure the servlet in web.xml file using servlet and servlet-mapping
 * 
 */

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<html>");
        out.println("<head><title>Hello World Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello World From doget()</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<html>");
        out.println("<head><title>Hello World Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello World From doPost()</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
}
