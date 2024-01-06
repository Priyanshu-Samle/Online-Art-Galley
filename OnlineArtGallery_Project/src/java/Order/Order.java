
package Order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Database.*;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/order")
public class Order extends HttpServlet{
     

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
              try{
                    String name = req.getParameter("name");
                long number = Long.parseLong(req.getParameter("phone_no"));
                String address = req.getParameter("address");
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                
                  PrintWriter out = resp.getWriter();
                if(new Database().order(name, number, address, quantity)){
                    
                    resp.sendRedirect("payment.html");
                }
                else{
                    resp.setContentType("text/html");
                    out.println(":fill correct information");
                    RequestDispatcher rs = req.getRequestDispatcher("order.html");
                    rs.include(req, resp);
                }
                
                
              }
              catch(IOException | NumberFormatException | ServletException e){
                   PrintWriter out = resp.getWriter();
                   
                   resp.setContentType("text/html");
                   out.println("exception");
                    RequestDispatcher rs = req.getRequestDispatcher("order.html");
                    rs.include(req, resp);
              }
                
                
    }
    
}
