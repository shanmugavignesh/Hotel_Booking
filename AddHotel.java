package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AddHotel")
public class AddHotel extends HttpServlet{
	
	Connection con=null;
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String hotel_id =request.getParameter("hotel_id");  
String hotel_name=request.getParameter("hotel_name"); 
String location = request.getParameter("location");
long contact_num = Long.parseLong(request.getParameter("contact_number"));
int rooms = Integer.parseInt(request.getParameter("total_rooms"));
int total_rooms = Integer.parseInt(request.getParameter("total_rooms"));
int price = Integer.parseInt(request.getParameter("price"));


          
try{  
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(url,"root","root");  
  
PreparedStatement ps=con.prepareStatement("insert into hotels values(?,?,?,?,?,?,?)");  

ps.setString(1,hotel_id);  
ps.setString(2,hotel_name); 
ps.setString(3,location);
ps.setLong(4,contact_num);
ps.setInt(5, rooms);
ps.setInt(6, total_rooms);
ps.setInt(7, price);

int i = ps.executeUpdate();
if(i>0) {  
	con.close();
	RequestDispatcher rd = request.getRequestDispatcher("AdminMain.html");
	rd.forward(request, response);
}
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
}
