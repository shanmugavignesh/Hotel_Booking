package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowHotel")
public class ShowHotel extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		try {
			HttpSession session=request.getSession();
//			
		String ht_id = request.getParameter("hid");
		session.setAttribute("hid", ht_id);
//		
//		System.out.println(ht_id);
//		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/hotel";  
//		con=DriverManager.getConnection(url,"root","root");
//		
//		//selecting hotel information
//		PreparedStatement ps=con.prepareStatement("select * from hotels where ht_id = ?"); 
//		ps.setString(1,ht_id);
//		ResultSet rs = ps.executeQuery();
//		rs.next();
//		String name = rs.getString("name");
//		String location = rs.getString("location");
//		long contact_num = rs.getLong("contact_num");
//		int rooms = rs.getInt("rooms");
//		int no_rooms = (rs.getInt("total_rooms") - rs.getInt("rooms"));
//		int price = rs.getInt("price");
//		System.out.println(name + ":" + location);
//		
//		PrintWriter out = response.getWriter();
//		
//		out.println("Hotel name: " + name + "\n");
//		out.println("location: " + location + "\n");
//		con.close();
//		
//		session.setAttribute("hotel_name", name);
//		session.setAttribute("location", location);
//		session.setAttribute("contact_num", contact_num);
//		session.setAttribute("rooms", no_rooms);
//		session.setAttribute("price", price);
//		session.setAttribute("rooms", rooms);
//		
		ArrayList<Hotel> hotel = LoginDao.showhotel(ht_id);
		request.setAttribute("hotel", hotel);
		
		System.out.println("reviews");
		ArrayList<Reviews> reviews = LoginDao.reviews(ht_id);
		request.setAttribute("reviews", reviews);
		
		RequestDispatcher rd = request.getRequestDispatcher("booking.jsp");
		rd.forward(request, response);
		
		}catch(Exception e) {}
	}

}
