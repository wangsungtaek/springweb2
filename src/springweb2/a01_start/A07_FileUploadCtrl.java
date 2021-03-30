package springweb2.a01_start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb2.z03_vo.Repository;

@Controller
public class A07_FileUploadCtrl {
	
	@Autowired(required = false)
	B02_FileUploadService service;
	
	@GetMapping("fileList.do")
	public String fileList(Model d) {
		d.addAttribute("fileList", service.fileList());
		return "WEB-INF/views/a01_start/a16_fileList.jsp";
	}
	
	@GetMapping("fileDown.do")
	public String download(@RequestParam("fname") String fname,
			Model d) {
		d.addAttribute("downloadFile", fname);
		return "downloadviewer";
	}
	// http://localhost:7080/springweb2/fileExp.do
	@GetMapping("fileExp.do")
	public String fileExp() {
		return "WEB-INF/views/a01_start/a15_fileExp.jsp";
	}
	
	@PostMapping("fileExp.do")
	public String fileExp1(Repository rep) {
		// 파일확인
		System.out.println(rep.getReport()[0].getOriginalFilename());
		// 파일 업로드 처리..
		service.insertFile(rep);
		
		return "WEB-INF/views/a01_start/a15_fileExp.jsp";
	}
	
}
