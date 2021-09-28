package com.bookcafe.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.post.model.Post;

@Repository
public interface PostDAO {
	
	//�옉�꽦
	public int createPost(
			@Param("userId") int userId,
			@Param("tag") String tag,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath,
			@Param("price") Integer price
			);
	
	//�닔�젙
	public int updatePost(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("tag") String tag,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath,
			@Param("price") Integer price
			);
	
	//�궘�젣
	public int deletePost(
			@Param("userId") int userId,
			@Param("postId") int postId
			);
	
	
	public Post selectPostById(
			int  postId);
	
	public List<Post> selectPostList(
			@Param("tag") String tag,
			@Param("search") String serch);

}
