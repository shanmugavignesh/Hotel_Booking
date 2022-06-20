package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C_LoginDao {

	public static boolean validate(String name,String pass){  
		boolean status=false;  
		Connection con=null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/musicapp";  
			con=DriverManager.getConnection(url,"root","root");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from users where name=? and password=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		  
		ResultSet rs=ps.executeQuery(); 
		status=rs.next(); 
		con.close();
		          
		}catch(Exception e){System.out.println(e);} 
		return status;  
		}
}
