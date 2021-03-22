package springweb2.mvc.dao;

import java.util.ArrayList;
import java.util.HashMap;

import springweb2.z02_vo.Dept;
import springweb2.z02_vo.Emp;
import springweb2.z02_vo.EmpDept;

public interface A01_EmpDao {
	
	public ArrayList<Emp> emplist(Emp sch);
	public int totCnt();
	public Emp getEmp(int empno);
	public ArrayList<Integer> searchEmp3(HashMap<String, Integer> hm);
	public void empInsert(Emp dto);
	public ArrayList<EmpDept> schEDGList(EmpDept sch);
	public ArrayList<String> getJobs();
	public ArrayList<Emp> getMgrs();
	public ArrayList<Dept> getDepts();
}
