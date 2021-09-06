package com.bookcafe.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//회원가입
	@RequestMapping("/user_signup_view")
	public String sign_up(Model model) {
		
		model.addAttribute("page", "user/signup");
		return "templete/layout";
	}
	
	//로그인
	@RequestMapping("/user_signin_view")
	public String sign_in(Model model) {
		
		model.addAttribute("page", "user/signin");
		return "templete/layout";
	}
	
	//로그아웃
	@RequestMapping("/user/log_out")
	public String log_out(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		session.removeAttribute("userEmail");
		session.removeAttribute("point");
		
		
		
		return "redirect:/user/user_signin_view";
	
	}
	


}
