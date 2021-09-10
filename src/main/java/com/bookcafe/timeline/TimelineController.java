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
		int userPoint = 0;

		HttpSession session = request.getSession();
		userId = (Integer) session.getAttribute("userId");

		if (userId == null) {	
			return "redirect:/user/user_signin_view";
		}

		String userloginId = (String) session.getAttribute("userloginId");
		String userName = (String) session.getAttribute("userName");
		String userEmail = (String) session.getAttribute("userEmail");
		userPoint = (Integer) session.getAttribute("userPoint");
		String userClass = (String) session.getAttribute("userClass");

		List<Content> list = contentBO.contentList(userId,pageTag);

		model.addAttribute("userId", userId);
		model.addAttribute("userloginId", userloginId);
		model.addAttribute("userName", userName);
		model.addAttribute("userEmail", userEmail);
		model.addAttribute("userPoint", userPoint);
		model.addAttribute("userClass", userClass);
		model.addAttribute("list", list);
		model.addAttribute("page", "main/timeline");

		return "templete/layout";
	}

}
