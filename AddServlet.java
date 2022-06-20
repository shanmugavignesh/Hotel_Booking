package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

  //@WebServlet("/add")

public class AddServlet extends HttpServlet { 

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		 
		int r1 = Integer.parseInt(req.getParameter("username"));
		int r2 = Integer.parseInt(req.getParameter("password"));
		 PrintWriter out = res.getWriter();
		 out.println("result is : " + (r1+r2));
	}
  }