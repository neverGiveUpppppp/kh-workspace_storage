<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, notice.model.vo.Notice"%> <!-- import추가 -->
    
<% ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");%>
    
<!-- 위에서 에러가 떴던 이유-->
<!--  앞에꺼는 임포트가 안되서고, 뒤에꺼는 다형성에 맞지 않기 떄문에 import상속이 안되서 그런것 -->    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<style type="text/css">
   .outer{
      width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
      margin-left: auto; margin-right: auto; margin-top: 50px;
   }
   #listArea{text-align: center;}
   .tableArea{width:650px; height:350px; margin:auto;}
   th{border-bottom: 1px solid grey;}
   #writeNoBtn{background: #B2CCFF;}
</style>
</head>
<body>
   <%@ include file="../common/menubar.jsp" %>
   
   <div class="outer">
      <br>
      <h2 align="center">공지사항</h2>
      <div class="tableArea">
         <table id="listArea">	<!-- $('#listArea td')의 아이디 -->
            <tr>
               <th>글번호</th>
               <th width="300px">글제목</th>
               <th width="100px">작성자</th>
               <th>조회수</th>
               <th width="100px">작성일</th>
            </tr>
            <% if(list.isEmpty()){ %> <!-- 공지사항 데이터가 존재x 경우 -->
            <tr>
               <td colspan="5">존재하는 공지사항이 없습니다.</td>
            </tr>

				
				<!--	구조 : for each문  
						
						for (type var: iterate반복) {
	 						   body-of-loop
						} 
				-->
            <% } else { %> <!-- 공지사항 데이터가 존재o 경우 -->
            		<!-- For each문 -->
                  <% for(Notice n : list){ %>	
                     <tr>
                        <td><%= n.getNoticeNo() %></td>
                        <td><%= n.getNoticeTitle() %></td>
                        <td><%= n.getNickName() %></td>
                        <td><%= n.getNoticeCount() %></td>
                        <td><%= n.getNoticeDate() %></td>
                     </tr>
                  <% } %>
               <% } %>

				<!-- 일반 for문으로 작성 -->
	<%-- 			<% }else{ %> 
						<% for(int i= 0; i<list.size(); i++){ %>
							<% Notice n = list.get(i); %>
							<tr>
								<td><%= n.getNoticeNo() %></td>
								<td><%= n.getNoticeTitle() %></td>
								<td><%= n.getNickName() %></td>
								<td><%= n.getNoticeCount() %></td>
								<td><%= n.getNoticeDate() %></td>
							</tr>
						<% } %>
					<% } %>	 --%>
	
        	</table>
   		</div>
		<!-- admin계정으로 로그인 시에만 공지사항 페이지에 글쓰기 버튼이 나타나게하는 코드 -->	
     	 <div align="right">
      	   <% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
        	 <input type="button" onclick="location.href='writeNoticeForm.no'" id="writeNoBtn" value="글쓰기">
      		<% } %>
  		</div>
   </div>
   <!-- 상단 table태그 id가 listArea. 여기에 접근할려면 이 아디를 알아야함 -->
   <script> /* 코드 설명 강의시간 10:12 */
		$(function(){
			$('#listArea td').mouseenter(function(){
				$(this).parent().css({'background':'darkgray','cursor':'pointer'});// 마우스올라가면 회색으로 바뀌고 벗어나면 회색이 해제되지는 않는 상태
			}).mouseout(function(){
				$(this).parent().css('background','none'); // 마우스 내려가면 회색 컬러 해제됨
			}).click(function(){ // 이 게시글만 보겠다고 select해올거면 조건을 넣어줘야하는데 뭐로 나뉠 수 있을까? 글번호 . pk라서 겹칠 일이 없음.
				// 글번호 추출해보자
				// this == #listArea td
				var num = $(this).parent().children().eq(0).text(); // 코드 의미 노션에 있음
				
				/* Q.왜 td에서 tr로 갔다가 다시 td로 오는건가요?
				A.this는 내가 클릭한 td를 말함. 내가 글번호,제목,작성자 등을 가지고 클릭할 수 있음. 뭐를 가지고 할지 모르니
				간단하게 나를 포함하는 행의 위인 부모로 올라갔다가 내려오면 간편해서 이렇게 하는 것
				... 강의 10:27 
				나를 같이 포함하고 있는 부모로 갔다가 그 부모 아래있는 나랑 동위에 있는 첫번째 라는걸 가져오기위해 부모로 갔다가 동위로 오는건데
				많은 방법 중에 하나를 알려준 것 */
				
				location.href = '<%= request.getContextPath() %>/detail.no?no=' + num; 
				// /detail.no?의 ?는 무슨 뜻이지?
				// 콘텍스트 루트 : /detail.no  서블릿으로 보내는 데이터 : ?no=' + num  
				// url주소에 데이터가 들어갈 수 있게 조작한 코드						
				
				// ? 뒤에부터가 ... 강의시간 10:32
				// ? 다음에 데이터가 들어간다
				// ? no라고 하는 변수에 데이터가 들어간다
				// no= + num의 데이터를 서블릿으로 보냄
						
			});
		});
   
   </script>
   
   
</body>
</html>




