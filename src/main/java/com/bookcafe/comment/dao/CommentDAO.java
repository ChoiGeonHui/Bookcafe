package com.bookcafe.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	public List<Comment> selectCommentByPostId(
			@Param("postId") int postId);
	
	
	public int insertComment(
			@Param("postId") int postId,
			@Param("userId") int userId,
			@Param("userName") String userName,
			@Param("content") String content
			); 
	
	public int deleteComment(
			@Param("id") int id,
			@Param("postId") int postId,
			@Param("userId") int userId
			);
	
	public void deleteCommentByPostId(
			@Param("postId") int postId
			);

}
