package springweb2.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb2.mvc.dao.A01_EmpDao;
import springweb2.z02_vo.Dept;
import springweb2.z02_vo.Emp;
import springweb2.z02_vo.EmpDept;

@Service
public class A01_EmpService {
	
	@Autowired(required = false)
	private A01_EmpDao dao;
	
	public ArrayList<Emp> emplist(Emp sch){
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		
		System.out.println("데이터 건수 : "+dao.totCnt());
		System.out.println("## emp객체 : "+dao.getEmp(7499).getEname());
		HashMap<String , Integer> hm = new HashMap<String, Integer>();
		
		hm.put("start", 1000);
		hm.put("end", 3000);
		System.out.println("검색된 사원 번호");
		for(int empno : dao.searchEmp3(hm)) {
			System.out.println(empno);
		}
		 
		return dao.emplist(sch);
	}
	public void empInsert(Emp dto) {
		dao.empInsert(dto);
	}
	
	public ArrayList<EmpDept> schEDGList(EmpDept sch){
		return dao.schEDGList(sch);
	}
	
	public ArrayList<String> getJobs(){
		
		return dao.getJobs();
	}
	public ArrayList<Emp> getMgrs(){
		
		return dao.getMgrs();
	}
	public ArrayList<Dept> getDepts() {
		
		return dao.getDepts();
	}

}
