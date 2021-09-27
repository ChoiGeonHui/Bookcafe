package com.bookcafe.hate.bo;

import java.util.List;
import java.util.Map;

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
	public int selectHateBySubjectId(int subjectId) {
		return hateDAO.selectHateBySubjectId(subjectId);
	}
	
	public int insertHate(int userId, int subjectId) {
		return hateDAO.insertHate(userId, subjectId);
	}

}
