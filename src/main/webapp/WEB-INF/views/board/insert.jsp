<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Form</title>
</head>
<body>

<c:import url="/WEB-INF/views/resources/category.jsp"></c:import>

<div class="container">
	<div class="page-header">
		<h1>Board Insert Page <small>with Bootstrap</small></h1>
	</div>
    <form action="/insertProc" method="post">
      <div class="form-group">
        <label for="subject">제목</label>
        <input type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하세요.">
      </div>
      <div class="form-group">
        <label for=content">내용</label>
        <textarea class="form-control" id="content" name="content" rows="3"></textarea>
      </div>
      <button type="submit" class="btn btn-default">작성</button>
      <button type="button" class="btn btn-default" onclick="location.href='/list'">취소</button>
    </form>
</div>
</body>
</html>