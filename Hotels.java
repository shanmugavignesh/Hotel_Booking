package servlet;


import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/Hotels")
public class Hotels extends HttpServlet{
	Connection con=null;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//			System.out.println("hotels");
		//	    Class.forName("com.mysql.cj.jdbc.Driver");
		//	    String url = "jdbc:mysql://localhost:3306/hotel";  
		//		con=DriverManager.getConnection(url,"root","root"); 
		//		
		//		PreparedStatement ps=con.prepareStatement("select * from hotels");  
		//		ResultSet rs=ps.executeQuery(); 
		//		PrintWriter out = response.getWriter();
		//		out.println("hotels");
		//		session.setAttribute("rs", rs);
		//		RequestDispatcher rd = request.getRequestDispatcher("new.jsp");
		//		rd.forward(request, response);
					ArrayList<Hotel> hotel = new ArrayList<Hotel>();
					hotel=LoginDao.hotels();
					request.setAttribute("hotel", hotel);
					RequestDispatcher rd = request.getRequestDispatcher("new.jsp");
					rd.forward(request, response);
	}
}