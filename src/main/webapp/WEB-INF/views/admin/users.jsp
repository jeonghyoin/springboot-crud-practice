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
		<h1>User Page <small>with Bootstrap</small></h1>
	</div>
	<div class="container-fluid">
	    <table class="table table-hover">
	        <tr>
	            <th>Name</th>
	            <th>Role</th>
	            <th>non-Locked</th>
	            <th>Progress</th>
	            <th>활성화</th>
	        </tr>
	          <c:forEach var="l" items="${list}">
	             <tr>
	                  <td width="15%">${l.username}</td>
	                  <td width="15%">${l.authority}</td>
	                  <td width="15%">${l.accountNonLocked}</td>
	                  <td width="45%"><div class="progress">
	                  <div class="progress-bar progress-bar-striped bg-info" role="progressbar" id="visible-progress-bar"aria-valuenow="15" aria-valuemin="0" aria-valuemax="100" style="width: ${l.progressStatus}%">${l.progressStatus}%</div>
					  </div></td>
					  <td width="10%"><c:if test="${l.accountNonLocked ne true}"><button type="submit" class="btn btn-default">활성화</button></c:if></td>
	              </tr>
	          </c:forEach>
	    </table>
    </div>
</div>
</body>
</html>