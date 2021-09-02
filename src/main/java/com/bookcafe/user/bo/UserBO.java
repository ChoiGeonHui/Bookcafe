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

}
