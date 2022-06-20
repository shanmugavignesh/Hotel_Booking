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
@WebServlet("/Login")
public class Login extends HttpServlet { 
	Customer c;
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://localhost:3306/hotel";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		 HttpSession session=req.getSession();
		
		String n = req.getParameter("username");
		String p = req.getParameter("password");
		
		
		 session.setAttribute("username", n);
		 session.setAttribute("password", p);

		 PrintWriter out = res.getWriter();
			try {
				 System.out.println("insideLogin");

				if(LoginDao.validate(n,p)) {
					System.out.println("logined");
					
					out.append('1');
					//RequestDispatcher rd = req.getRequestDispatcher("Hotels");
					//rd.forward(req,  res);
					
				}
				else {
					System.out.println("failed");
					out.append("0");
				}
			} catch (Exception e) {}
			

	}
  }
