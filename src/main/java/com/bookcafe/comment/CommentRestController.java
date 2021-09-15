package com.bookcafe.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.comment.bo.CommentBO;
import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@RestController
@RequestMapping("/comment")
public class CommentRestController {
	
	@Autowired
	UserBO userBO;
	
	@Autowired
	CommentBO commentBO;
	
	@RequestMapping("/write_comment")
	public Map<String, String> writeComment(
			@RequestParam("postId") int postId,
			@RequestParam("content") String content,
			HttpServletRequest request){
		Map<String, String> result = new HashMap<String, String>();
		HttpSession session = request.getSession();
		Integer userId = null;
		
		userId = (Integer) session.getAttribute("userId");
		if(userId == null) {
			result.put("result", "fail");
			return result;
		}
		
		User user = userBO.selectUser(userId);
		
		int row = commentBO.insertCommet(postId, userId, user.getName(), content);
		
		if(row>0) {
			result.put("result", "success");
		}

		return result;
		
	}
	@RequestMapping("/delete_comment")
	public Map<String, String> deleteComment(
			@RequestParam("id") int id,
			@RequestParam("postId") int postId,
			HttpServletRequest request){
		Map<String, String> result = new HashMap<String, String>();
		HttpSession session = request.getSession();
		Integer userId = null;
		
		userId = (Integer) session.getAttribute("userId");
		if(userId == null) {
			result.put("result", "fail");
			return result;
		}
		
		int row = commentBO.deleteCommet(id, postId, userId);
		
		if(row==1) {
			result.put("result", "success");
		}
		
		return result;
		
	}

}
