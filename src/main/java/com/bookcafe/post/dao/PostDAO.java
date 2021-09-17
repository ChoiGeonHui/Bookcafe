package com.bookcafe.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.post.model.Post;

@Repository
public interface PostDAO {
	
	//작성
	public int createPost(
			@Param("userId") int userId,
			@Param("tag") String tag,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath,
			@Param("price") Integer price
			);
	
	//수정
	public int updatePost(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("tag") String tag,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath,
			@Param("price") Integer price
			);
	
	//삭제
	public int deletePost(
			@Param("userId") int userId,
			@Param("postId") int postId
			);
	
	
	public Post selectPostById(
			int  postId);
	
	public List<Post> selectPostList(
			String tag);

}
