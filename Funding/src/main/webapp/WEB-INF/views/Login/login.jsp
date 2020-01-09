<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link href="https://fonts.googleapis.com/css?family=Do Hyeon"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/test.css"
	type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>


<!-- 로그인 저장 아이디 -->
<script>
$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백
    var userInputId = getCookie("userInputId");
    $("input[name='id']").val(userInputId); 
     
    if($("input[name='id']").val().toString().length){ 
        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있을때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을때,
            var userInputId = $("input[name='id']").val();
            setCookie("userInputId", userInputId, 10); // 10일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userInputId");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 쿠키 저장.
    $("input[name='id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='id']").val();
            setCookie("userInputId", userInputId, 10); // 10일 동안 쿠키 보관
        }
    });
});

function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}


</script>

<!-- 빈칸 체크 -->
<script>

window.onload =function(){
    document.getElementById("send").onclick = chkData;
    
}
function chkData(){
    if(document.iform.id.value === "" || isNaN(iform.id.value) === false){ //isNaN에 의해서 숫자는 처리 불가
         iform.id.focus(); //request는 생략 가능(java)
         alert("아이디를 입력하시오");
         return;
    }
   
    //정규 표현식으로 입력자료 검사
          var aa=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; // 표준식
         // a부터 z까지 문자 1개 이상일 경우 and 숫자 0,1,2일 경우에만 / [^a-z, 0,1,2] : ^ 붙이면 부정의 뜻 / 한글은 가-힣
         if(!iform.id.value.match(aa)){
             alert("이메일 형식으로 입력하세요!");
             iform.id.focus();
             return;   
         }
         

         if (iform.pwd.value.length > 12)
         {
          alert("아이디는 4~12자 이내로 입력 가능합니다!");

          iform.pwd.select();//입력한 문자를 선택 상태로 만듬.
          return;
         }
         
         
       
    iform.action = "loginOK.do";
    iform.method = "post";
    iform.submit(); //서버에 파일로 전송(servlet, jsp)
    
    
    }




</script>



</head>
<body>
<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
<form name="iform" method="post" >
	<div class="put">
		

			<table border="1" id="test">
				<tr>
					<td colspan="2"><input type="text" placeholder="이메일을 입력하세요"  id="login_id" name="id"></td>

				</tr>


				<tr>
					<td colspan="2"><input type="password" name="pwd" 
						placeholder="비밀번호를 입력하세요"  

						></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="로그인" id="send"></td>
				</tr>

				<tr>
					<td><input type="checkbox" name="idSaveCheck" id="idSaveCheck">아이디 저장</td>
					<td><input type="checkbox" name="autoLog">자동로그인</td>
				</tr>

				<tr>
					<td><a href="findPwd.do">비밀번호 찾기</a></td>
					<td><a href="agree.do">회원가입하기</a></td>
				</tr>


			</table>

		
	</div>

</form>

</body>
</html>