package com.bookcafe.timeline;

import java.util.List;

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
@RequestMapping("/bookcafe")
public class TimelineController {
	
	@Autowired
	private ContentBO contentBO;

	@RequestMapping("/main")
	public String mainpage(Model model,
			HttpServletRequest request,
			@RequestParam(value = "tag",required = false) String pageTag
			) {

		Integer userId = null;

		HttpSession session = request.getSession();
		userId = (Integer) session.getAttribute("userId");

		if (userId == null) {	
			return "redirect:/user/user_signin_view";
		}
		List<Content> list = contentBO.contentList(userId,pageTag);
		
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("userId", userId);		
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("page", "main/timeline");

		return "templete/layout";
	}

}
