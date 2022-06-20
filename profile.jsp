<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
.login-form {
    width: 540px;
    margin: 50px auto;
  	font-size: 20px;
  	box-shadow: 0px 2px 2px rgba(250, 0, 0, 1);
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
    color: white;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>

<style>
a:link {
  color: white;
  background-color: transparent;
  text-decoration: none;
}
a:visited {
  color: pink;
  background-color: transparent;
  text-decoration: none;
}
a:hover {
  color: red;
  background-color: transparent;
  text-decoration: underline;
}
a:active {
  color: yellow;
  background-color: transparent;
  text-decoration: underline;
}
</style>


</head>
<body>
<%ResultSet rs1 = (ResultSet)session.getAttribute("rs1");%>
<%rs1.next();%>
<%String username = rs1.getString("name");%>
<table style="width:100%">
  <tr>
  <td><form action="Hotels" method="get"><div align="left"><h3><button type = "submit" class="btn btn-warning">Home</h3></div></form></td>
    <td><div class="login-form" align="center"><h2>Welcome <%out.println(username); %></h2></div></td>
    <td><div class="profile-form" align="right"><form action="Profile"><h3><button type = "submit" class="btn btn-success">Profile</button></h3></form>
	<form action="LogOut" method="post"><h3><button type = "submit" class="btn btn-danger">Logout</h3></form></div></td>
  </tr>
</table><br>
<form action="Hotels"><button type="submit" class="btn btn-secondary">back</button></form>

<style>
table, th, td {
  border-bottom::1px solid #ddd;
    background-color: rgba(40, 0, 10, 0.5);
}
</style>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Customer Info</a>
  
</nav>

<font color="white">
<div class="login-form">
<table style="width:100%"><tr><td>
<%out.println("Username: " + username);%><br>
<%String country = rs1.getString("country");%>
<%out.println("Country: " + country);%><br>
<%String email = rs1.getString("email");%>
<%out.println("Email-ID : " + email);%><br>
<%long ph_num = rs1.getLong("ph_number");%>
<%out.println("Mobile Number: " + ph_num);%>
</td></tr></table>
</div>

<div class="login-form">
<table style="width:100%"><tr><td>
<a href="Orders">Show My Bookings</a>
</td></tr></table>
</div>
</font>


<div class="login-form">
<table style="width:100%"><tr><td>
<a href="History">Show History</a>
</td></tr></table>
</div>
</font>


           
</body>
</html>