package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/Cancel")
public class Canceling extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int order_id = Integer.parseInt(request.getParameter("id"));
		String username=(String)session.getAttribute("username");
		try {
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/hotel";  
			con=DriverManager.getConnection(url,"root","root"); 
			
			PreparedStatement ps=con.prepareStatement("select hotel_id from bookings where order_id = ?");  
			ps.setInt(1,order_id); 
			ResultSet rs=ps.executeQuery(); 
			rs.next();
			String hid = rs.getString("hotel_id");
			
			ps=con.prepareStatement("select rooms from hotels where ht_id = ?");  
			ps.setString(1,hid); 
			rs=ps.executeQuery(); 
			rs.next(); 
			int rooms = rs.getInt("rooms");
			
			ps = con.prepareStatement("insert into cancel(username, hotel_id, order_id,date_and_time) values(?,?,?,now())");
			ps.setString(1, username);
			ps.setString(2, hid);
			ps.setInt(3, order_id);
			ps.executeUpdate();
			
			ps = con.prepareStatement("select * from bookings where order_id = ?");
			ps.setInt(1, order_id);
			rs = ps.executeQuery();
			rs.next();
			int booked = rs.getInt("booked");
			System.out.println(booked);
			
			ps = con.prepareStatement("update hotels set rooms = ? where ht_id = ?");
			ps.setInt(1, (rooms+booked));
			ps.setString(2, hid);
			ps.executeUpdate();
			
			ps = con.prepareStatement("delete from bookings where order_id = ?");
			ps.setInt(1, order_id);
			ps.executeUpdate();
		
			 PrintWriter out = response.getWriter();
			 RequestDispatcher rd = request.getRequestDispatcher("Orders");
			 rd.forward(request, response);
			 out.println("canceled" + hid + rooms + " " + order_id);
			 

			} catch (ClassNotFoundException | SQLException e) {}

	}

}
