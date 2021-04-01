package springweb2.mvc.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import springweb2.z02_vo.Calendar;

@Repository
public interface A04_CalenDao {
	// springweb2.mvc.dao.A04_CalenDao
	public ArrayList<Calendar> calenList();
	public void insertCalendar(Calendar ins);
	public void updateCalendar(Calendar upd);
	public void deletaCalendar(int id);
}
