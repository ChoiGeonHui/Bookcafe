package com.bookcafe.buy.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookcafe.buy.dao.BuyDAO;

@Service
public class BuyBO {
	
	@Autowired
	private BuyDAO buyDAO;
	
	//해당게시물 구입여부
	public boolean checkBuyed(int userId,int postId) {
		int row = buyDAO.selectByUserIdPostId(userId,postId);	
		return row>0? true:false;
	};
	
	//게시물 구입
	public int insertPost(int userId,int postId,int price) {
		return buyDAO.insertBuylist(userId, postId, price);
	}
	
	//게시물 삭제
	public void deleteBuyByPostId(int postId) {
		buyDAO.deleteBuyByPostId(postId);
	}
	
}
