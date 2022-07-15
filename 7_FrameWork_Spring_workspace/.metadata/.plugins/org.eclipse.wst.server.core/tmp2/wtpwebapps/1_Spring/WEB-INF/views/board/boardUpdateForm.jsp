<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#boardUpdateTable{margin: auto; border-collapse: collapse; border-left: hidden; border-right: hidden;}
	#boardUpdateTable tr td{padding: 5px;}
</style>
</head>
<body>
	<c:import url="../common/menubar.jsp"/>
	
	<h1 align="center">게시글 수정</h1>
	
	<!-- 첨부파일도 수정 할 수도 있으니 Multipart/form-data encType 지정 -->
	<form action="bupdate.bo" method="post" enctype="Multipart/form-data">
		<input type="hidden" name="page" value="${ page }">
		<input type="hidden" name="boardId" value="${ board.boardId }">
		<input type="hidden" name="renameFileName" value="${ board.renameFileName }"> <!-- renameFileName은 이 게시글이 가지고있었던 파일. 강의 6.10 3:12  -->
						<%--<!-- renameFileName 안에는 게시물에 올린 파일의 수정된 이름이 들어가있음. 
						value ="${ board.renameFileName} 에 값이 있다? 수정할 게시물에 파일이 존재
						수정할 파일이 있는지 다른 확인방법 : 오리진파일네임으로도 확인가능
							아래  c:if test= "${ !empty board.originalFileName }" 도   -->--%>
							
						 
		<table id="boardUpdateTable" border="1">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" size="80" name="boardTitle" value="${ board.boardTitle }">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" readonly value="${ board.nickName }" style="background: lightgrey;">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="80" name="boardContent">${ board.boardContent }</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="reloadFile">  <!-- name="reloadFile" : 수정하면서 넣을 파일의 정보를 가지고 있음 -->
					<c:if test="${ !empty board.originalFileName }">
						<br>현재 업로드한 파일 : 
						<a href="${ contextPath }/resources/buploadFiles/${ board.renameFileName }" download="${ board.originalFileName }">
							${ board.originalFileName }
						</a>
					</c:if>
					<br>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기"> &nbsp;
					<c:url var="blist" value="blist.bo">
						<c:param name="page" value="${ page }"/>
					</c:url>
					<button type="button" onclick="location.href='${ blist }'">목록으로</button>
					<button type="button" onclick="location.href='javascript:history.go(-1);'">이전페이지로</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>