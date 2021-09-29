package com.bookcafe.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	//ÇØ´ç °Ô½Ã¹° ´ñ±ÛÃâ·Â
	public List<Comment> selectCommentByPostId(
			@Param("postId") int postId);
	
	//´ñ±Û ÀÛ¼º
	public int insertComment(
			@Param("postId") int postId,
			@Param("userId") int userId,
			@Param("userName") String userName,
			@Param("content") String content
			); 
	
	//´ñ±Û »èÁ¦
	public int deleteComment(
			@Param("id") int id,
			@Param("postId") int postId,
			@Param("userId") int userId
			);
	
	//»èÁ¦µÈ °Ô½Ã¹° ´ñ±Û »èÁ¦
	public void deleteCommentByPostId(
			@Param("postId") int postId
			);

}
