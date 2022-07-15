<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.outer{
		width:900px; min-height:50px; padding-bottom: 50px;
		margin-left:auto; margin:auto; margin-top:50px; margin-bottom: 50px; 
	}
	#boardTable{text-align:center; margin: auto; width: 900px;}
	#boardTable th{border-bottom: 3px solid lightgray;}
	#boardTable td{border-bottom: 1px solid lightgray;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
		
	<!------------- 0_1.로그인한 회원만 게시물 보기를 하기 위해 다음과같은 조건 추가  -------------->
	<c:if test="${ !empty loginUser }"> <!-- ${loginUser != null}도 가능 -->
		<div class="outer">
			<br>
			<h1 align="center">게시판</h1>
						
			<!---------------- 1. 게시물 리스트 ------------------>
			<!-- 1_1. 게시물 리스트 보기  -->
			<table id="boardTable">
				<tr>
					<th>글 번호</th>
					
					<th>제목 </th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
				
				<!-- forEach를 통해 request에 담겨있는 list들을 하나씩 접근하여 출력 -->
				<c:forEach items="${ list }" var="b">
					<tr>
						<td>${ b.bId }</td>
						<td>${ b.bTitle }</td>
						<td>${ b.nickName }</td>
						<td>${ b.bCount }</td>
						<td>${ b.bCreateDate }</td>
					</tr>
				</c:forEach>
 
<%--				c:foreach begin, end 방법
					<c:forEach begin="0" end="${ list.size()-1 }" var="i">
						<tr>
							<td>${list.get(i).bId}</td>
							<td>${list.get(i).bTitle}</td>
							<td>${list.get(i).bCount}</td>
							<td>${list.get(i).bCreateDate}</td>
						</tr>
					-1 안하면 outofbounds 뜰 것임
					el로는 size못씀. 자바가 아니기 때문. 쓸 수 있는게 한정적					--%>
			</table>
			
			
			
			<!-- 1_2. 게시물 리스트 페이징 부분 -->
			<div class="pagingArea" align="center">
				<!-- [이전] -->
				<c:if test="${ pi.currentPage <= 1 }">[이전]</c:if> <!-- <!-- 1보다 작거나 같으면 버튼 활성화 --> 
				<c:if test="${ pi.currentPage > 1 }"> <!-- 1보다 크면 버튼 활성화 -->
					<!-- 방법1 -->
					<%-- <a href="${contextPath}/selectList.bo?currentPage=${pi.currentPage -1 }">[이전]</a> --%>
						<!-- 웹페이지 주소창에  ?currentPage=1 혹은 다른 숫자 2,3 넣어서 버튼활성화여부 확인-->
					<!-- 방법2 -->
					<c:url value="${ loc }" var="blistBack"> <!-- selectList.bo 앞에 컨텍스트패쓰 넣어도되고 안넣어도 되고 -->
				<%-- <c:url value="selectList.bo" var="blistBack">  --%>	
						<!-- c:url value="${ loc} loc란 현재 가지고 있는 컨텍스트패스까지 의미(?) 강의 3:02 -->
						<c:param name="currentPage" value="${pi.currentPage - 1 }"/> 
						<!-- url을 통해 보내야할 곳이 c:url value=""통해 지정한 selectList.bo고,
							c:param의 name속성을 통해 받을 데이터를 currentPage으로 지정해주고 value로 어떤 값을 보낼지 정함 
						  -->
						<c:if test="${condition ne null }">  <!-- 이부분이 c:url에 다 들어가면 됨 -->
							<c:param name="searchCondition" value="${ condition }"/>
							<c:param name="searchValue" value="${ value }"/>
						</c:if>	
					</c:url>
					<a href="${ blistBack }">[이전]</a>
				</c:if>
				
				<!-- 번호버튼 -->
				<c:forEach begin="${pi.startPage }" end="${pi.endPage }" var="p">
					<c:if test="${ p eq pi.currentPage }">
						<font color="red" size="4"><b>[${ p }]</b></font> <!-- 강의 3:08 -->
					</c:if>
					<c:if test="${p ne pi.currentPage}">
						<c:url var="blistNum" value="${loc}">
							<c:param name="currentPage" value="${p}"/>
							<c:if test="${condition ne null }">  <!-- 이부분이 c:url에 다 들어가면 됨 -->
							<c:param name="searchCondition" value="${ condition }"/>
							<c:param name="searchValue" value="${ value }"/>
						</c:if>	
						</c:url>
						<a href="${ blistNum }">${ p }</a>
					</c:if>
				</c:forEach>
				
				
				<!-- [다음] -->
				<c:if test="${ pi.currentPage >= pi.maxPage }">[다음]</c:if> <!-- <!-- 1보다 작거나 같으면 버튼 활성화 --> -->
				<c:if test="${ pi.currentPage < pi.maxPage }">
					<c:url value="${ loc }" var="blistNext">
						<c:param name="currentPage" value="${pi.currentPage + 1 }"/>
						<c:if test="${condition ne null }">  <!-- 이부분이 c:url에 다 들어가면 됨 -->
						<c:param name="searchCondition" value="${ condition }"/>
						<c:param name="searchValue" value="${ value }"/>
						</c:if>	
					</c:url>
					<a href="${ blistNext }">[다음]</a>
				</c:if>
			</div>
			
			<!-----------  2. 상세보기 ------------->
			<script type="text/javascript">
				$(function(){
					$("#boardTable").find("td").mouseenter(function(){
						$(this).parents("tr").css({"background":"black", "color":"white", "cursor":"pointer"});
					}).mouseout(function(){
						$(this).parents("tr").css({"background":"none", "color":"black"});
					}).click(function(){
						var bId=$(this).parents().children("td").eq(0).text();
	
						location.href="selectOne.bo?bId="+bId;
					});
				});
			</script>
		</div>
	</c:if>
	
	<!-------------- 0_2. 로그인하지 않은경우 ---------------->
	<c:if test="${empty loginUser }">
		<c:set var="message" value="로그인이 필요한 서비스입니다." scope="request"/>
		<jsp:forward page="../common/errorPage.jsp"/>
	</c:if>
	
	<!---------------- 3. 게시물 검색 ------------------>
	<div id="searchArea" align="center">
		<label>검색 조건</label>
		<select id="searchCondition" name="searchCondition">
			<option>-------</option>
			<option value="writer">작성자</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		
		<input id="searchValue" type="search">
		<button onclick="searchBoard();">검색하기</button>
	</div>
	
	<script type="text/javascript">
		function searchBoard(){
			var searchCondition = $("#searchCondition").val();
			var searchValue = $("#searchValue").val();
			
			location.href="search.bo?searchCondition="+searchCondition+"&searchValue="+searchValue;
		}
	</script>
	
	
	
</body>
</html>