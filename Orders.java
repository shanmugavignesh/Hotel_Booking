package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Orders")
public class Orders extends HttpServlet{
	Connection con = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("orders");
		HttpSession session=request.getSession();
		//String hid=request.getParameter("hid");
		String username=(String)session.getAttribute("username");
		try {
			
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    String url = "jdbc:mysql://localhost:3306/hotel";  
		con=DriverManager.getConnection(url,"root","root"); 
		
		PreparedStatement ps=con.prepareStatement("select * from customers where name = ?");  
		ps.setString(1,username); 
		ResultSet rs1=ps.executeQuery(); 
		
		session.setAttribute("rs1", rs1);
		
	
		////////////////
		
		ps=con.prepareStatement("select * from bookings inner join hotels where bookings.hotel_id=hotels.ht_id and username = ?");  
		ps.setString(1,username); 
		ResultSet rs2=ps.executeQuery(); 
		
		session.setAttribute("rs2", rs2);
		
		
		
//		PrintWriter out = response.getWriter();
//		out.println("Booked Rooms<br>");
//		out.println("<style>th, td {\r\n"
//				+ "  border: 1px solid black;\r\n"
//				+ "  border-radius: 10px;\r\n"
//				+ "}</style>");
//		
//				while(rs2.next()) {
//					System.out.println("hi");
//					String hotel_name1 = rs2.getString("hotel_id");
//					int order_id = rs2.getInt("order_id");
//					out.println("<table border=2><tr><td>");
//					out.println("Hotel Name: " + hotel_name1);
//					out.println("Book ID: " + order_id + "<br>");
//					out.println("<a href = Cancel?id=" + order_id + ">" + "cancel_booking" + "</a>");
//					out.println("</td></tr></table><br>");
//
//				}
		

		
	//	ArrayList<User> users = new ArrayList<User>();
	//	while(rs.next())
	//	{
	//		User user = new User();
	//		user.setOrder_id(rs.getInt("order_id"));
	//	    user.setUsername(rs.getString("username"));
	//	    user.setHotel_id(rs.getInt("Hotel_id"));
	//	    users.add(user);
			
	//	}
	//	request.setAttribute("users", users);
	//	RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
	//	rd.forward(request, response);
		
		
		ps=con.prepareStatement("select * from cancel inner join hotels on cancel.hotel_id=hotels.ht_id inner join customers where cancel.username=customers.name and cancel.username = ?");  
		ps.setString(1,username); 
		ResultSet rs3 = ps.executeQuery(); 
		
		session.setAttribute("rs3", rs3);
		//while(rs.next()) {
		//	String hotel_name2 = rs.getString("hotel_id");
		//	String cancel_id = rs.getString("order_id");
		//	
		//	out.println("Username: "+ username + "\n");
		//	out.println("Hotel Name: " + hotel_name2 + "\n");
		//	out.println("Cancel ID: " + cancel_id + "\n");
		//	out.println("..............................");
		//}
				
		RequestDispatcher rd = request.getRequestDispatcher("showorders.jsp");
		rd.forward(request, response);
		con.close();
		} catch (ClassNotFoundException | SQLException e) {}
	}
}
