<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="member-style.css">

<style>
    span.guide{display: none; font-size:12px; top:12px; right:10px;}
    span.ok{color:green;}
    span.error{color:red;}
</style>

</head>
<body>

    <jsp:include page="../common/menubar.jsp"/>
    <h1 align="center">회원가입</h1>

    <div class="centerText">
        <form action="minsert.me" method="post" id="joinForm">
            <table>
                <tr>
                    <th>* 아이디</th>
                    <td>
                        <input type="text" name="id" id="userId">
                        <span class="guide ok">사용 가능한 아이디</span>
                        <span class="guide error">사용 불가능 아이디</span>
                        <input type="hidden" id="idDuplicateCheck" value="0"/>
                    </td>
                </tr>
                <tr>
                    <th>* 이름</th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>* 비밀번호확인</th>
                    <td><input type="password" name="pwd"></td>
                </tr>    
                <tr>
                    <th>닉네임</th>
                    <td><input type="text" name="nickName"></td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>
                        <input type="radio" name="gender" value="M">남
                        <input type="radio" name="gender" value="F">여
                    </td>
                </tr>
                <tr>
                    <th>나이</th>
                    <td><input type="number" name="age" min="20" max="100"></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td><input type="tel" name="phone"></td>
                </tr>
                <tr>
                    <th>우편번호</th>
                    <td>
                        <input type="text" name="post" class="postcodify_postcode5" value="" size="6">
                        <button type="button" id="postcodify_search_button">검색</button>
                    </td>
                </tr>
                <tr>
                    <th>도로명 주소</th>
                    <td><input type="text" name="address1" class="postcodify_address" value=""></td>
                </tr>
                <tr>
                    <th>상세 주소</th>
                    <td><input type="text" name="address2" class="postcodify_extra_info" value=""></td>
                </tr>

                <!-- jQuery & Postcodify 로딩 -->
                <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
                <script>
                    // 검색 단추가 열리면 팝업 레이어가 열리도록 설정
                    $(function(){
                        $("#postcodify_search_button").postcodifyPopUp();
                    });
                </script>
                
                <tr>
                    <td>
                        <button onclik="return validate();">가입하기</button>
                        <input type="reset" value="취소하기">
                        <button type="button" onclick="location.href='home.do'">시작 페이지로</button>
                    </td>
                </tr>

            </table>        
        </form>
    </div>

    <script>
        ${'#userId'}.on('keyup',function(){
            var userId = $(this).val().trim(); // trim() : 앞뒤 공백제거

            if(userId.length < 4){
                $('.guide').hide();
                $('#idDuplicateCheck').val(0);

                return;
            }

            $.ajax({
                url: 'dupId.me',
                date: {id:userId},
                success: function(date){
                    console.log(date);

                    if(data == 1){ /* 이 데이터가 원래는 str타입으로 넘어가고 있으나 js에서 알아서 형변환 */
                        $('.guide.error').show();
                        $('.guide.ok').hide();
                        $('#idDuplicateCheck').val(0); // 에러라 유효성 필요없으니 0보냄
                    }else{
                        $('.guide.error').hide();
                        $('guide.ok').show();
                        $('#idDuplicateCheck').val(1);  // 에러없으니 유효성 검사 필요해서 1보냄
                    }
                },
                error: function(data){
                    console.log(data);
                }
            });
        });
    
    function validate(){
        if($('#idDuplicateCheck').val() == 0){
            alert('사용 가능한 아이디를 입력해주세요');
            $('#userId').focus();
            return false();
        } else{
            $('#joinForm').submit();
        }
    }


    </script>




</body>
</html>