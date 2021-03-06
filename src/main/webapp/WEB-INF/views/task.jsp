<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
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
	<link rel="stylesheet" href="resources/css/bootstrap-custom.css" >
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
					<li><a href="taskDone?gid=${param.gid}"><span class="glyphicon glyphicon-menu-left"></span> 완료된 그룹 일정</a></li>
					<li><a href="group"><span class="glyphicon glyphicon-menu-left"></span> 그룹 목록</a></li>
					<li><a href="invitation?gid=${param.gid}"><span class="glyphicon glyphicon-user"></span> 등록된 그룹원</a></li>
					<c:if test="${isGroupMaker}">
						<li><a href="invitationMake?gid=${param.gid}"><span class="glyphicon glyphicon-user"></span> 그룹원 등록</a></li>
					</c:if>
      				<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		
		<form action="taskAdd?gid=${param.gid}" method="post" class="form-horizontal" id="frm">
			<div class="input-group">
				<textarea rows="2" class="form-control" placeholder="할 일을 적어주세요." name="todo" maxlength="200"></textarea>
				<span class="input-group-addon btn btn-primary bg--primary" onclick="document.getElementById('frm').submit();">등록</span>
			</div>
	  	</form>
	  	
	  	<h2>그룹 일정 <span class="badge bg--primary">${fn:length(dtos)}</span></h2>

		<c:choose>

			<c:when test="${empty dtos}">
				<div class="well text-center">등록된 그룹일정이 없습니다.</div>
			</c:when>

			<c:otherwise>
				<c:forEach items="${dtos}" var="dto">
					<div class="input-group">
						<span class="input-group-addon">${dto.name}</span>
						<textarea rows="2" class="form-control bg--white" readonly>${dto.todo}</textarea>
						
						<c:choose>
							<c:when test="${ userSerial == dto.memberSerial}">
								<span class="input-group-addon btn btn-primary  bg--primary" onclick="location.href='taskOk?gid=${param.gid}&tid=${dto.serial}'"><span class="glyphicon glyphicon-ok"></span></span>
							</c:when>
							<c:otherwise>
								<span class="input-group-addon btn btn-primary" ><span class="glyphicon glyphicon-ban-circle"></span></span>
							</c:otherwise>			
						</c:choose>
						
					</div>
					<div class="h6 text-right"><span class="glyphicon glyphicon-pencil"></span> <fmt:formatDate value="${dto.regDate}"  pattern="yyyy-MM-dd HH:mm" /></div>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</div>

</body>
</html>
