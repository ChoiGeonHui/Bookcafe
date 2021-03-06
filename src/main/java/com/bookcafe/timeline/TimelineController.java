package com.bookcafe.timeline;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookcafe.hate.bo.HateBO;
import com.bookcafe.post.bo.PostBO;
import com.bookcafe.timeline.bo.ContentBO;
import com.bookcafe.timeline.domain.Content;
import com.bookcafe.timeline.domain.User2;
import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@Controller
@RequestMapping("/bookcafe")
public class TimelineController {
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private ContentBO contentBO;

	/**메인 페이지
	 * 
	 * @param model
	 * @param request
	 * @param search
	 * @param pageTag
	 * @param prevIdParm
	 * @param nextIdParm
	 * @return
	 */
	@RequestMapping("/main")
	public String mainpage(Model model,
			HttpServletRequest request,
			@RequestParam(value = "search",required = false) String search,
			@RequestParam(value = "tag",required = false) String pageTag
			) {

		Integer userId = null;
		HttpSession session = request.getSession();
		userId = (Integer) session.getAttribute("userId");	

		if (userId == null) {	
			return "redirect:/user/user_signin_view";
		}
		
		List<Content> list = contentBO.contentList(userId,pageTag,search);		
		User user = userBO.selectUser(userId);
		
		model.addAttribute("tag", pageTag);		
		model.addAttribute("search", search);		
		model.addAttribute("userId", userId);		
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("page", "main/timeline");
		return "templete/layout";
	}
	
	/**
	 *유저 항목
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/userlist")
	public String userListView(Model model,
			HttpServletRequest request) {
		
		Integer userId = null;

		HttpSession session = request.getSession();
		userId = (Integer) session.getAttribute("userId");
		
		User user = userBO.selectUser(userId);
		
		if (userId == null) {	
			return "redirect:/user/user_signin_view";
		}
		
		if(!user.getUserClass().equals("admin")) {
			return "redirect:/bookcafe/main";
		}		
		
		List<User2> list = contentBO.selectUser2();
		model.addAttribute("userId", userId);
		model.addAttribute("user", user);
		model.addAttribute("page", "main/userList");
		model.addAttribute("userlist", list);
		return "templete/layout";
		
	}

}
