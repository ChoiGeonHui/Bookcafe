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
	public User selectUser(int userId) {
		return userDAO.selectUser(userId);
	}	
	
	public int selectUserByloginId(String loginId) {
		return userDAO.selectUserByloginIdCheck(loginId);
	}
	
	public User LoginUser(String loginId,String password) {
		return userDAO.selectUserLogin(loginId, password);
	}
	
	public int insertUser(String loginId,String password,
			String name,String email) {
		return userDAO.insertUser(loginId, password, name, email);
	}
	
	public int plusPointByUserId(int userId, int point) {
		return userDAO.updatePlusPointByUserId(userId, point);
	}
	
	public int minusPointByUserId(int userId, int point) {
		return userDAO.updateMinusPointByUserId(userId, point);
	}
	
	public int updateUserByColumns(int userId, String password,String name,String email) {
		return userDAO.updateUserByColumns(userId, password, name, email);
	}
	
	public Integer findUser(String loginId,String name,String email) {
		return userDAO.findUserByLoginIdAndNameAndEmail(loginId, name, email);
	}

	public int updateUserByIdSetPassword(int id,String encrytpassword) {
		return userDAO.updateUserByIdSetPassword(id, encrytpassword);
	}
}
