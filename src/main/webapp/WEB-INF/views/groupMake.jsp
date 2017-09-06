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

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="group"><span class="glyphicon glyphicon-cloud"></span> 그룹 일정 공유</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="group"><span class="glyphicon glyphicon-menu-left"></span> 그룹 목록</a></li>
      				<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<h2>그룹 만들기</h2>
		<form action="groupAdd" method="post">
			<div class="form-group">
				<label for="email">그룹 이름 :</label>
				<input type="text" class="form-control" id="name" name="name" maxlength="10" autocomplete=off>
			</div>
			<div class="form-group">
				<label for="pwd">설명 :</label>
				<input type="text" class="form-control" id="purpose" name="purpose" maxlength="20" autocomplete=off>
			</div>
			<a class="btn btn-default btn-block" href="group">취소</a>
			<button type="submit" class="btn btn-primary btn-block btn-lg">만들기</button>
			
			<c:if test="${!empty param.r}">
			<div class="h6 text-right text-danger"><span class="glyphicon glyphicon-warning-sign"></span> 동일 그룹이름이 존재합니다.</div>
			</c:if>
		</form>
	</div>

</body>
</html>
