package com.bookcafe.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookcafe.comment.dao.CommentDAO;
import com.bookcafe.comment.model.Comment;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentDAO;
	
	public List<Comment> selectComment(int postId){
		return commentDAO.selectCommentByPostId(postId);
	}
	
	public int insertCommet(int postId,int userId,String userName,String content) {
		return commentDAO.insertComment(postId, userId, userName, content);
	}
	
	public int deleteCommet(int id,int postId,int userId) {
		return commentDAO.deleteComment(id,postId, userId);
	}

}
