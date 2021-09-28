package com.bookcafe.timeline.domain;

import com.bookcafe.user.model.User;


//누적 신고수를 포함한 user테이블
public class User2 {
	
	private User user;
	private int hateCount;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getHateCount() {
		return hateCount;
	}
	public void setHateCount(int hateCount) {
		this.hateCount = hateCount;
	}
	
	

}
