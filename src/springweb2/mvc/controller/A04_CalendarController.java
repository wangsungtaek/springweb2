package springweb2.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb2.mvc.service.A04_CalenService;

@Controller
@RequestMapping("calendar.do")
public class A04_CalendarController {
	
	@Autowired(required = false)
	private A04_CalenService service;
	
	// http://localhost:7080/springweb2/calendar.do?method=list
	@GetMapping(params="method=list")
	public String list() {
		return "WEB-INF/views/a03_ajax/a04_fullcalendar.jsp";
	}
	// http://localhost:7080/springweb2/calendar.do?method=data
	@GetMapping(params="method=data")
	public String data(Model d) {
		d.addAttribute("list", service.calenList());
		return "pageJsonReport";
	}
}
