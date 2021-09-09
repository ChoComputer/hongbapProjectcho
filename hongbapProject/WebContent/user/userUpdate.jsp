<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Hong Bop 회원정보수정창</title>
<style>
*{margin: 0; padding:0; }

.imgA{ width:130px; margin: 0; height: 55px;}
.A{font-weight: bold;}
.clouda{margin: 0 0 0 5px; width: 99%; height: 55px; background-repeat: repeat; background-position: top ; background-size: 160px; background-image: url("../img/cloud.png");}
h1 {top: 6px; left:0; font:italic small-caps bold 60px/1 sans-serif; line-height: 60px;}	
.headheight{ margin: 0 0 15px 0;}
.br{color:#A0522D;}
.wordR{color:red;}
.wordG{color:green;}

</style>

</head>
<body>
	
<div class="container">
	<div class="row">&nbsp;</div>

<div class="row clouda">
<div class="col-md-2">
<img class="imgA" src="../img/rainbow.png">
</div>
<div class ="col-md-10" >
<h1>Edit Profile</h1>
</div>
</div>
		
	<form action="http://localhost:8181/hongbapProject/user/userUpdate.do" method="post">
	 	
<hr class="headheight" />	 	
<div class="row">&nbsp;</div>	 	
<div class="row">&nbsp;</div>	 	
<div class="row">
<div class="input-group" >
<div class="input-group-prepend">
<span class="input-group-text A">&nbsp;&nbsp;아이디&nbsp;</span>
</div>
<input type = "text" class="form-control" placeholder ="${id_session}" readonly>
</div>
</div>

<div class="row" style="line-height: 50%;" >&nbsp;</div>

<div class="row">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text A">비밀번호</span>
</div>
<input type = "password" class="form-control" name="UserPw" placeholder ="PW" required>
</div>
</div>

<div class="row" style="line-height: 50%;" >&nbsp;</div>

<div class="row">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text A">&nbsp;&nbsp;이름&nbsp;&nbsp;&nbsp;</span>
</div>
<input type = "text" class="form-control" name="UserName" placeholder ="Name" required>
</div>
</div>

<div class="row" style="line-height: 50%;" >&nbsp;</div>

<div class="row">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text A">&nbsp;닉네임&nbsp;&nbsp;</span>
</div>
<input type = "text" class="form-control" name="UserNick" placeholder ="NickName" required>
</div>
</div>

<div class="row" style="line-height: 50%;" >&nbsp;</div>

<div class="row">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text A">&nbsp;이메일&nbsp;&nbsp;</span>
</div>
<input type = "email" class="form-control" name="UserEmail" placeholder ="Email">
<div class="input-group-append">
<span class="input-group-text A">ex)ooo@ooo.com/net</span>
</div>
</div>
</div>

<div class="row" style="line-height: 50%;" >&nbsp;</div>

<div class="row">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text A">핸드폰 번호</span>
</div>
<input type = "text" class="form-control" name="UserPnum" placeholder ="Pnum">
</div>
</div>

<div class="row" style="line-height: 50%;" >&nbsp;</div>

<div class="row">
<input type = "submit" value = "제출" class = "btn btn-success">

<input type = "reset" value = "초기화" class = "btn btn-danger">
</div>

</form>

<footer>

<div class="row">
<img sytle="object-fit:contain;" src="https://i.pinimg.com/originals/0d/36/81/0d368135094ffce1b9a7fe5d1215d8e6.png">
</div>
<hr/>
<div class="row" style="line-height: 50%;" >&nbsp;</div>
<div class="row">
<h6 class="text-primary text-center"><span class="br">홈페이지</span> : <strong>www.hongbap.com</strong></h6>
<h6 class="text-primary text-center"><span class="br">만든이</span> : <strong><span class="wordR">신우람</span> <span class="wordG">조훈현</span> 서성현</strong></h6>
</div>


</footer>	
		
</div>
</body>
</html>
