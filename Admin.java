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
@WebServlet("/Admin")
public class Admin extends HttpServlet { 
	Customer c;
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://localhost:3306/hotel";

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		 HttpSession session=req.getSession();
		
		String n = req.getParameter("username");
		String p = req.getParameter("password");
		
		 session.setAttribute("username", n);
		 session.setAttribute("password", p);

		 PrintWriter out = res.getWriter();
			try {
				 

				if(AdminDao.validate(n,p)) {
					System.out.println("inside");
					out.println("logined");
					RequestDispatcher rd = req.getRequestDispatcher("AdminMain.html");
					rd.forward(req,  res);
					
				}
			} catch (Exception e) {}
			

	}
  }