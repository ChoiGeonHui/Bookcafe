package com.bookcafe.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bookcafe.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	public List<Comment> selectCommentByPostId(
			@Param("postId") int postId);

}
