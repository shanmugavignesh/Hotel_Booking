package servlet;

import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;  // Import the File class
import java.io.IOException;
import java.io.PrintWriter;

class Dbs{
	static String url = "jdbc:mysql://localhost:3306/hotel";
	Connection con = null;
	int count = 1;
	public void insertOrder(String s1, String s2, String s3, String s4) throws Exception
	{
		con = DriverManager.getConnection(url, "root", "root");
		PreparedStatement st = con.prepareStatement("insert into order1 values(?,?,?,?)");
		
		String s = "insert into order1 values(?,?,?,?)";
		
		st.setString(1, s1);
		st.setString(2, s2);
		st.setString(3, s3);
		st.setString(4, s4);
		long in = System.currentTimeMillis();
		int n = st.executeUpdate();
		long out = System.currentTimeMillis() - in;
		
		
		st = con.prepareStatement("update query set count = ? where query_name = ?");
		st.setInt(1, count);
		st.setString(2, s);
		st.executeUpdate();
		count = count + 1;
		
		st.close();
		con.close();
		System.out.println(con.isClosed());
	}
	public int insertCustomer(String s1, String s2) throws Exception{
		
		con = DriverManager.getConnection(url, "root", "root");
		PreparedStatement st = con.prepareStatement("insert into customers values(?,?)");
		
		st.setString(1, s1);
		st.setString(2, s2);
		
		int i = st.executeUpdate();
		
		st.close();
		con.close();
		System.out.println(con.isClosed());
		return i;
	}
	public void showOrder() throws Exception {
		String q = "select * from order1";
		Connection co = DriverManager.getConnection(url, "root", "root");
		Statement st = co.createStatement();
		ResultSet rs = st.executeQuery(q);
		while(rs.next()) {
			System.out.println(rs.getString("order_id") +" " + rs.getString("customer_id") + " " + rs.getString("PG_name") + " " + rs.getString("PG_location") + "\n");
		}
		st.close();
		co.close();
		System.out.println(co.isClosed());
	}
	public void showCustomers() throws Exception {
		String q = "select * from customers";
		con = DriverManager.getConnection(url, "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(q);
		while(rs.next()) {
			System.out.println(rs.getString("customer_id") + " " + rs.getString("customer_name") + "\n");
		}
		st.close();
		con.close();
		System.out.println(con.isClosed());
	}
}

class Customer{
	private String name;
	static int id = 1000;
	String cusid;
	Scanner inp = new Scanner(System.in);
	Customer(String nme){
		name = nme;
		cusid = "OD" + id;
		id = id + 1;
	}
	void call(int n, PG h) throws Exception {
		switch(n) {
		case 1: h.book(cusid, 1);
		break;
		case 2: h.cancel(cusid);
		break;
		}
	}
}
class PG {
	private String name;
	private String location;
	int rooms;
	static int id = 1000;
	String orderid ;
	Dbs db = new Dbs();
	
	PG(String nme, String loc, int rms){
			name = nme;
			location = loc;
			rooms = rms;
	}
	void book(String cusid, int n) throws Exception {
		if(n < rooms) {
			rooms = rooms - n;
			orderid = "OD" + id;
			
			db.insertOrder(orderid, cusid, name, location);
			id = id + 1;
			System.out.println("Booking succussful!\n");
			
		}
		else if(rooms == 0) {
			System.out.println("All rooms are booked!");
		}
		else {
			System.out.print("invalid input!\n");
		}
	}
	void cancel(String cusid) {
		rooms = rooms - 1;
		System.out.println("Canceleed!");
	}
}
public class HelloWorld {
	
	static Customer c1 = new Customer("Bospandi");
	static Customer c2 = new Customer("Kopurundhevi");
	static Customer c3 = new Customer("veambuli");
	static Customer c4 = new Customer("Dhanalahkmi");
	static Customer c5 = new Customer("Vandumurugan");
	
	static PG h1 = new PG("Oyo", "Potheri", 20);
	static PG h2 = new PG("Residency Park", "Thambaram", 30);
	static PG h3 = new PG("Chetan chabuk", "Lailavaram",25);
	static PG h4 = new PG("Neelambari Veduthi", "Gunidy",24);
	

	public static void main(String[] args) throws Exception {
		int i = 1;
		Scanner inp = new Scanner(System.in);
		while(i <= 1) {
			System.out.println("Enter Customer id no : ");
			int cusid = inp.nextInt();
			System.out.println("Order/cancel(1/0) : ");
			int ch = inp.nextInt();
			switch(cusid) {
			case 1: c1.call(ch,h1);
			break;
			case 2: c2.call(ch,h2);
			break;
			case 3: c3.call(ch,h3);
			break;
			case 4: c4.call(ch,h4);
			break;
			case 5: c5.call(ch,h1);
			break;
			}
			i++;
		}
		Dbs db = new Dbs();
		db.showOrder();
		db.showCustomers();

	}

}
