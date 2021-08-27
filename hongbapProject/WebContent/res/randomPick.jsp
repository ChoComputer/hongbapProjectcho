<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{padding: 0; margin: 0; }
	h1 h2 {font: small-caps bold 30px/1 sans-serif; }
	h1{ border-radius: 15px; background-color: #FACC2E;}
	h2{color: #64CD3C;}
	.storeN{color: rgb(121, 32, 32);}
	.imgA{ object-fit:contain; width: 150px; height:150px;}
	.snd{color: red;}
	.br{color:#A0522D;}
	.wordR{color:red;}
	.wordG{color:green;}
	.word{text-align: center;}
	.gre{position:relative;left:7px; width:98%; height:35px; border-radius: 14px; background-color: #8B5927; margin:1px;} 
	.bro{position:relative;left:7px; width:98%; height:35px; border-radius: 14px; background-color:#228B22; margin:1px;}
	.buttonGo{font: small-caps bold 24px/1 sans-serif;
			border:0; outline:0; margin:6px 0 5px 0; border-radius: 18px; width: 100%; height:50px; background-color: #FACC2E;}
	.redW{color: brown;}
	.button{border:0; outline:0;margin: 3px 0 3px 23px; font: small-caps bold 20px/1; }
	.buttonR{border:0; outline:0;border-radius:8px; background-color:red; color:white; width:49%; height:30px;}
	.buttonG{border:0; outline:0;border-radius:8px; background-color:green; color:white; width:49%;height:30px;}
 	.randomimg{position:relative;left:7px; border-radius: 35px; height: 250px; width:98%; height:125px; background-image: url("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMTBfMjY1%2FMDAxNjEwMjE0OTcwNTEx.XK7MST1z9whArzIlYg4KnDn7-_puGiN3Kz1NAaPY6XAg.l3sitVfjvAJjV8gtIW3wZJ93LrzsdHhMX5LMUNoudasg.JPEG.ra4754%2FScreenshot%25A3%25DF20210110%25A3%25AD024340%25A3%25DFKakaoTalk.jpg&type=a340");}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="row" style="font-size:50%;">&nbsp;</div>
	<div class="row ">
		
			<img class="imgA" src="../img/rainbow.png">
	
		
	</div>
	<hr style="margin:0;padding:0;"/>
	<div class="row" style="font-size:50%;">&nbsp;</div>
		<div class="row">
			<div class="col-md-12">
				<h1 class="word"><span class="redW">H</span>ong<span class="redW">B</span>ap <span class="redW">R</span>andom <span class="redW">P</span>ick</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 ">
				<h2 class="word gre"> 오<span class="snd">늘</span>의 <span class="snd">추</span>천<span class="snd">식</span>당 </h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 ">
				<h2 class="word bro storeN">${randomResult.resName}~!!!</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<div class="randomimg"></div>
			</div>	
		</div>
		
		<div class="row">
		<div class="col-md-12">
		<a href="http://localhost:8181/hongbapProject/randompick.do"><button type="button" class="buttonR ">다른 거 뽑기</button></a>
		<a href="http://localhost:8181/hongbapProject/hongbapMain/hongbapMain.jsp"><button type="button" class="buttonG ">메인화면으로 가기</button></a>
		</div>
		</div>
		
		<div class="row">
				<a href="http://localhost:8181/hongbapProject/res/resDetail.do?resId=${randomResult.resId}&page=1"><button type="button" class="buttonGo"> ${randomResult.resName} 으로 이동~!</button></a>
		</div>
		<div class="row" style="font-size:50%;">&nbsp;</div>
		
		
		
		
		<hr/>
		
		<footer>
		
		<div class="row">
		<h6 class="text-primary text-center"><span class="br"><b>홈페이지</b> :</span> <strong>www.hongbap.com</strong></h6>
		<h6 class="text-primary text-center"><span class="br"><b>만든이</b> :</span> <strong><span class="wordR">신우람</span> <span class="wordG">조훈현</span> 서성현</strong></h6>
		</div>
		
		</footer>
	</div>
</body>
</html>