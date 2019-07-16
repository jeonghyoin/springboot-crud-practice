<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <meta id="_csrf" name="_csrf" content="${_csrf.token}" /> <meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}" /> -->
<sec:csrfMetaTags />
<title>Spring Security</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body>
<c:import url="/WEB-INF/views/resources/category.jsp"></c:import>
	<div class="container">
		<div class="page-header">
			<h1>Login Page <small>with Bootstrap</small></h1>
		</div>
		<div class="container-fluid">
			<form method="post" action="/login">
				<!-- <sec:csrfInput/> -->
				<div class="form-group">
					<label for="username">유저명</label>
					<input type="text" class="form-control" name="username" placeholder="username" required>
				</div>
				<div class="form-group">
					<label for="password">비밀번호</label>
					<input type="password" class="form-control" name="password" placeholder="Password" required>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" name="remember-me">Remember me</label>
				</div>
				
				<!-- 인증 실패 시 message 변수 값을 읽어와 화면에 출력 -->
				<!-- c:if 태그를 사용하여 해당 키가 비어있지 않으면(인증에 실패했으면) 세션을 통해 저장되어 있는 에러 메시지를 보여준다. -->
				<div class="text-center">
					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<div class="alert alert-danger" role="alert">
						<span class="text-danger" id="failDiv">
							<p>Your login attempt was not successful due to <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /></p>
							<input type="hidden" name="exceptionMsg" id="exceptionMsg" value="${SPRING_SECURITY_LAST_EXCEPTION.message}" >
						</span>
						</div>
						<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
					</c:if>
				</div>
				<hr>
				<button type="submit" class="btn btn-default">로그인</button>
				<a class="btn btn-default" href="/joinForm">회원가입</a>
			</form>
		</div>
		<div class="container"></div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>

<script>
var exceptionMsg = $('#exceptionMsg').val();
if(exceptionMsg == "Bad credentials") {
	$("#failDiv").append("<strong>아이디 혹은 비밀번호를 확인해주세요.</strong>");
}
if(exceptionMsg == "User account is locked") {
	$("#failDiv").append("<strong>비밀번호 오류 초과로 계정이 잠금처리 되었습니다. 관리자에게 문의하세요.</strong>");
}

</script>

</html>