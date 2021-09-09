<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<style>
		  *{padding: 0; margin: 0;}
    	.br{color:#A0522D;}
	.wordR{color:red;}
	.wordG{color:green;}
    header{text-align: center;}
    .titleBack{ display: inline-block; width: 190px; background-color: wheat; border-radius: 15px;}
    .title{ padding: 15px 3px 15px 3px; margin: 3px; width: 180px; font: small-caps bold 24px/1 sans-serif; color: whitesmoke; background-color: rgb(212, 52, 12); border-radius: 15px; }
    .table{ border: 3px solid black; border-radius: 30px 30px 15px 15px; padding: 12px;
            background-color: black;}
    .foodca{font: small-caps bold 24px/1 sans-serif; color: white; padding: 10; margin: 10px;}
     .button{ margin: 0 0 0 15px;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body style="background-image:url(../img/cloud.png); background-repeat: cover;">
	<div class="container">
	
  <form action="/hongbapProject/boardWrite.do" method="post">
  
  <!-- hidden 태그를 이용해 나머지 요소들도 다 첨부해 주세요 -->
  <input type="hidden" value="${board.bId }"name="bId">
  <input type="hidden" value="${board.bHit }"name="bHit">
  <input type="hidden" value="${board.bDate }"name="bDate">
  <input type="hidden" value="${nick_session }"name="bWriter">
  <div class="row">&nbsp;</div>
  <header>
    <div class="titleBack">
      <h2 class="title">가게 추천하기</h2>
    </div>
  </header>
  <div class="table" >
    <div class="row">
      <div class="row">&nbsp;</div>
      <div class="foodca col-md-2" > 글제목</div>
      <div class="col-md-9"><input type="text"  style="background-color:ivory" class="form-control" name ="bTitle"  required placeholder="{가게이름} 을 추천합니다~! 로 작성해주세요"></div>
    </div><br/>
    <div class="row">
      <p class="foodca"> 글본문</p>
        <textarea style="background-color: red; font-weight: bold; font-size: 20px; color: white;" cols="100" class="form-control" rows="7"  name="bContent" requiredplaceholder="추천 하고자 하시는 가게의 정보 및 이유를 작성해주세요 검토후 추후 업데이트에 반영하겠습니다." >
가게이름 :
가게위치 :
가게주소 : 
가게전화번호 :
가게추천메뉴(다메뉴 추천 가능) : 
        </textarea>
      </div>
      <div class="row">&nbsp;</div>
      <div class="row" >
        <div class="foodca"> 글쓴이</div>
        <div><input type="text" style="background-color:ivory" class="form-control" name="bWriter" value="${nick_session }" readonly></div>
      
      </div>
    
  </div>
    <footer>
      <div class="button">
        <button type="submit" class="btn btn-danger buttonReq" >요청하기</button>
        <button type="reset" class="btn btn-success buttonReset" >글다시쓰기</button>
		<a href="http://localhost:8181/hongbapProject/board/boardSelect.do?page=1"><button
                type="button" class="btn btn-primary">요청게시판</button></a>
        <a href="http://localhost:8181/hongbapProject/hongbapMain/hongbapMain.jsp"><button type="button" class="btn btn-warning" style="color:white;" >메인화면으로 가기</button></a>

      </div>
      <hr/>
				
		<div class="row">
		<h6 class="text-primary text-center"><span class="br"><b>홈페이지</b> :</span> <strong>www.hongbap.com</strong></h6>
		<h6 class="text-primary text-center"><span class="br"><b>만든이</b> :</span> <strong><span class="wordR">신우람</span> <span class="wordG">조훈현</span> 서성현</strong></h6>
		</div>
				
    </footer>
  </form>
  </div>
</body>
</html>