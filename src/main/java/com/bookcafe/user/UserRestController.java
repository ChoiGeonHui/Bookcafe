package com.bookcafe.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.common.EncryptUtils;
import com.bookcafe.user.bo.UserBO;

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

}
