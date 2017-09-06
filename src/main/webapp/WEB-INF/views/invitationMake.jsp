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
	<link rel="stylesheet" href="resources/css/bootstrap-custom.css">
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
				<a class="navbar-brand" href="group"><span class="glyphicon glyphicon-cloud"></span> ${groupName}</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="task?gid=${param.gid}"><span class="glyphicon glyphicon-menu-left"></span> 그룹 일정</a></li>
      				<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<form action="invAdd?gid=${param.gid}" method="post" id="frm">
			<div class="input-group">
					<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
					<input type="text" class="form-control bg--white" placeholder="ID" name="id" maxlength="20" autocomplete=off></input>
					<span class="input-group-addon btn btn-primary bg--primary" onclick="document.getElementById('frm').submit();">
						<span class="glyphicon glyphicon-plus"></span>
					</span>
			</div>
			<c:if test="${!empty param.r}">
			<c:choose>
				<c:when test="${param.r eq 'same'}">
					<div class="h6 text-right text-danger"><span class="glyphicon glyphicon-warning-sign"></span> 이미 초대된 아이디입니다.</div>
				</c:when>
				<c:otherwise>
					<div class="h6 text-right text-danger"><span class="glyphicon glyphicon-warning-sign"></span> 아이디가 존재하지 않습니다.</div>	
				</c:otherwise>
			</c:choose>
			
			</c:if>	
		</form>
		<h2>그룹원 등록</h2>
		
		<c:choose>

			<c:when test="${empty dtos}">
				<div class="well text-center">초대된 그룹원이 없습니다.</div>
			</c:when>

			<c:otherwise>
				<c:forEach items="${dtos}" var="dto">
					<div class="input-group">
						<c:set value="${ dto.isMaster eq true ? 'glyphicon-tower' : 'glyphicon-user' }" var="listIcon"/>
						<span class="input-group-addon"><span class="glyphicon ${listIcon}"></span></span>
						<input type="text" class="form-control bg--white" placeholder="" value="${dto.id}" readonly></input>
						<c:if test="${dto.isMaster == false}">
							<span class="input-group-addon btn btn-primary bg--primary" onclick="location.href='invSub?gid=${param.gid}&sid=${dto.serial}'"><span class="glyphicon glyphicon-minus"></span></span>
						</c:if>
					</div>
					<div class="h6 text-right"><span class="glyphicon glyphicon-log-in"></span> 2017.08.29</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
	</div>

</body>
</html>
