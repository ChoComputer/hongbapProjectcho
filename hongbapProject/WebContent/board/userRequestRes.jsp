<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<style>
    *{padding: 0; margin: 0;}
    .hr{width: 800px;}

    h2{padding: 10px;font: small-caps bold 24px/1 sans-serif; color: whitesmoke; background-color: rgb(212, 52, 12);width:auto; text-align: center; border-radius: 15px; }
    .table{ border: 1px solid black; border-radius: 15px;padding: 15px; background-image: url("data:image/jpeg;base64,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");}
    .foodca{font: small-caps bold 24px/1 sans-serif; color: white; padding: 10; margin: 10px;}
   	.buttonMain{color: white;}

</style>
<meta charset="UTF-8">
<title></title>
</head>
<body>
  <div class ="container">
    <div>
    <header>
      <div class="row">

        <div class="col-xs-12"  style="background-color: wheat; border-radius: 15px;">
      <h2 >가게 요청 게시판 양식</h2></div>


    </div>
    </header>
  <div class="table" >
        <div class="row">
        <div class="foodca col-md-2" > 글제목</div>
        <div class="col-md-9"><input type="text"  style="background-color:ivory" class="form-control" name ="title"  required placeholder="{가게이름} 을 추천합니다~! 로 작성해주세요"></div>
      </div><br/>
      <div>
        <p class="foodca"> 글본문</p>
        <textarea cols="100" class="form-control" rows="7" name="content" required placeholder="추천 하고자 하시는 가게의 정보 및 이유를 작성해주세요 검토후 추후 업데이트에 반영하겠습니다.">
가게이름 :
가게위치 :
가게주소 : 
가게전화번호 :
가게추천메뉴(다메뉴 추천 가능) : 
        </textarea>
      </div>
      <div class="row" >
        <div class="foodca"> 글쓴이</div>
        <div><input type="text" style="background-color:ivory" class="form-control" name="writer"value="${nick_session }" required></div>
      </div>
    
  </div>
    <hr class="hr">
    <footer>
      <div class="button">
        <button type="submit" class="btn btn-danger buttonReq" >요청하기</button>
        <button type="reset" class="btn btn-success buttonReset" >글다시쓰기</button>

        <a href="http://localhost:8181/hongbapProject/hongbapMain/hongbapMain.jsp"><button type="button" class="btn btn-warning buttonMain" >메인화면으로 가기</button></a>

      </div>
    </footer>
  </div>
</div>
</body>
</html>