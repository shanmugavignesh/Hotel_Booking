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
  	font-size: 19px;
  	margin: 50px auto;
  	background-color: 0px 2px 2px rgba(250, 0, 0, 1);
  	box-shadow: 0px 2px 2px rgba(250, 0, 0, 1);
}
.search-form {
    width: 540px;
  	font-size: 19px;
  	margin: 50px auto;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
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
  color: white;
  background-color: transparent;
  text-decoration: none;
}
a:hover {
  color: blue;
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


<img border="0" src="https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8aG90ZWx8ZW58MHx8MHx8&w=1000&q=80"
     alt="Pulpit rock" width="1705" height="328">

<style>
table, th, td {
  border-bottom: 1px solid #ddd;
    background-color: rgba(40, 0, 10, 0.5);
}
</style>
<table style="width:100%">
  <tr>
  <td><form action="Hotels" method="get"><div align="lest"><h3><button type = "submit" class="btn btn-warning">Home</h3></div></form>
    <td><font color="white"><h3><div align="center">Book Your Rooms!</div></h3></font></td>
    <td><div class="profile-form" align="right"><form action="Profile"><h3><button type = "submit" class="btn btn-success">Profile</button></h3></form>
	<form action="LogOut" method="post"><h3><button type = "submit" class="btn btn-danger">Logout</h3></form></div></td>
  </tr>
</table><br>

<div class="search-form" align="center">
<form action="Find" method="get">
	<div class="form-group">
    	<input type="text" class="form-control" name="search" placeholder="search hotel by name">
    </div>
    <div class="form-group" align="center">
    	<button type="submit" class="btn btn-secondary">search</button>
    </div>
</form>
</div>

<h2>

<c:forEach var="hotel" items="${hotel}">
 <div class="login-form">
 	<table style="width:100%"><tr><td>
    <a href="ShowHotel?hid=${hotel.hotel_id}"><c:out value="${hotel.hotel_name}" /><br></a>
    <font color="white"><%out.println("Location : ");%><c:out value="${hotel.location}" /><br></font>
    <c:choose>
   <c:when test="${hotel.rooms > 0}"><font color="green"><%out.println("ROOMS AVAILABLE");%></font></c:when>
    <c:otherwise><font color="green"><%out.println("ALL ROOMS BOOKED!");%></font></c:otherwise>
</c:choose>
</td></tr></table>

 </div><br>
 
</c:forEach>


	</h2>
</body>
</html>