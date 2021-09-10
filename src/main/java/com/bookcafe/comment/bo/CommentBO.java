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

}
