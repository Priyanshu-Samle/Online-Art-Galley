
package OnlinePayment;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/onlinePayment")
public class OnlinePayment extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        
       try{
            long Atm_no = Long.parseLong(req.getParameter("number"));
            int pin = Integer.parseInt(req.getParameter("pin"));
            
            if((Atm_no >999999999 && Atm_no<10000000000L) && (pin>999 && pin<10000)){
                
                
                RequestDispatcher rd = req.getRequestDispatcher("orderConfirm.html");
                rd.forward(req, resp);
            }
            else{
                PrintWriter out = resp.getWriter();
                resp.setContentType("text/html");
                out.print("invalid");
                RequestDispatcher rd = req.getRequestDispatcher("onlinePayment.html");
                rd.include(req, resp);
                
            }
       }
       catch(NumberFormatException e){
          PrintWriter out = resp.getWriter();
                resp.setContentType("text/html");
                out.print("invalid");
                RequestDispatcher rd = req.getRequestDispatcher("onlinePayment.html");
                rd.include(req, resp);
       }
    }
    
    
    
}
