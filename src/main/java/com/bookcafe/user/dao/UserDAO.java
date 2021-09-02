package com.bookcafe.user.dao;

import org.springframework.stereotype.Repository;

import com.bookcafe.user.model.User;

@Repository
public interface UserDAO {
	
	public User selectTest();

}
