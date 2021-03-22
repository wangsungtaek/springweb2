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
<body>
	<table>
		<form method="post">
		부서이름 : <input type="text" name="dname" value="${dept.dname}">
		근무지 : <input type="text" name="loc" value="${dept.loc}">
		<button>전송</button>
		</form>
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>근무지</th>
		</tr>
		<c:forEach var="dept" items="${list}">	
			<tr>
				<td>${dept.deptno}</td>
				<td>${dept.dname}</td>
				<td>${dept.loc}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="deptReg.do">등록페이지로</a>
</body>
</html>