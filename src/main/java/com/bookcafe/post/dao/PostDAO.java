package com.bookcafe.post.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO {
	
	
	public int createPost(
			@Param("userId") int userId,
			@Param("tag") String tag,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath,
			@Param("price") int price
			);

}
