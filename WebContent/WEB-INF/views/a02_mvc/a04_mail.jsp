<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<fmt:requestEncoding value="UTF-8" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
<%--
 
 
--%>
//
	$(document).ready(function(){
	 
	});
</script>
</head>
<body>
<div class="jumbotron text-center">
	<h2>메일</h2>
</div>
<div class="container">
	<form method="post" action="${path}/mail.do?method=send">
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">제 목</span>
		</div>
		<input name="subject" class="form-control" placeholder="제목을 입력하세요"/>
	</div>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">수신자</span>
		</div>
		<input name="receiver" class="form-control" placeholder="수신자를 입력하세요"/>
	</div>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">내용</span>
		</div>
		<textarea name="content" rows="10" class="form-contorol"
			placeholder="내용을 입력하세요"></textarea>
	</div>
	<div style="text-align: right">
		<input type="submit" class="btn btn-success" value="메일전송">
	</div>
	</form>
</div>
</body>
</html>