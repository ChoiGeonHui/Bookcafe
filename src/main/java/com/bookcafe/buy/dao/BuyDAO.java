package com.bookcafe.buy.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyDAO {
	
	//구매 확인
	public int selectByUserIdPostId(
			@Param("userId") int userId,
			@Param("postId") int postId
			);
	
	//구매하기
	public int insertBuylist(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("price") int price
			);
	
	//삭제
	public void deleteBuyByPostId(int postId);
}
