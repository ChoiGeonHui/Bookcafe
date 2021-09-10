package com.bookcafe.buy.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyDAO {
	
	public int selectByUserIdPostId(
			@Param("userId") int userId,
			@Param("postId") int postId
			);

}
