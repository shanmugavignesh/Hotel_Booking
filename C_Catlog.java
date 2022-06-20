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
@WebServlet("/C_Catlog")
public class C_Catlog extends HttpServlet{
	Connection con=null;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
					System.out.println("hotels");
			    try {
					Class.forName("com.mysql.cj.jdbc.Driver");
			    String url = "jdbc:mysql://localhost:3306/musicapp";  
					con=DriverManager.getConnection(url,"root","root");
				PreparedStatement ps;
					ps = con.prepareStatement("select * from music");
				ResultSet rs;
					rs = ps.executeQuery();
				PrintWriter out = response.getWriter();
				out.println("hotels");
				session.setAttribute("rs", rs);
				System.out.println("catlog");
				RequestDispatcher rd = request.getRequestDispatcher("C_catlog.jsp");
				rd.forward(request, response);
			    }catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
	}
}
