<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><font color="red">
<% String check = (String)request.getParameter("check");
out.println("please enter valid " + check);%>
</font></h3>
</body>
</html>