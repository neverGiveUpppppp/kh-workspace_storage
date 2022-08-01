<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ b.bId }번 글 상세보기</title>
<style>
	.outer {
		width: 900px; height: auto; margin-left: auto; margin-right: auto; 
		margin-top: 50px; margin-bottom: 50px; padding-bottom: 50px;
	}
	#detailContent {width: 800px; height: 350px;}
	.detailTable{margin: auto; text-align: center;}
	.detailTable th{border-bottom: 3px solid lightgray;}
	.detailTable td{border-bottom: 1px solid lightgray;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h1 align="center">게시판 상세보기</h1>
		<table id="detailContent" class="detailTable">
			<tr>
				<td width="100px">글 번호</td>
				<td><b>${ b.bId }</b></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><b>${ b.bTitle }</b></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><b>${ b.nickName }</b></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><b>${ b.bCount }</b></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><b>${ b.bCreateDate }</b></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><p style="height:100px;"><b>${ b.bContent }</b></p></td>
			</tr>
		</table>

		<br>
		
		<!-- 댓글 등록 부분 -->
		<table class="detailTable">
			<tr>
				<td>
					<textarea cols="80" rows="5"></textarea>
				</td>
				<td>
					<button>등록하기</button>
				</td>
			</tr>
			<tr>
				<td colspan="2"><b>댓글(${ rCount })</b>
			</tr>
		</table>
		
		<!-- 댓글 출력 부분 -->
		<c:if test="${ rCount > 0 }">
			<table class="detailTable">
				<c:forEach var="r" items="${ b.replyList }">
					<tr>
						<td width="100px">${ r.nickName }</td>
						<td width="400px">${ r.rContent }</td>
						<td width="150px">${ r.rCreateDate }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>