package com.bookcafe.buy.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookcafe.buy.dao.BuyDAO;

@Service
public class BuyBO {
	
	@Autowired
	private BuyDAO buyDAO;
	
	public boolean checkBuyed(int userId,int postId) {
		int row = buyDAO.selectByUserIdPostId(userId,postId);
		
		return row>0? true:false;
	};
	
	
	public int insertPost(int userId,int postId,int price) {
		return buyDAO.insertBuylist(userId, postId, price);
	}
	
}
