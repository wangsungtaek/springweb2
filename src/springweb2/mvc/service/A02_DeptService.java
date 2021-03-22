package springweb2.mvc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb2.mvc.dao.A02_DeptDao;
import springweb2.z02_vo.Dept;

@Service
public class A02_DeptService {
	
	@Autowired(required = false)
	A02_DeptDao dao;
	
	// 읽기
	public ArrayList<Dept> deptList(Dept sch){
		if(sch.getDname() == null) sch.setDname("");
		if(sch.getLoc() == null) sch.setLoc("");
		return dao.deptList(sch);
	}
	// 추가
	public void insertDept(Dept dept) {
		if(dept.getDeptno() > 0)
			dao.insertDept(dept);
	}
	// 삭제
	public boolean deleteDept(int deptno) {
		return dao.deleteDept(deptno);
	}
	// 수정
	public boolean updateDept(Dept dept) {
		return dao.updateDept(dept);
	}
}
