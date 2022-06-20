package servlet;

import java.sql.*;
import java.util.ArrayList;  

public class LoginDao {  
	
public static boolean validate(String name,String pass){  
boolean status=false;  
Connection con=null;
try{  
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(url,"root","root");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from customers where name=? and password=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
  
ResultSet rs=ps.executeQuery(); 
status=rs.next(); 
con.close();
          
}catch(Exception e){System.out.println(e);} 
return status;  
}  

public static ArrayList<Hotel> hotels(){  
boolean status=false;  
Connection con=null;
ArrayList<Hotel> hotel = new ArrayList<Hotel>();
try{  
	System.out.println("hotels");
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(url,"root","root"); 
	
	PreparedStatement ps=con.prepareStatement("select * from hotels");  
	ResultSet rs=ps.executeQuery(); 
	while(rs.next()) {
		Hotel h = new Hotel(rs.getString("ht_id"), rs.getString("name"), rs.getString("location"), rs.getLong("contact_num"), rs.getInt("rooms"), rs.getInt("total_rooms"), rs.getInt("price"));
		hotel.add(h);
	}
con.close();
          
}catch(Exception e){System.out.println(e);} 
return hotel;
}  
public static ArrayList<Hotel> showhotel(String ht_id){  
boolean status=false;  
Connection con=null;
ArrayList<Hotel> hotel = new ArrayList<Hotel>();
try{  
	
	System.out.println(ht_id);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(url,"root","root");
	
	//selecting hotel information
	PreparedStatement ps=con.prepareStatement("select * from hotels where ht_id = ?"); 
	ps.setString(1,ht_id);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		Hotel h = new Hotel(rs.getString("ht_id"), rs.getString("name"), rs.getString("location"), rs.getLong("contact_num"), rs.getInt("rooms"), rs.getInt("total_rooms"), rs.getInt("price"));
		hotel.add(h);
	}
con.close();
          
}catch(Exception e){System.out.println(e);} 
return hotel;
}

public static ArrayList<Customers> profile(String username){  
boolean status=false;  
Connection con=null;
ArrayList<Customers> customer = new ArrayList<Customers>();
try{  
	
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(url,"root","root");
	
	//selecting hotel information
	PreparedStatement ps=con.prepareStatement("select * from customers where name = ?");  
	ps.setString(1,username); 
	ResultSet rs=ps.executeQuery(); 
	while(rs.next()) {
		Customers c = new Customers(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("country"), rs.getLong("ph_number"));
		customer.add(c);
	}
con.close();
          
}catch(Exception e){System.out.println(e);} 
return customer;
} 

public static void review(String hotel_id, String username, String comments, int ratings){  
boolean status=false;  
Connection con=null;
try{  
	
	
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(url,"root","root"); 
	
	PreparedStatement ps=con.prepareStatement("insert into review(hotel_id, username, comments, ratings) values(?,?,?,?)");  
	ps.setString(1,hotel_id); 
	ps.setString(2,username); 
	ps.setString(3,comments); 
	ps.setInt(4,ratings); 
	ps.executeUpdate();
con.close();
          
}catch(Exception e){System.out.println(e);} 
} 

public static ArrayList<Reviews> reviews(String hotel_id){  
boolean status=false;  
Connection con=null;
System.out.println(hotel_id);
ArrayList<Reviews> reviews = new ArrayList<Reviews>();
try{  
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(url,"root","root");
	
	PreparedStatement ps=con.prepareStatement("select * from review where hotel_id = ?");  
	ps.setString(1,hotel_id);
	ResultSet rs=ps.executeQuery(); 
	while(rs.next()) {
		Reviews r = new Reviews(rs.getString("hotel_id"), rs.getString("username"), rs.getString("comments"), rs.getString("ratings"));
		reviews.add(r);
	}

	
          
}catch(Exception e){System.out.println(e);} 
return reviews;
} 

}