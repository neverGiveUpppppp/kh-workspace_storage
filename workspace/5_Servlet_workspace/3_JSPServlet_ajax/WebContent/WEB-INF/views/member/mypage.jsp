<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Member member = (Member)request.getAttribute("member"); //MyPageServlet에서 request.setAttribute("member", member);에서 받아온 "member"
	// Member에 대한 import 안했는데 문제가 없는 이유
	// include해서 이미 import 된게 있음
	// menubar.jsp에서 import를 공유하고 있기 때문에 문제가 없는 것
%>    



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width: 48%; height: 450px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 5%;
	}
	#myForm td {text-align: center;}
	#myForm>table{margin: auto;}
	#updateBtn {background: #D1B2FF; color: white;}
	#updatePwdBtn {background: #FFD8D8; color: white;}
	#deleteBtn {background: #D5D5D5; color: white;}
	#goMain {background: #B2CCFF; color: white;}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">내 정보 보기</h2>
		
		<form action="<%= request.getContextPath() %>/updateForm.me" method="post" id="myForm" name="myForm">
			<%-- <table>
				<tr>
					<td width="200px">아이디</td>
					<td width="200px"><%= member.getUserId() %><input type="text" maxlength="13" name="myId" required></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><%= member.getUserName() %><input type="text" name="myName" required></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><%= member.getNickName() %><input type="text" maxlength="15" name="myNickName" required></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<%= member.getPhone() == null ? "-" : member.getPhone() %> <!-- 삼항연산자 -->
						<input type="tel" maxlength="11" name="myPhone" placeholder="(-없이)01012345678">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><%= member.getEmail() == null ? "-" : member.getEmail()%><input type="email" name="myEmail"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><%= member.getAddress() == null ? "-" : member.getAddress() %><input type="text" name="myAddress"></td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<%= member.getInterest() == null ? "-" : member.getInterest()%> <!-- 아직 없는 데이터 같은 경우 대쉬-로 뜰것임 -->
					</td>
				</tr>
			</table>
			 --%>
			 
			 
			<!-- 회원정보 박스에 정보 미리 들어가게 있게하는 것
				쉬운 방법1,2말고 type="hidden" 써볼 것임 -->
			<table>
				<tr>
					<td width="200px">아이디</td>
					<td width="200px">
						<%= member.getUserId() %>   <!-- db에서 받아온 정보를 내정보보기에 보여주기 위한 코드  -->
						<input type="hidden" maxlength="13" name="myId" required value="<%= member.getUserId() %>">
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><%= member.getUserName() %> 
					<input type="hidden" name="myName" required value="<%= member.getUserName() %>">
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><%= member.getNickName() %>
					<input type="hidden" maxlength="15" name="myNickName" required value="<%= member.getNickName() %>">
					</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<%= member.getPhone() == null ? "-" : member.getPhone() %> <!-- 삼항연산자 -->
						<input type="hidden" name="myPhone" value="<%= member.getPhone() == null ? "-" : member.getPhone() %>">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<%= member.getEmail() == null ? "-" : member.getEmail()%>
						<input type="hidden" name="myEmail" value="<%= member.getEmail() == null ? "-" : member.getEmail() %>">>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<%= member.getAddress() == null ? "-" : member.getAddress() %>
						<input type="hidden" name="myAddress" value="<%= member.getAddress() == null ? "-" : member.getAddress() %>">
					</td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<%= member.getInterest() == null ? "-" : member.getInterest()%> <!-- 아직 없는 데이터 같은 경우 대쉬-로 뜰것임 -->
						<input type="hidden" name="myInterest" value="<%= member.getInterest() == null ? "-" : member.getInterest() %>">
			
					</td>
				</tr>
			</table>

			<br>
			
			<div class="myPageBtns" align="center">
				<input id="updateBtn" type="submit" value="수정하기">
				<input id="updatePwdBtn" type="button" value="비밀번호 변경 하기" onclick="location.href='updatePwdForm.me'">
				<input id="deleteBtn" type="button" value="탈퇴하기" onclick="deleteMember();">
				<input type="button" id="goMain" onclick="goToMain();" value="메인으로">
			</div>
		</form>
	</div>
	
	<script>
		function deleteMember(){
			// 정말 삭제할거냐고 물어본 후, 삭제하겠다고 하면 delete.me로 요청
			var bool = confirm('정말 탈퇴하시겠습니까');
			if(bool){
				
				location.href = '<%= request.getContextPath() %>/delete.me';
				// 또는
				<%-- $('#myForm').attr('action','<%= request.getContextPath() %>/delete.me'); --%>
				
				// $('#myForm').submit(); //
				// 어떤 방법으로 해도 괜찮음. 다만, 위처럼 attr로 진행하면 action이 바뀌어져 있는 상태이기 때문에
				// 수정하기를 눌러도 delete.me로 넘어감(주의!)
			}
		}
		function goToMain(){
			location.href="<%= request.getContextPath() %> ";
		}
		
	</script>
	
	
	
	
	
	
</body>
</html>