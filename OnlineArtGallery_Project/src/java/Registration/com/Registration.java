
package Registration.com;
import Database.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Registration extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phone_no = Long.parseLong(req.getParameter("phone_no"));
		String password1 = req.getParameter("pass1");
		String password2 = req.getParameter("pass2");
                Database d = new Database();
		
		PrintWriter out = resp.getWriter();
		if(email.contains("@gmail.com") && password1.equals(password2)) {
			
			try{
                            if(d.RegistrationConnection(name, email, password1, phone_no)){
                                
                                resp.sendRedirect("Home.html");
                            }
                        }
                        catch(Exception e){
                            
                        }
                        
		}
		else {
			out.print("<h1>Invalid information</h1>");
		}
    }

    
    
    
}
