<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style type="text/css">
.input-group-text {
	width: 100%;
	background-color: linen;
	color: black;
	font-weight: bolder;
}

.input-group-prepend {
	width: 20%;
}

#chatArea {
	width: 80%;
	height: 200px;
	overflow-y: auto;
	text-align: left;
	border: 1px solid green;
}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">

   $(document).ready(function(){
      $("h2").text("채팅");
      //1. 전역변수 웹 소켓 통신 처리한 변수 선언
      var wsocket;
      //2. 접속시, 처리 내용.
       $("#enterBtn").click(function(){
         if(confirm("채팅서버에 접속하시겠습니까?")) {
            wsocket=new WebSocket(
                  "ws://localhost:7080/${path}/chat-ws.do");
            //1. 접속시
            wsocket.onopen=function(evt){
               //채팅 서버에 접속되었을 때, 처리할 내용
               console.log(evt)
               //접속메시지 전송 : 그룹명: 아이디명: 메시지
               wsocket.send($("#group").val()+"msg:"+$("#id").val()+":연결 접속했습니다.");
            }
             //2. 서버에서 메시지로 받기
            wsocket.onmessage=function(evt){
                var data=evt.data; //메시지를 받음..
                var user=data.split(":")
                if(user[0]==$("#group").val()) {
                          
                   //메시지만 전달 처리
                   revMsg(user[1]+":"+user[2]);
                }
               // $("#chatMessageArea").append(data+"<br>");
             }
             //3.서버에 종료 처리
             wsocket.onclose=function(){
                alert("접속을 종료합니다!");
                $("#chatMessageArea").text("");
                $("#id").val("").focus();
             }
         }
       });
      //.send()는 서버의 handleTextMessage와 연동
      $("#sendBtn").click(function(){
         sendMsg();
      });
      $("#msg").keyup(function(e){
         if(e.keyCode==13){
            sendMsg();
         }
      });
      $("#exitBtn").click(function(){
         wsocket.send($("#group").val()+"msg:"+$("#id").val()+":연결 종료합니다.");
         wsocket.close();
      })
      
      function sendMsg(){
         var id=$("#id").val();
         var msg=$("#msg").val();
         wsocket.send($("#group").val()+":"+
               id+":"+msg);
         $("#msg").val("");
      }
      function revMsg(msg){
         $("#chatMessageArea").append(msg+"<br>");
         //자동 스크롤링처리 (메시지 내용)
         var mx=parseInt( $("#chatMessageArea").height());
         $("#chatArea").scrollTop(mx);
         
         
         
         
      }
   });
   //http://localhost/springweb/chatting.do
</script>
</head>
<div class="jumbotron text-center">
	<h2></h2>
</div>
<div class="container">
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">그룹/아이디</span>
		</div>
		<input id="group" class="form-control" placeholder="그룹을 입력하세요" /> <input
			id="id" class="form-control" placeholder="접속할 아이디를 입력하세요." /> <input
			type="button" class="btn btn-info" value="채팅입장" id="enterBtn" />&nbsp;
		<input type="button" class="btn btn-success" value="나가기" id="exitBtn" />
	</div>


	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">메시지</span>
		</div>
		<input id="msg" class="form-control" placeholder="보낼 메시지 입력하세요" /> <input
			type="button" class="btn btn-info" value="전송" id="sendBtn" />
	</div>

	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">내 용</span>
		</div>

		<!-- #chatArea -->
		<div id="chatArea" class="input-group-append">
			<div id="chatMessageArea"></div>
		</div>
	</div>
</div>
</body>
</html>