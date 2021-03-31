package springweb2.mvc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb2.mvc.dao.A04_CalenDao;
import springweb2.z02_vo.Calendar;

@Service
public class A04_CalenService {
	@Autowired(required = false)
	private A04_CalenDao dao;
	
	public ArrayList<Calendar> calenList(){
		return dao.calenList();
	}
	
	public void insertCalendar(Calendar cal) {
		dao.insertCalendar(cal);
	}
}
