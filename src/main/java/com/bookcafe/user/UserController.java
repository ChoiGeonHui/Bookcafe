package com.bookcafe.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserBO userBO;
	
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
	
	
	//포인트 충전
	@RequestMapping("/user_point_view")
	public String point(Model model) {
		model.addAttribute("page", "point/point");
		return "templete/layout";
	}
	
	
	//사용자 정보 변경
	@RequestMapping("/user_update_view")
	public String updateUser(Model model) {
		model.addAttribute("page", "user/updateUser");
		return "templete/layout";
	}
	
	
	//유저 갱신
	@RequestMapping("/update")
	public String update(Model model,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userBO.selectUser(userId);
		
		session.setAttribute("userLoginId", user.getLoginId());
		session.setAttribute("userName", user.getName());
		session.setAttribute("userEmail", user.getEmail());
		session.setAttribute("userPoint", user.getPoint());
		
		
		return "redirect:/bookcafe/main";
	}
	


}
