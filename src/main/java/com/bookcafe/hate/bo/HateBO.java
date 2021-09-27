package com.bookcafe.hate.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookcafe.hate.dao.HateDAO;

@Service
public class HateBO {
	
	@Autowired
	private HateDAO hateDAO;
	
	public int selectHate(int userId, int subjectId) {
		return hateDAO.selectHateList(userId, subjectId);
	}
	
	public int insertHate(int userId, int subjectId) {
		return hateDAO.insertHate(userId, subjectId);
	}

}
