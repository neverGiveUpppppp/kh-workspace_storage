<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h2>주문 내역</h2>
	상품명 : ${ param.pname }<br>
	수량 : ${ param.pcount }<br>
	옵션1 : ${ paramValues.option[0] }<br> <!-- 같은거를 여러개 가지고 올거면 pramValues -->
	옵션2 : ${ paramValues.option[1] }<br> <!-- 같은거를 여러개 가지고 올거면 pramValues -->


</body>
</html>
