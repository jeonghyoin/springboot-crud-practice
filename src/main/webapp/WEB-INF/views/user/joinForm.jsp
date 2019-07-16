<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Spring Security</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body>
<c:import url="/WEB-INF/views/resources/category.jsp"></c:import>
	
	<div class="container">
		<div class="page-header">
			<h1>Join Page <small>with Bootstrap</small></h1>
		</div>
		<div class="container-fluid">
			<form method="post" action="/join">
				<!-- <sec:csrfInput/> -->
				<div class="form-group">
					<label for="username">아이디</label>
					<input type="text" class="form-control" name="username" placeholder="username" required>
				</div>
				<div class="form-group">
					<label for="password">비밀번호</label>
					<input type="password" class="form-control" name="password" placeholder="Password" required>
				</div>
				<div class="form-group">
					<label for="role">권한</label><br>
					<input type="radio" name="role" id="def-radio" value="DEFAULT" checked="checked"> 일반 회원 &nbsp;
					<input type="radio" name="role" id="admin-radio" value="ADMIN"> 관리자 회원
				</div>
				<div class="text-center">
					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<span class="text-danger"><c:out
								value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /></span>
						<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
					</c:if>
				</div>
				<hr>
				<button type="submit" class="btn btn-default">회원가입</button>
			</form>
		</div>
		<div class="container"></div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
<script type="text/javascript">
$(document).ready(function() { 
    $("input:radio[id=admin-radio]").click(function() { 
    	$("input:radio[id=admin-radio]").prop("checked", false);
    	isAdminCheck();
    }) 
});
function isAdminCheck(){
    if(confirm("인증 후 관리자 회원으로 가입 가능합니다.")){
		location.href='/join/authAdmin';
	}
}
</script>
</html>