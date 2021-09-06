package com.bookcafe.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.user.model.User;

@Repository
public interface UserDAO {
	
	public User selectTest();
	
	
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
}
