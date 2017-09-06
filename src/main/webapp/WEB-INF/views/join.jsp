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
			<p>빠르게 가입해 보세요</p> 
			<a class="btn btn-default" href="term">약관 보기</a>
		</div>

		<form action="joinAdd" method="post">
			<div class="form-group">
				<label for="id">아이디 :</label>
				<input type="text" class="form-control" id="id" name="id" autocomplete=off>
			</div>
			<div class="form-group">
				<label for="pw">암호 :</label>
				<input type="password" class="form-control" id="pw" name="pw" autocomplete=off>
			</div>
			<div class="form-group">
				<label for="lastName">성 :</label>
				<input type="text"	class="form-control" id="lastName" name="lastName" autocomplete=off>
			</div>
			<div class="form-group">
				<label for="firstName">이름 :</label>
				<input type="text" class="form-control" id="firstName" name="firstName" autocomplete=off>
			</div>
			<a class="btn btn-default btn-block" href="index">취소</a>
			<button type="submit" class="btn btn-primary btn-block btn-lg">가입</button>
			
			<c:if test="${!empty param.r}">
			<div class="h6 text-right text-danger"><span class="glyphicon glyphicon-warning-sign"></span> 동일 아이디가 존재합니다.</div>
			</c:if>
		</form>

	</div>

</body>
</html>
