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
				<a class="navbar-brand" href="#"><span class="glyphicon glyphicon-cloud"></span> 그룹 일정 공유</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="groupMake"><span class="glyphicon glyphicon-plus"></span> 그룹 만들기</a></li>
      				<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<h2>그룹 목록</h2>
		
		<c:choose>
			
			<c:when test="${empty dtos}">
				<div class="well text-center">메뉴를 눌러 먼저 그룹을 만드세요.</div>		
			</c:when>
			
			<c:otherwise>
				<c:forEach items="${dtos}" var="dto">
				  	<button type="button" class="btn btn-primary btn-block btn-lg" onclick="location.href='task?gid=${dto.serial}'">
				  		<span class="glyphicon glyphicon-user pull-left"> ${dto.numMember}</span>
				  		<span class="pull-right">${dto.name}</span>
				  	</button>
				  	<div class="h6 text-right"><span class="glyphicon glyphicon-info-sign"></span> ${dto.purpose}</div>
			  	</c:forEach>
			</c:otherwise>
		
		</c:choose>
		
		
	  	
	</div>

</body>
</html>
