package servlet;

import java.sql.*;  

public class AdminDao {  
public static boolean validate(String name,String pass){  
boolean status=false;  
Connection con=null;
try{  
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(  
url,"root","root");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from admin where username=? and password=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
  
ResultSet rs=ps.executeQuery(); 
status=rs.next(); 

          
}catch(Exception e){System.out.println(e);} finally {
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
return status;  
}  
}  