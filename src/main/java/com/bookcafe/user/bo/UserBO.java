package com.bookcafe.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookcafe.user.dao.UserDAO;
import com.bookcafe.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	UserDAO userDAO;
	
	public User selectTest() {
		return userDAO.selectTest();
	}
	
	
	public int selectUserByloginId(String loginId) {
		return userDAO.selectUserByloginIdCheck(loginId);
	}
	
	public int insertUser(String loginId,String password,
			String name,String email) {
		return userDAO.insertUser(loginId, password, name, email);
	}

}
