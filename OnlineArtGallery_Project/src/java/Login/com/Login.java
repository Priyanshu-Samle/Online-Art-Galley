
package Login.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import Database.*;

@WebServlet("/loginforHome")
public class Login extends HttpServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        PrintWriter out = res.getWriter();
        Database d = new Database();
       try{
          
            if(d.loginConnection(email, pass)){
                out.print("valid");
                RequestDispatcher rd = req.getRequestDispatcher("Home.html");
                rd.forward(req, res);
            }
            else{
                res.setContentType("text/html");
                out.print("Invalid information");
                RequestDispatcher rd = req.getRequestDispatcher("index.html");
                rd.include(req, res);
            }
       }
       catch(IOException | ServletException e){
           out.print("Exception");
       }
        
    }
    
}
