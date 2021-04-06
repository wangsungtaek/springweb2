package springweb2.mvc.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb2.mvc.service.A04_MailService;
import springweb2.z02_vo.Mail;

@Controller
@RequestMapping("/mail.do")
public class A04_mailCtrl {
	
	// http://localhost:7080/springweb2/mail.do?method=init
	@RequestMapping(params="method=init")
	public String init() {
		return "WEB-INF/views/a02_mvc/a04_mail.jsp";
	}
	
	@Autowired(required = false)
	private A04_MailService service;
	
	@RequestMapping(params="method=send")
	public String send(Mail send) throws MessagingException {
		System.out.println(send.getSubject());
		service.sendMail(send);
		// 메일 전송은 service단에서 처리
		return "WEB-INF/views/a02_mvc/a04_mail.jsp";
	}
}
