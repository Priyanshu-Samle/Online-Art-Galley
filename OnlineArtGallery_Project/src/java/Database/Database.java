
package Database;
import java.sql.*;
//import javax.servlet.RequestDispatcher;
public class Database {
    
    Connection con;
    
    public  boolean RegistrationConnection(String name, String email,  String pass, long phone_no) throws Exception{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery", "root", "Priyanshu@1234");
        
        PreparedStatement ps = con.prepareStatement("insert into Registration values(?,?,?,?)");
        
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, pass);
        ps.setLong(4, phone_no);
        
        int x = ps.executeUpdate();
        
        if(x>0){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public boolean loginConnection(String email, String pass){
         try{
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery","root","Priyanshu@1234");
            PreparedStatement ps = con.prepareStatement("select phone_no from Registration where email=? and password1=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            
             if(rs.next()){
                 return true ;
             }
            
         }
         catch(ClassNotFoundException | SQLException e){
             return true;
         }
         
         return false;
    }
    
    public  boolean order(String name, long phone_number, String address, int  quantiy){
        
        try{
             Class.forName("com.mysql.jdbc.Driver");
             
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery", "root", "Priyanshu@1234");
             
             PreparedStatement ps = con.prepareStatement("insert into order_details values (?,?,?,?)");
             
             ps.setString(1, name);
             ps.setLong(2, phone_number);
             ps.setString(3, address);
             ps.setInt(4, quantiy);
             
             int x = ps.executeUpdate();
             if(x>0){
                 con.close();
                 return true;
             }
             else{
                 con.close();
                 return false;
                 
             }
        }
        catch(ClassNotFoundException | SQLException e){
            
            return false;
            
        }
        
        
    }
}
