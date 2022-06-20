package servlet;

import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
@WebServlet("/Register")
public class Register extends HttpServlet { 
	Connection con=null;
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("username");  
String p=request.getParameter("password"); 
String email = request.getParameter("email");
String country = request.getParameter("country");
long ph_num = Long.parseLong(request.getParameter("ph_number"));

String ph = Long.toString(ph_num);

String Name = "^[a-zA-Z0-9&_]{3,10}$";
String password = "^[a-zA-Z0-9@&_]{3,10}$";
String Email = " ?[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*";
String Country = "^[a-zA-Z]*$";
String num = "^ ?(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";

String check="true";
if(!(ph.matches(num))){check="Mobile Number";}
if(!(country.matches(Country))){check="Country";}
if(!(email.matches(Email))){check="Email";}
if(!(p.matches(Name))){check="Password";}
if(!(n.matches(Name))){check="Username";}
if(check != "true") {
	request.setAttribute("check", check);
	System.out.println(check);
	out.append(check);
	//RequestDispatcher rd = request.getRequestDispatcher("register1.jsp");
	//rd.forward(request, response);
}
else {
          
try{  
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(url,"root","root");  
  
PreparedStatement ps=con.prepareStatement("insert into Customers values(?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p); 
ps.setString(3,email);
ps.setString(4,country);
ps.setLong(5, ph_num);
int i = ps.executeUpdate();
System.out.println(check);
if(i>0) {  
	HttpSession session = request.getSession();
	session.setAttribute("username", n);
	session.setAttribute("password", p);
	//RequestDispatcher rd = request.getRequestDispatcher("Hotels");
	//rd.forward(request, response);
}
out.append(check);
      
          
}catch (Exception e2) {System.out.println(e2);} 
}
          
out.close();  
}  
  
}  