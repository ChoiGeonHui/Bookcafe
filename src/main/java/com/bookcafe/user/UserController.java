package com.bookcafe.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserBO userBO;
	
	/**
	 * 회원가입
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/user_signup_view")
	public String sign_up(Model model,
			HttpServletRequest request) {
		
		HttpSession session =request.getSession();
		
		Integer userId =(Integer) session.getAttribute("userId");
		if(userId!=null) {
			return "redirect:/bookcafe/main";
		}
		
		model.addAttribute("page", "user/signup");
		return "templete/layout";
	}
	
	/**
	 * 로그인
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/user_signin_view")
	public String sign_in(Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Integer userId = (Integer)session.getAttribute("userId");
		if(userId !=null) {
			return "redirect:/bookcafe/main";
		}
		
		model.addAttribute("page", "user/signin");
		return "templete/layout";
	}
	
	/**
	 * 로그아웃
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/log_out")
	public String log_out(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		session.removeAttribute("userPoint");	
		session.removeAttribute("userClass");	
		
		return "redirect:/user/user_signin_view";
	
	}
	
	
	/**
	 * 포인트 충전
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/user_point_view")
	public String point(Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Integer userId = (Integer) session.getAttribute("userId");
		User user = (User) session.getAttribute("user");
		if(userId==null) {
			return "redirect:/user/user_signin_view";
		}
		
		model.addAttribute("userId", userId);
		model.addAttribute("user", user);
		model.addAttribute("page", "point/point");
		return "templete/layout";
	}
	
	
	/**
	 * 사용자 정보 변경
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/user_update_view")
	public String updateUser(Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Integer userId = (Integer) session.getAttribute("userId");
		User user = (User) session.getAttribute("user");
		if(userId==null) {
			return "redirect:/user/user_signin_view";
		}
		model.addAttribute("userId", userId);
		model.addAttribute("user", user);
		model.addAttribute("page", "user/updateUser");
		return "templete/layout";
	}
	
	
	/**
	 * 유저 갱신
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Model model,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userBO.selectUser(userId);
		
		session.setAttribute("userId", userId);
		session.setAttribute("user", user);
			
		return "redirect:/bookcafe/main";
	}
	
	
	@RequestMapping("/user_find_view")
	public String user_find(Model model) {	
		model.addAttribute("page", "user/userFind");
		return "templete/layout";
	}
	
	@RequestMapping("/user_updatePassword")
	public String user_updatePassword(
			@RequestParam("id") int id,
			Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("page", "user/findPassword");
		return "templete/layout";
	}


}
