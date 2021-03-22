package springweb2.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb2.mvc.service.A02_DeptService;
import springweb2.z02_vo.Dept;

@Controller("/")
public class A02_DeptController {
	
	@Autowired(required = false)
	A02_DeptService service;
	
	// http://localhost:7080/springweb2/dept
	@RequestMapping("dept.do")
	public String dept(@ModelAttribute("dept") Dept dept, Model d) {
		d.addAttribute("list", service.deptList(dept));
		return "/WEB-INF/views/deptList.jsp";
	}
	
	@RequestMapping("deptReg.do")
	public String deptReg(@ModelAttribute("dept") Dept dept, Model d) {
		boolean result;
		if(dept.getDeptno() > 0) {
			service.insertDept(dept);
			result = true;
			d.addAttribute("result", result);
		}
		return "/WEB-INF/views/deptReg.jsp";
	}
}
