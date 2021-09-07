package com.bookcafe.timeline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/bookcafe")
public class TimelineController {
	
	
	
	@RequestMapping("/main")
	public String mainpage(Model model,
			HttpServletRequest request) {
		
		
		
		Integer userId = null;
		int userPoint = 0;
		
		HttpSession session = request.getSession();
		 userId =(Integer) session.getAttribute("userId");
		 String userloginId =(String) session.getAttribute("userloginId");
		 String userName =(String) session.getAttribute("userName");
		 String userEmail =(String) session.getAttribute("userEmail");
		 userPoint =(Integer) session.getAttribute("userPoint");
		 String userClass = (String) session.getAttribute("userClass");
		
		model.addAttribute("userId", userId);
		model.addAttribute("userloginId", userloginId);
		model.addAttribute("userName", userName);
		model.addAttribute("userEmail", userEmail);
		model.addAttribute("userPoint", userPoint);
		model.addAttribute("page", "main/timeline");
		
		return "templete/layout";
	}
	
	
	

}
