package springweb2.mvc.dao;

import java.util.ArrayList;

import springweb2.z02_vo.Dept;

public interface A02_DeptDao {
	public ArrayList<Dept> deptList(Dept dept);
	public void insertDept(Dept dept);
	public boolean deleteDept(int deptno);
	public boolean updateDept(Dept dept);
}
