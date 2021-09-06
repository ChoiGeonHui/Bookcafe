package com.bookcafe.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.common.EncryptUtils;
import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	//아이디 중복확인
	@PostMapping("/user_IdCheck")
	public Map<String, String> checkId(
			@RequestParam("loginId") String loginId){	
		Map<String, String> result = new HashMap<String, String>();		
		int row = userBO.selectUserByloginId(loginId);	
		if(row==0) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");	
		}
		
		return result;
		
	}
	
	//회원가입 유저db추가
	@PostMapping("/user_sign_up")
	public Map<String, String> signup(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email
			){
		
		Map<String, String> result = new HashMap<String, String>();
		String encrytpassword = EncryptUtils.md5(password);
		
		int row= userBO.insertUser(loginId, encrytpassword, name, email);
		
		
		if(row>0) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
			
		}
		
		return result;
	}
	
	
	/**
	 * 로그인
	 * @param loginId
	 * @param password
	 * @param request
	 * @return
	 */
	@PostMapping("/user_sign_in")
	public Map<String, String> signin(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request
			){
		
		Map<String, String> result = new HashMap<String, String>();

		String EncryptPassword = EncryptUtils.md5(password);
		
		User user = userBO.LoginUser(loginId, EncryptPassword);
		
		HttpSession session = request.getSession();
		if(user != null) {
			result.put("result", "success");
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userEmail", user.getEmail());
			session.setAttribute("userPoint", user.getPoint());
			
		}else {
			result.put("result", "fail");
		}
		
		
		return result;
	}

}
