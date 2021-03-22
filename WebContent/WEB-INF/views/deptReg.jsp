<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	var result = "${result}";
	if(result == "true")
		location.href="dept.do";
</script>
<body>
	<form>
	부서번호 : <input type="text" name="deptno">
	부서명 : <input type="text" name="dname">
	부서위치 : <input type="text" name="loc">
	<button>등록</button>
	</form>
	
	<a href="dept.do">조회페이지로</a>
</body>
</html>