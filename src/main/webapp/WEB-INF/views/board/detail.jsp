<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail</title>
</head>
<style>
	label {font-size: 1.5em;}
</style>

<body>
<c:import url="/WEB-INF/views/resources/category.jsp"></c:import>
<div class="container">
	<div class="page-header">
		<h1>Board Detail Page <small>with Bootstrap</small></h1>
	</div>
    <form id="detail">
      <div class="form-group">
        <label>제목</label>
        <input type="text" class="form-control" name="subject" value="${detail.subject}">
      </div>
      <div class="form-group">
        <label>작성자</label>
        <p>${detail.writer}</p>
      </div>
      <div class="form-group">
        <label>작성날짜</label>
        <p>${detail.reg_date}</p>
      </div>
      <div class="form-group">
        <label>내용</label>
        <input type="text" class="form-control" name="content" value="${detail.content}">
      </div>
      <hr>
      <!-- ajax -->
      <button type="button" class="btn btn-default" name="update" value="${detail.bno}">수정</button>
      <button type="button" class="btn btn-default" onclick="location.href='/list'">취소</button>
    </form>
</div>
</body>

<script>
$("button[name='update']").click(function() {
	var bno = this.value;
	var formData = $("#detail").serialize();
	
	if(confirm(bno+"번째 글을 수정하시겠습니까?")){
		$.ajax({
	          url: '/update/'+bno,
	          data: formData,
	          dataType:'text',
	          success: function(data) {
	        	  alert(data);
	        	  location.reload();
	          },
	          /* error: function (data, request, status, error) {
	        	  alert(data.responseText);
	          } */
	    });
	}
});
</script>
</html>