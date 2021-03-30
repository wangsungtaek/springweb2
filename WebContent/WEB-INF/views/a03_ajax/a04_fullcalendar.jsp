<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<link href='${path}/a00_com/lib/main.css' rel='stylesheet' />
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
<script src='${path}/a00_com/lib/main.js'></script>

<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	
<%--
 
 
--%>
	// document.addEventListener("DOMContentLoaded")
	// 전체 DOM에 로딩되었을 때, jquery $(document).ready();와 동일
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		// new FullCalendar.Calendar(대상 DOM객체,
		//			{속성:속성값, 속성2:속성값2..})

		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar : {
				left : 'prev,next today',
				center : 'title',
				right : 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			initialDate : '2021-04-12', // 초기 로딩 날짜.
			navLinks : true, // can click day/week names to navigate views
			selectable : true,
			selectMirror : true,
			// 이벤트명:function(){} : 각 날짜에 대한 이벤트를 통해 처리할 내용.
			select : function(arg) {
				console.log(arg);
				var title = prompt('입력할 이벤트:');
				if (title) {
					calendar.addEvent({
						title : title,
						start : arg.start,
						end : arg.end,
						allDay : arg.allDay,
						backgroundColor:"yellow",
						textColor : 'blue'
					})
				}
				calendar.unselect()
			},
			eventClick : function(arg) {
				// 있는 일정을 클릭시,
				console.log("#등록된 일정 클릭#");
				console.log(arg.event);
				if (confirm('일정 삭제하시겠습니까?')) {
					arg.event.remove()
				}
			},
			editable : true,
			dayMaxEvents : true, // allow "more" link when too many events
			events : function(info, successCallback, failureCallback){
				// ajax 처리로 데이터를 로딩 시킨다.
				$.ajax({
					type:"get",
					url:"${path}/calendar.do?method=data",
					dataType:"json",
					success:function(data){
						console.log(data.list);
						successCallback(data.list);
					},
					error:function(err){
						console.log(err);
					}
				});
				
			}
		});

		calendar.render();
	});

	$(document).ready(function() {

	});
</script>
</head>
<body>

	<div id='calendar'></div>
	
</body>
</html>