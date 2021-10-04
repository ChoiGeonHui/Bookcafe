package com.bookcafe.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookcafe.user.dao.UserDAO;
import com.bookcafe.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	UserDAO userDAO;
	
	
	//�׽�Ʈ
	public User selectTest() {
		return userDAO.selectTest();
	}
	
	//�������� ����
	public User selectUser(int userId) {
		return userDAO.selectUser(userId);
	}
	
	//���� ����Ʈ
	public List<User> selectUserList() {
		return userDAO.selectUserList();
	}
	
	
	//���̵� �ߺ�Ȯ��
	public int selectUserByloginId(String loginId) {
		return userDAO.selectUserByloginIdCheck(loginId);
	}
	//�α���
	public User LoginUser(String loginId,String password) {
		return userDAO.selectUserLogin(loginId, password);
	}
	
	//ȸ������
	public int insertUser(String loginId,String password,
			String name,String email,String userClass) {
		return userDAO.insertUser(loginId, password, name, email,userClass);
	}
	
	//����Ʈ ����
	public int plusPointByUserId(int userId, int point) {
		return userDAO.updatePlusPointByUserId(userId, point);
	}
	
	//����Ʈ ����
	public int minusPointByUserId(int userId, int point) {
		return userDAO.updateMinusPointByUserId(userId, point);
	}
	
	//�������� ����
	public int updateUserByColumns(int userId, String password,String name,String email) {
		return userDAO.updateUserByColumns(userId, password, name, email);
	}
	
	//���� ����
	public Integer findUser(String loginId,String name,String email) {
		return userDAO.findUserByLoginIdAndNameAndEmail(loginId, name, email);
	}
	
	//��й�ȣ ����
	public int updateUserByIdSetPassword(int id,String encrytpassword) {
		return userDAO.updateUserByIdSetPassword(id, encrytpassword);
	}
	
	//ȸ�� Ż��
	public int updateUserExceptById(int id) {
		return userDAO.updateUserExceptById(id);
	}
	
	//ȸ�� ���Ѻ���
	public int updateUserClass(int id,String userClass) {
		return userDAO.updateUserClass(id, userClass);
	}
	
}
