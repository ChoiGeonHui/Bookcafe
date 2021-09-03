package com.bookcafe.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping("/user_signup_view")
	public String sign_up(Model model) {
		
		model.addAttribute("page", "user/signup");
		return "templete/layout";
	}
	
	


}
