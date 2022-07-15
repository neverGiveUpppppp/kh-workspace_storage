<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title> jsp/today.jsp </title>



</head>
<body>

	<%
		Date now = new Date();
		String today = String.format("%tY년 %tm %td일 %tA", now, now, now, now);
	
	%>
	
	<%= today %>

</body>
</html>


