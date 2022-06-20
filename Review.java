package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Review")
public class Review extends HttpServlet { 
	Customer c;
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://localhost:3306/hotel";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		String hid= (String)session.getAttribute("hid");
		String username= (String)session.getAttribute("username");
		System.out.println(username);
		Connection con = null;
		String comments= request.getParameter("cmts");
		int ratings= Integer.parseInt(request.getParameter("ratings"));
		try {
			
			LoginDao.review(hid,username,comments,ratings);

		
		 PrintWriter out = response.getWriter();
		 RequestDispatcher rd = request.getRequestDispatcher("Hotels");
		 rd.forward(request, response);
		 
		 session.removeAttribute("hid");
			} catch (Exception e) {}
			

	}
  }