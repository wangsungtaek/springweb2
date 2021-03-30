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
	<h2>파일 업로드 연습</h2>
</div>
<div class="container">
<!-- 파일 업로드 처리해보세요 (환경설정 - container부분 포함) -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<form class="form-inline" method="post" enctype="multipart/form-data">
		<!-- 요청 url이 호출 url과 동일하게 처리했기 때문에 action을 
		생략가능하다. (get/post) 방식으로 구분 처리. -->
			<input class="form-control mr-sm-2" type="text" 
				name="content" value=""
				placeholder="파일내용">
			<input class="form-control mr-sm-2" type="file" name="report">
			<input class="form-control mr-sm-2" type="file" name="report">
			<input class="form-control mr-sm-2" type="file" name="report">
			<button class="btn btn-success" type="submit">Search</button>
		</form>
	</nav>  
</div>
</body>
</html>