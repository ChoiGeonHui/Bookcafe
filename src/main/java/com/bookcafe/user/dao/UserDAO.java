package com.bookcafe.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.user.model.User;

@Repository
public interface UserDAO {
	
	public User selectTest();
	
	
	
	public int selectUserByloginIdCheck(
			@Param("loginId") String loginId);
	
	
	public int insertUser(
			@Param("loginId") String loginId,
			@Param("password") String password,
			@Param("name") String name,
			@Param("email") String email);
}
