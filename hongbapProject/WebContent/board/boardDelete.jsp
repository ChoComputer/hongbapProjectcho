<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    
<style>
    * {
        padding: 0;
        margin: 0;
        font: small-caps bold 24px/1 sans-serif;
        text-align: center;
    }
    .imgH{position: relative; margin: 0 0 15px 0;}
    .br{color:#A0522D;}
	.wordR{color:red;}
	.wordG{color:green;}
    .homp{font-size: 35px; color: blue;}
    
  .pas { display: inline-block;  width: 480px; border:6px solid #FACC2E; border-radius: 15px; background-color: #FACC2E; margin: 5px 0 5px 0; padding: 10px; }
    
    .input{border: 6px solid brown;border-radius: 10px; width: 460px; margin: 3px 0 3px 3px;}
    .but{border-radius: 10px;  width: 230px; height: 40px; margin:0 3px 0 0 ; border: 4px solid green; background-color:white ;}
    .res{border-radius: 10px;  width: 230px; height: 40px; margin:0 3px 0 0 ; border: 4px solid red; background-color:white ;}
    
</style>
<script>
    
</script>
<meta charset="UTF-8">
<title></title>
</head>
<body style="background-image:url(../img/cloud.png); background-repeat: cover;">
    <div class="container">
        <form action="http://localhost:8181/hongbapProject/board/boardDelete.do?bId=${bId}" method="post">
        <div class="row">&nbsp;</div>
            <div class="row">&nbsp;</div>
            <div class="row">&nbsp;</div>
            <div class="row">&nbsp;</div>
        <div class="row">
            <img
            src="../img/rainbow.png"
            class="imgH">
        </div>
            <div class="row">
                  <h2 class="pas">회원님의 비밀 번호를 다시 입력해주세요</h2>
            </div>
            <input type="password" class="input" name="UserPw" placeholder="비밀번호입력">
            <div class="row">
                    
                <button type="submit" class="but" >제출</button>
                <button type="reset" class="res" >초기화</button>
            </div>
            <a href="/hongbapProject/boardWrite.do">요청게시판으로 이동</a>
		<a	href="http://localhost:8181/hongbapProject/hongbapMain/hongbapMain.jsp">메인게시판으로 이동</a>
            <div class="row">
                <div class="pas" style="height: 14px;"> DELETE FROM 게시판 </div>
            </div>

            </form>
            <div class="row">&nbsp;</div>
            <div>
			
            
            <div class="row">&nbsp;</div>
            <hr/>
            <div class="row">&nbsp;</div>
		
            <div class="row">
            <h3 ><span class="br"><b>홈페이지</b> :</span> <strong class="homp">www.hongbap.com</strong></h3>
            <h3 ><span class="br"><b>만든이</b> :</span> <strong><span class="wordR">신우람</span> <span class="wordG">조훈현</span> 서성현</strong></h3>
            </div>
            
       </div>
     
    </body>
    </html>