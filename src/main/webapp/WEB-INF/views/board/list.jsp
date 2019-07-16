<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<body>

<c:import url="/WEB-INF/views/resources/category.jsp"></c:import>
<div class="container">
	<div class="page-header">
		<h1>Board Page <small>with Bootstrap</small></h1>
	</div>
	<div class="container-fluid">
	    <table class="table table-hover">
	        <tr>
	            <th>No</th>
	            <th>Subject</th>
	            <th>Writer</th>
	            <th>Date</th>
	            <th>Update</th>
	            <th>Delete</th>
	        </tr>
	          <c:forEach var="l" items="${list}">
	             <tr>
	                  <td>${l.bno}</td>
	                  <td>${l.subject}</td>
	                  <td>${l.writer}</td>
	                  <td>${l.reg_date}</td>
	                  <td><button class="btn btn-default" onclick="location.href='/detail/${l.bno}'">수정</button></td>
	                  <td><button type="button" class="btn btn-default" name="delete" value="${l.bno}">삭제</button></td>
	              </tr>
	          </c:forEach>
	    </table>
	    <hr>
	    <button class="btn btn-default" onclick="location.href='/insert'">글쓰기</button>
    </div>
</div>
</body>

<script>
$("button[name='delete']").click(function() {
	var bno = this.value;
	if(confirm(bno+"번째 글을 삭제하시겠습니까?")){
		$.ajax({
	          url: '/delete/'+bno,
	          dataType:'text',
	          success: function(data) {
	        	  alert(data);
	        	  location.href="/list"
	          },
	          /* error: function (data, request, status, error) {
	        	  alert(data.responseText);
	          } */
	    });
	}
});
</script>
</html>