<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Spring Security</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<c:import url="/WEB-INF/views/resources/category.jsp"></c:import>
	
	<div class="container">
		<div class="page-header">
			<h1>Auth Page <small>with Bootstrap</small></h1>
		</div>
		<div class="container-fluid">
			<div class="alert alert-danger" role="alert">
	        	<strong>관리자 인증 코드를 입력해주세요!</strong>
	     	</div>
			<form method="post" action="/join">
				<div class="form-group">
					<input type="text" class="form-control" name="authNumber" placeholder="인증코드" required>
				</div>
				<button type="submit" class="btn btn-default">인증하기</button>
			</form>
		</div>
		<div class="container"></div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>