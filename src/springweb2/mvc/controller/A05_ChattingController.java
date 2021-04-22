package springweb2.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A05_ChattingController {
	
	// http://localhost:7080/springweb2/chatting.do
	// 채팅 초기 화면 구현.
	@RequestMapping("/chatting.do")
	public String chatting() {
		return "WEB-INF/views/a02_mvc/a05_chatting.jsp";
	}
}
