package in.stackroute.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        out.println("<html>");
        out.println("<head><title>Authentication</title></head>");
        out.println("<body>");
        if (userName.equals("admin") && password.equals("admin")) {
            out.println("<h1>Welcome Admin</h1>");
        } else {
            out.println("<h1>Invalid UserName or Password</h1>");
        }
        out.println("</body>");
        out.println("</html>");
    }

}
