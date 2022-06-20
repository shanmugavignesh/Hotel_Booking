<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hi
<%ResultSet rs1 = (ResultSet)session.getAttribute("rs");%>
<%rs1.next();%>
<%String artist_name = rs1.getString("artist");%>

<font color="white">
<div class="login-form">
<table style="width:100%"><tr><td>
<%out.println("Artist: " + artist_name);%><br>
<%String album = rs1.getString("album");%>
<%out.println("Album: " + album);%><br>
</td></tr></table>
</div>

</body>
</html>