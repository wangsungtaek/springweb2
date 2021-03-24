package springweb2.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb2.mvc.dao.A03_AjaxDao;

@Service
public class A03_AjaxService {
	@Autowired(required = false)
	private A03_AjaxDao dao;
	
	public int schMember(String id) {
		return dao.schMember(id);
	}
}
