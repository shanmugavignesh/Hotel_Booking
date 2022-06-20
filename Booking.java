package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
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


@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	int status = 1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("status", status);
		String hid= (String)session.getAttribute("hid");
		String userid= (String)session.getAttribute("username");
		PrintWriter out = response.getWriter();
		try {
			
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    String url = "jdbc:mysql://localhost:3306/hotel";  
		con=DriverManager.getConnection(url,"root","root"); 
		
		PreparedStatement ps=con.prepareStatement("select rooms,total_rooms from hotels where ht_id = ?");  
		ps.setString(1,hid); 
		ResultSet rs=ps.executeQuery(); 
		rs.next(); 
		int rooms = rs.getInt("rooms");
		int total_rooms = rs.getInt("total_rooms");
		int n = Integer.parseInt(request.getParameter("wanted_rooms"));
		//int n=10;
		System.out.println(n);
		if(n > rooms || n==0) {
			status = 0;
			session.setAttribute("status", status);
			//out.append("0");
			//RequestDispatcher rd = request.getRequestDispatcher("bookavailable.jsp");
			//rd.forward(request, response);
		}
		else {
		ps = con.prepareStatement("update hotels set rooms = ? where ht_id = ?");
		ps.setInt(1, (rooms-n));
		ps.setString(2, hid);
		ps.executeUpdate();
		
		
		ps = con.prepareStatement("insert into bookings (username, hotel_id, booked, date_and_time) values(?,?,?,now())");
		ps.setString(1, userid);
		ps.setString(2, hid);
		ps.setInt(3, n);
		int i = ps.executeUpdate();
		System.out.println("booked" + i);
		}
		
		 RequestDispatcher rd = request.getRequestDispatcher("bookavailable.jsp");
		// RequestDispatcher rd = request.getRequestDispatcher("Hotels");
		 rd.forward(request, response);
		// out.println("booking confromed");
		 
		 session.removeAttribute("hid");
		 out.append("1");
	
		 

		} catch (ClassNotFoundException | SQLException e) {}

	}

}
