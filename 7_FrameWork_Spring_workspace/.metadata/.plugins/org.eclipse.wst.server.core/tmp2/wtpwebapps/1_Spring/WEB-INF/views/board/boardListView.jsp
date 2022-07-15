<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#tb{margin: auto; width: 700px; border-collapse: collapse;}
	#tb tr td{padding: 5px;}
	#buttonTab{border-left: hidden; border-right: hidden;}
</style>
</head>
<body>
	<c:import url="../common/menubar.jsp"/>
	
	<h1 align="center">게시글 목록</h1>
	
	<h3 align="center">총 게시글 갯수 : ${ pi.listCount }</h3>
	
	<table border="1" id="tb">
		<tr style="background: yellowgreen;">
			<th>번호</th>
			<th width="300">제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>첨부파일</th>
		</tr>
		<c:forEach var="b" items="${ list }"> <!-- items="${list}의 list는 컨트롤러에서 보낸 데이터값의 속성명 -->
<!-- 수업자료 변경코드 -->
		<tr class="contentTr">
			<td align="center">${ b.boardId }</td> <!-- b. b는 위의 var="b" -->
			<td align="left">${ b.boardTitle }</td> <!-- vo Board클래스의 boardId를 쓸 수 있는 이유:콘트롤러에서 list를 보낼 때 이 list에 담겨있는게 Board이기 때문  --> 
			<td align="center">${ b.nickName }</td>
			<td align="center">${ b.boardCreateDate }</td>
			<td align="center">${ b.boardCount }</td>
			<td align="center">
			<td align="left">
<%-- 				<c:if test="${ !empty loginUser }">
					<c:url var="bdetail" value="bdetail.bo">
						<c:param name="bId" value="${ b.boardId }"/>
						<c:param name="page" value="${ pi.currentPage }"/>
					</c:url>
					<a href="${ bdetail }">${ b.boardTitle }</a>
				</c:if> --%>
	
				<c:if test="${ ! empty b.originalFileName }">
					◎
				</c:if>
			</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="6" align="right" id="buttonTab">
				<c:if test="${ !empty loginUser }">
					&nbsp; &nbsp; &nbsp;
					<button onclick="location.href='binsertView.bo';">글쓰기</button>
				</c:if>
			</td>
		</tr>
		
		<!-- 페이징 처리 -->
		<tr align="center" height="20" id="buttonTab">
			<td colspan="6">
			
				<!-- [이전] -->
				<c:if test="${ pi.currentPage <= 1 }">
					[이전] &nbsp;		<!-- 1페이지에서만 나오는 기호 설정. 마찬가지로 마지막페이지에서 나오는 기호도 따로 지정해줘야함 -->
				</c:if>
				<c:if test="${ pi.currentPage > 1 }">
					<c:url var="before" value="blist.bo">
						<c:param name="page" value="${ pi.currentPage - 1 }"/>
					</c:url>
					<a href="${ before }">[이전]</a> &nbsp;
				</c:if>
				
				<!-- 페이지 -->
				<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
					<c:if test="${ p eq pi.currentPage }">
						<font color="red" size="4"><b>[${ p }]</b></font>
					</c:if>
					
					<c:if test="${ p ne pi.currentPage }">
						<c:url var="pagination" value="blist.bo">
							<c:param name="page" value="${ p }"/> 	<!-- 현재페이지가 지워지는 문제 화면에서  -->
						</c:url>
						<a href="${ pagination }">${ p }</a> &nbsp;
					</c:if>
				</c:forEach>
				
				<!-- [다음] -->
				<c:if test="${ pi.currentPage >= pi.maxPage }">
					[다음]		<!-- 마지막 페이지에서만 나오는 기호 설정. 마찬가지로 첫페이지에서 나오는 기호도 따로 지정해줘야함 -->
				</c:if>
				<c:if test="${ pi.currentPage < pi.maxPage }">
					<c:url var="after" value="blist.bo">
						<c:param name="page" value="${ pi.currentPage + 1 }"/>
					</c:url> 
					<a href="${ after }">[다음]</a>
				</c:if>
			</td>
		</tr>
	</table>
	<script>
	// 테이블 중에서 find 후손을 찾겠다. 마우스가 들어가있으면 그 tb에서 하나위로 올라가고(tr까지) tr에 대해서 백그라운드를 변경 
		$('.contentTr').find("td").mouseenter(function() {
			$(this).parent().css({'background':'rgba(0, 100, 0, 0.5)', 'color': 'white', 'cursor': 'pointer' });
		}).mouseout(function(){
			$(this).parent().css({'background':'none', "color":"black"});
		}).click(function() {
			var bId = $(this).parent().children('td').eq(0).text();
			location.href = 'bdetail.bo?bId=' + bId + "&page=" + ${pi.currentPage};
		});	
	</script>

	
	
</body>
</html>

<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #tb{margin: auto; width: 700px; border-collapse: collapse;}
   #tb tr td{padding: 5px;}
   #buttonTab{border-left: hidden; border-right: hidden;}
</style>
</head>
<body>
   <c:import url="../common/menubar.jsp"/>
   
   <h1 align="center">게시글 목록</h1>
   
   <h3 align="center">총 게시글 갯수 : ${ pi.listCount }</h3>
   
   <table border="1" id="tb">
      <tr style="background: yellowgreen;">
         <th>번호</th>
         <th width="300">제목</th>
         <th>작성자</th>
         <th>날짜</th>
         <th>조회수</th>
         <th>첨부파일</th>
      </tr>
      <c:forEach var="b" items="${ list }">
<!-- 수업자료 변경코드 -->
      <tr class="contentTr">
         <td align="center">${ b.boardId }</td>
         <td align="left">${ b.boardTitle }</td>
         <td align="center">${ b.nickName }</td>
         <td align="center">${ b.boardCreateDate }</td>
         <td align="center">${ b.boardCount }</td>
         <td align="center">
         <td align="left">
            <c:if test="${ !empty loginUser }">
               <c:url var="bdetail" value="bdetail.bo">
                  <c:param name="bId" value="${ b.boardId }"/>
                  <c:param name="page" value="${ pi.currentPage }"/>
               </c:url>
               <a href="${ bdetail }">${ b.boardTitle }</a>
            </c:if>
   
            <c:if test="${ ! empty b.originalFileName }">
               ◎
            </c:if>
         </td>
      </tr>
      </c:forEach>
      
      <tr>
         <td colspan="6" align="right" id="buttonTab">
            <c:if test="${ !empty loginUser }">
               &nbsp; &nbsp; &nbsp;
               <button onclick="location.href='binsertView.bo';">글쓰기</button>
            </c:if>
         </td>
      </tr>
      
      <!-- 페이징 처리 -->
      <tr align="center" height="20" id="buttonTab">
         <td colspan="6">
         
            <!-- [이전] -->
            <c:if test="${ pi.currentPage <= 1 }">
               [이전] &nbsp;
            </c:if>
            <c:if test="${ pi.currentPage > 1 }">
               <c:url var="before" value="blist.bo">
                  <c:param name="page" value="${ pi.currentPage - 1 }"/>
               </c:url>
               <a href="${ before }">[이전]</a> &nbsp;
            </c:if>
            
            <!-- 페이지 -->
            <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
               <c:if test="${ p eq pi.currentPage }">
                  <font color="red" size="4"><b>[${ p }]</b></font>
               </c:if>
               
               <c:if test="${ p ne pi.currentPage }">
                  <c:url var="pagination" value="blist.bo">
                     <c:param name="page" value="${ p }"/>
                  </c:url>
                  <a href="${ pagination }">${ p }</a> &nbsp;
               </c:if>
            </c:forEach>
            
            <!-- [다음] -->
            <c:if test="${ pi.currentPage >= pi.maxPage }">
               [다음]
            </c:if>
            <c:if test="${ pi.currentPage < pi.maxPage }">
               <c:url var="after" value="blist.bo">
                  <c:param name="page" value="${ pi.currentPage + 1 }"/>
               </c:url> 
               <a href="${ after }">[다음]</a>
            </c:if>
         </td>
      </tr>
   </table>
   <script>
   // 테이블 중에서 find 후손을 찾겠다. 마우스가 들어가있으면 그 tb에서 하나위로 올라가고(tr까지) tr에 대해서 백그라운드를 변경 
      $('.contentTr').find("td").mouseenter(function() {
         $(this).parent().css({'background':'rgba(0, 100, 0, 0.5)', 'color': 'white', 'cursor': 'pointer' });
      }).mouseout(function(){
         $(this).parent().css({'background':'none', "color":"black"});
      }).click(function() {
         var bId = $(this).parent().children('td').eq(0).text();
         location.href = 'bdetail.bo?bId=' + bId + "&page=" + ${pi.currentPage};
      });   
   </script>

   
   
</body>
</html> --%>