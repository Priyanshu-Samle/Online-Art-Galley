
package Registration.com;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/redirectRegistrationPage")
public class RedirectRegisration extends HttpServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("Registration.html");
        rd.forward(req, res);
       
    }
    
}
