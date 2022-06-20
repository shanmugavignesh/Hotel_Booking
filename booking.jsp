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
    width: 80px;
  	font-size: 20px;
}
.review-form {
    width: 80px;
  	font-size: 20px;
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
.login-form h3 {
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

<style>
/* Popup container - can be anything you want */
.popup {
  position: relative;
  display: inline-block;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* The actual popup */
.popup .popuptext {
  visibility: hidden;
  width: 160px;
  background-color: #555;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 8px 0;
  position: absolute;
  z-index: 1;
  bottom: 125%;
  left: 50%;
  margin-left: -80px;
}

/* Popup arrow */
.popup .popuptext::after {
  content: "";
  position: absolute;
  top: 100%;
  left: 50%;
  margin-left: -5px;
  border-width: 5px;
  border-style: solid;
  border-color: #555 transparent transparent transparent;
}

/* Toggle this class - hide and show the popup */
.popup .show {
  visibility: visible;
  -webkit-animation: fadeIn 1s;
  animation: fadeIn 1s;
}

/* Add animation (fade in the popup) */
@-webkit-keyframes fadeIn {
  from {opacity: 0;} 
  to {opacity: 1;}
}

@keyframes fadeIn {
  from {opacity: 0;}
  to {opacity:1 ;}
}
</style>

</head>
<body>
<table style="width:100%"><tr><td>
<img border="0" src="https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8aG90ZWx8ZW58MHx8MHx8&w=1000&q=80"
     alt="Pulpit rock" width="1705" height="328"></td></tr></table>
<table style="width:100%">
  <tr>
  <td><form action="Hotels" method="get"><div align="lest"><h3><button type = "submit" class="btn btn-warning">Home</h3></div></form></td>
    <td><div align="center"><font color=white><h2>Welcome</h2></font></div></td>
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


<c:forEach var="hotel" items="${hotel}">
<div class="hotel-info">
<font color="white">
<table style="width:100%"><tr><td>
<h3>
    <%out.println("Hotel Name: "); %><c:out value="${hotel.hotel_name}" /><br>
    <%out.println("Location : ");%><c:out value="${hotel.location}" /><br>
    <%out.println("Contact Number: ");%><c:out value="${hotel.contact_num}" /><br>
    </h3></td>
    <td>
    <c:choose>
   <c:when test="${hotel.rooms > 0}">
   <strong><%out.println("COST(per room): $"); %><c:out value="${hotel.price}" /><br></strong>
   <font color="green"><%out.println("Status: ROOMS AVAILABLE");%></font><br>
   <%out.println("Available Rooms: ");%><c:out value="${hotel.rooms}" /><br>
   <form action="Booking">
   <input type=number name="wanted_rooms" placeholder = "Rooms Wanted"><br>
   <div class="login-form"><button type="submit" class="btn btn-primary btn-block">book</button>
   </div></form>
   </c:when>
    <c:when test="${hotel.rooms == 0}"><font color="red"><%out.println("ROOMS UNAVAILABLE!");%></font></c:when>
</c:choose>
</td></tr></table>
</font>

 </div><br>
 
</c:forEach>

<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">
    comments
  </a>
</nav>
<c:forEach var="reviews" items="${reviews}">
<div>
	<div align="center"><%out.println("_________________________________________________________________________________________________________________________"); %></div><br>
   <h4><c:out value="${reviews.username}" /></h4><br>
   <h6><c:out value="${reviews.comments}" /><br>
    <%out.println("Ratings: ");%><c:out value="${reviews.ratings}" /></h6><br>
	<div align="center"><%out.println("_________________________________________________________________________________________________________________________"); %></div>
 </div><br>
 
</c:forEach>

<div>


<form action="Review"><%out.println("Your comments");%><br>
<textarea id="cmts" name="cmts" rows="2" cols="33">add comments</textarea><br>
<input type="text" name="ratings" placeholder="ratings">
<button type="submit">add comment</button><br>

</form> 
</div>
<p>     




</p>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function loginBtn()
{
	 var username = $("#username").val();
     var password = $("#password").val();
     console.log(username)

     if( username != "" && password != "" ){
     	let link='http://localhost:8080/Demo/Booking?username='+username+'&password='+password
     	console.log(link)
     	var xhttp = new XMLHttpRequest();
         var aa=$.ajax({
             url:link,
             type:'GET',
         
             success:function(response){
             	console.log(response)
                 var msg = "";
                 if(response == "1"){
                    alert("success")
                   console.log("demo")
                    window.location="/Demo/Hotels";
                 }else{
                     alert("Invalid username and password!");
                     xhttp.onreadystatechange = function() {
         				 document.getElementById("Demo").innerHTML = this.responseText;
      					};
      					xhttp.open("GET", "NewFile.html", true);
     					 xhttp.send();
                 }
             }
         
         });
     }
     else{
    	 alert("Enter Username/Password");
     }
}
</script>

</body>
</html>