package com.bookcafe.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.user.model.User;

@Repository
public interface UserDAO {
	
	public User selectTest();
	
	
	
	public User selectUser(int userId);
	
	
	//아이디 중복확인
	public int selectUserByloginIdCheck(
			@Param("loginId") String loginId);
	
	//로그인
	public User selectUserLogin(
			@Param("loginId") String loginId,
			@Param("password") String password);
	
	
	
	//회원가입
	public int insertUser(
			@Param("loginId") String loginId,
			@Param("password") String password,
			@Param("name") String name,
			@Param("email") String email);
	
	
	//사용자포인트 증가
	public int updatePlusPointByUserId(
			@Param("userId") int userId,
			@Param("point") int point);
	
	
	//회원 정보 수정
	public int updateUserByColumns(
			@Param("userId") int userId,
			@Param("password") String password,
			@Param("name") String name,
			@Param("email") String email
			);
	
}
