package com.bookcafe.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.post.model.Post;

@Repository
public interface PostDAO {
	
	
	public int createPost(
			@Param("userId") int userId,
			@Param("tag") String tag,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath,
			@Param("price") Integer price
			);
	
	public int updatePost(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("tag") String tag,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath,
			@Param("price") Integer price
			);
	
	public Post selectPostById(
			int  postId);
	
	public List<Post> selectPostList(
			String tag);

}
