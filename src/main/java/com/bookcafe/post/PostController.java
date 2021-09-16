package com.bookcafe.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookcafe.timeline.bo.ContentBO;
import com.bookcafe.timeline.domain.Content;
import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	UserBO userBO;
	
	@Autowired
	ContentBO contentBO;
	
	
	@RequestMapping("/post_create_view")
	public String postcreate(Model model) {
		
		model.addAttribute("page", "post/postcreate");
		
		return "templete/layout";
		
	}
	
	@RequestMapping("/post_detail_view")
	public String postdetail(Model model,
			@RequestParam("postId") int postId,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer userId =(Integer) session.getAttribute("userId");
			
		if(userId==null) {
			return "redirect:/user/user_signin_view";
		}
		
		User user = userBO.selectUser(userId);
		
		Content postContent = contentBO.selectContent(userId,postId);
		
		model.addAttribute("userId", (int) userId);
		model.addAttribute("user", user);
		model.addAttribute("content", postContent);
		model.addAttribute("page", "post/postdetail");
		
		return "templete/layout";
		
	}
	
	
	@RequestMapping("/post_update_view")
	public String postupdate(Model model,
			@RequestParam("postId") int postId,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer userId =(Integer) session.getAttribute("userId");
		
		
		if(userId==null) {
			return "redirect:/user/user_signin_view";
		}
		
		Content postContent = contentBO.selectContent(userId,postId);
		
		model.addAttribute("userId", (int) userId);
		model.addAttribute("content", postContent);
		model.addAttribute("page", "post/postupdate");
		
		return "templete/layout";
		
	}

}
