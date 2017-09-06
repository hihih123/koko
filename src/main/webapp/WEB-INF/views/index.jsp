<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<title>간편 그룹 일정 공유</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="jumbotron alert-info">
			<h1><span class="glyphicon glyphicon-cloud"></span> 그룹 일정 공유</h1> 
			<p>그룹원들과 일정을 간편하게 공유합니다</p>
		</div>
	</div>
	<div class="container">
		<form action="login" method="post">
			<div class="form-group">
				<label for="email">아이디 :</label> <input id="id" name="id" type="text" class="form-control" maxlength="20" autocomplete=off>
			</div>
			<div class="form-group">
				<label for="pwd">암호 :</label> <input id="pw" name="pw" type="password" class="form-control" maxlength="20" autocomplete=off>
			</div>
			<a class="btn btn-default btn-block" href="join">가입하기</a>
			<button type="submit" class="btn btn-primary btn-block btn-lg">로그인</button>
		</form>

	</div>

</body>
</html>
