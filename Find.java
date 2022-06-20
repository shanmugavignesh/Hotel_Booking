package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Find")
public class Find extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String search_value = (String)request.getParameter("search");
	System.out.println(search_value);
	Connection con = null;
	HttpSession session = request.getSession();
	ArrayList<Hotel> hotel = new ArrayList<Hotel>();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/hotel";  
	con=DriverManager.getConnection(url,"root","root");
	
	String query = "select * from hotels where name like ?";
	PreparedStatement ps=con.prepareStatement(query);  
	ps.setString(1, "%" + search_value + "%");
	ResultSet rs = ps.executeQuery(); 
	while(rs.next()) {
		Hotel h = new Hotel(rs.getString("ht_id"), rs.getString("name"), rs.getString("location"), rs.getLong("contact_num"), rs.getInt("rooms"), rs.getInt("total_rooms"), rs.getInt("price"));
		hotel.add(h);
	}
	request.setAttribute("hotel", hotel);
	//session.setAttribute("rs", rs);
	RequestDispatcher rd = request.getRequestDispatcher("new.jsp");
	rd.forward(request, response);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
}
}

