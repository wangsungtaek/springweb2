package springweb2.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb2.mvc.service.A01_EmpService;
import springweb2.mvc.service.A02_DeptService;
import springweb2.mvc.service.A03_AjaxService;
import springweb2.z02_vo.Dept;
import springweb2.z02_vo.Emp;

@Controller
public class A03_AjaxController {
	@Autowired(required = false)
	private A01_EmpService service;
	@Autowired(required = false)
	private A02_DeptService dservice;
	@Autowired(required = false)
	private A03_AjaxService aservice;
	
	// http://localhost:7080:/springweb2/ajaxEmpForm.do
	@GetMapping("ajaxEmpForm.do")
	public String ajaxForm() {
		return "WEB-INF\\views\\a03_ajax\\a01_empAjax.jsp";
	}	
	
	// http://localhost:7080:/springweb2/jsonEmp.do
	@RequestMapping("jsonEmp.do")
	public String ajaxStart(Emp sch, Model d) {
		d.addAttribute("emp", service.emplist(sch));
		return "pageJsonReport";
	}
	
	// http://localhost:7080:/springweb2/ajaxDeptForm.do
	@GetMapping("ajaxDeptForm.do")
	public String ajaxDeptForm() {
		return "WEB-INF\\views\\a03_ajax\\a02_deptAjax.jsp";
	}	
	
	// http://localhost:7080:/springweb2/jsonDept.do
	@PostMapping("jsonDept.do")
	public String jonDept(Dept sch, Model d) {
		d.addAttribute("dept", dservice.deptList(sch));
		return "pageJsonReport";
	}
	
	// http://localhost:7080:/springweb2/regMemberForm.do
	@GetMapping("regMemberForm.do")
	public String regMemberForm() {
		return "WEB-INF\\views\\a03_ajax\\a03_regMember.jsp";
	}
	
	// hasMember.do?id=##
	// hasMember.do ==> id를 공백으로 처리 ""
	// http://localhost:7080:/springweb2/hasMember.do
	@RequestMapping("hasMember.do")
	public String hasMember(
			@RequestParam(value="id", defaultValue="")
				String id, Model d) {
		d.addAttribute("mCnt", aservice.schMember(id));
		return "pageJsonReport";
	}
}
