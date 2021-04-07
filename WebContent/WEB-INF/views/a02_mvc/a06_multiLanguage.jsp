<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
multi_title=MultiLanguage experience!!
ename=Ename
job=Job
search=Search
title=Title
content=Content

multi_title=다국어 처리!!
ename=사원명
job=직책명
search=검색
title=제목
content=내용
--%>
//
	$(document).ready(function(){
		$("#selectLan").val("${param.lang}");
		$("#selectLan").change(function(){
			if($(this).val()!=""){
				location.href="${path}/choiceLan.do?lang="+$(this).val();
			}
		});
	});
</script>
</head>
<body>
<div class="jumbotron text-center">
	<h2>다국어 처리</h2>
	<h3><spring:message code="welcome"/></h3>
	<select class="form-control" id="selectLan">
		<option value=""><spring:message code="chlang"/></option>
		<option value="ko"><spring:message code="ko"/></option>
		<option value="en"><spring:message code="en"/></option>
	</select>
</div>
<div class="container">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<form class="form-inline" method="post" action="${path}/">
			<input class="form-control mr-sm-2" type="text" 
			name="ename" value=""
			placeholder="사원명">
			<input class="form-control mr-sm-2" type="text" 
			name="job"  value=""
			placeholder="직책명">
			<button class="btn btn-success" type="submit">Search</button>
		</form>
	</nav>
	<table class="table table-hover">
    <thead>
		<tr class="table-success text-center">
			<th><spring:message code="title"/></th>
		</tr>
    </thead>
   	<tbody>
		<tr class="text-center">
			<td><spring:message code="title"/></td>
		</tr>
	</tbody>
	</table>    
</div>
</body>
</html>