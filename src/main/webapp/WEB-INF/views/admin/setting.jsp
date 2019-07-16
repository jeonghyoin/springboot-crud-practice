<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<title>Setting</title>
</head>

<body>
<c:import url="/WEB-INF/views/resources/category.jsp"></c:import>

<div class="container">
	<div class="page-header">
		<h1>Setting Page <small>with Bootstrap</small></h1>
	</div>
<div class="container-fluid">
	<div class="col col-md-3">
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse1"> Show Progress</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse in">
					<ul class="list-group">
						<li class="list-group-item"><span class="badge"></span><a href="/admin/setting">Update Status</a></li>
						<li class="list-group-item"><span class="badge">3</span><a href="/admin/users">Show Status</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div class="col col-md-9">
		<div class="row">
			<div class="col">
				<h3>User</h3>
				<form id="progressBar">
				<p>저장할 유저의 아이디를 입력하고 확인을 눌러주세요.</p>
				<input type="text" class="form-control" id="username" name="username" placeholder="username">
				<input type="hidden" id="hiddenRange" name="hiddenRange" vaule="">
				</form>
				<hr>
				<h3>Range</h3>
				<div class="range">
	            	<input type="range" name="range" min="0" max="100" value="0" onchange="range.value=value">
	            	<b><output id="range" class="rangeVaule">0</output></b>
	         	 </div>
				<hr>
				<h3>Progress Bar</h3>
				Value
				<span class="pull-right strong">100%</span>
				<div class="progress">
					<div class="progress-bar progress-bar-striped bg-info" role="progressbar" id="visible-progress-bar"
						aria-valuenow="15" aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
				</div>
				
				<button class="btn btn-default" onclick="checkStatus()">확인</button>
		</div>
	</div>
</div>
</div>
</body>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<script>
//progress bar
$('.range').click(function() {
	var value = $(".rangeVaule").val();
	$("#hiddenRange").val(value);
	$("#visible-progress-bar").css("width", value+"%");
});

function checkStatus() {
	var status = $('#username').val();
	if(status==="")
		alert("저장할 유저를 입력하세요.");
	
	else {
		document.getElementById("progressBar").setAttribute("method", "POST");
		document.getElementById("progressBar").action="/admin/progress";
	 	document.getElementById("progressBar").submit();
	}
}
</script>
</html>