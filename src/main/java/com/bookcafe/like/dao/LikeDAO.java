package com.bookcafe.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {
	
	public int selectlikeByPostId(int postId);
	
	public int selectlikeByPostIdboolean(
			@Param("postId") int postId,
			@Param("userId") int userId
			);
}
