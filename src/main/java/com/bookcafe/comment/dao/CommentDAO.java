package com.bookcafe.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	//해당 게시물 댓글 출력
	public List<Comment> selectCommentByPostId(
			@Param("postId") int postId);
	
	//댓글 작성
	public int insertComment(
			@Param("postId") int postId,
			@Param("userId") int userId,
			@Param("userName") String userName,
			@Param("content") String content
			); 
	
	//댓글 삭제
	public int deleteComment(
			@Param("id") int id,
			@Param("postId") int postId,
			@Param("userId") int userId
			);
	
	//삭제된 게시물 댓글 삭제
	public void deleteCommentByPostId(
			@Param("postId") int postId
			);

}
