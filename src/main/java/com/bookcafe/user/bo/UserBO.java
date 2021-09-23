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
	
	//테스트
	public User selectTest() {
		return userDAO.selectTest();
	}
	
	//단일유저 선택
	public User selectUser(int userId) {
		return userDAO.selectUser(userId);
	}
	
	//유저 리스트
	public List<User> selectUserList() {
		return userDAO.selectUserList();
	}
	
	
	//아이디 중복확인
	public int selectUserByloginId(String loginId) {
		return userDAO.selectUserByloginIdCheck(loginId);
	}
	//로그인
	public User LoginUser(String loginId,String password) {
		return userDAO.selectUserLogin(loginId, password);
	}
	
	//회원가입
	public int insertUser(String loginId,String password,
			String name,String email) {
		return userDAO.insertUser(loginId, password, name, email);
	}
	
	//포인트 충전
	public int plusPointByUserId(int userId, int point) {
		return userDAO.updatePlusPointByUserId(userId, point);
	}
	
	//포인트 차감
	public int minusPointByUserId(int userId, int point) {
		return userDAO.updateMinusPointByUserId(userId, point);
	}
	
	//유저정보 수정
	public int updateUserByColumns(int userId, String password,String name,String email) {
		return userDAO.updateUserByColumns(userId, password, name, email);
	}
	
	//유저 인증
	public Integer findUser(String loginId,String name,String email) {
		return userDAO.findUserByLoginIdAndNameAndEmail(loginId, name, email);
	}
	
	//비밀번호 변경
	public int updateUserByIdSetPassword(int id,String encrytpassword) {
		return userDAO.updateUserByIdSetPassword(id, encrytpassword);
	}
	
	//회원 탈퇴
	public int updateUserExceptById(int id) {
		return userDAO.updateUserExceptById(id);
	}
	
}
