package com.bookcafe.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.post.model.Post;

@Repository
public interface PostDAO {
	
	//게시글 등록
	public int createPost(
			@Param("userId") int userId,
			@Param("tag") String tag,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath,
			@Param("price") Integer price
			);
	
	//게시글 수정
	public int updatePost(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("tag") String tag,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath,
			@Param("price") Integer price
			);
	
	//게시글 삭제
	public int deletePost(
			@Param("userId") int userId,
			@Param("postId") int postId
			);
	
	//게시글 선택
	public Post selectPostById(
			int  postId);
	
	//게시글 전체 가져오기
	public List<Post> selectPostList(
			@Param("tag") String tag,
			@Param("search") String serch);
	
	
	public Post selectPostByPostIdAndUserId(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
}
