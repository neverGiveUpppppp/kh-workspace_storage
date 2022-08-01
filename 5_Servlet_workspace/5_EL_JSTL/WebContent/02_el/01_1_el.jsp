<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
<style>.item{font-weight: bold; color: yellowgreen;}</style>
</head>
<body>
	<form action="<%= request.getContextPath() %>/myEL.do" method="post">
		<h2>개인정보 입력</h2>
		이름 : <input type="text" name="name" id="name"><br>
		성별 : <input type="radio" name="gender" value="남">남자
			  <input type="radio" name="gender" value="여">여자<br>
		나이 : <input type="text" name="age">
		
		<hr>
		
		<h2>당신이 가장 좋아하는 ____은?</h2>
		
		<span class="user">OOO</span>님이 가장 좋아하는 <span class="item">음료</span>는? 
		<input type="text" name="beverage"><br>
		
		<span class="user">OOO</span>님이 가장 좋아하는 <span class="item">물건1</span>은? 
		<input type="text" name="product"><br>
		
		<span class="user">OOO</span>님이 가장 좋아하는 <span class="item">물건2</span>는? 
		<input type="text" name="product"><br>
		
		<span class="user">OOO</span>님이 가장 좋아하는 <span class="item">물건3</span>은? 
		<input type="text" name="product"><br>
		
		<span class="user">OOO</span>님이 가장 좋아하는 <span class="item">책</span>은? 
		<input type="text" name="book"><br>
		
		<span class="user">OOO</span>님이 가장 좋아하는 <span class="item">영화</span>는? 
		<input type="text" name="movie"><br>
		
		<br>
		
		<input type="submit" value="전송">
	</form>
	
	
	
	<script>
		window.onload = function(){
			var name = document.getElementById("name");
			name.addEventListener("blur", function(){
				var user = document.getElementsByClassName("user");
				for(var i = 0; i < user.length; i++){
					user[i].innerText = name.value;
				}
			});
		}
	</script>
	
</body>
</html>

