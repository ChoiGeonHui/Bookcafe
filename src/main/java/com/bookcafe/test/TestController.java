package com.bookcafe.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@Controller
public class TestController {
	
	@Autowired
	UserBO userBO;
	
	
	@RequestMapping("/test1")
	public String helloworld() {
		return "test/ex1";
	}
	
	
	@RequestMapping("/test2")
	@ResponseBody
	public Map<String, String> helloworld2() {
		Map<String, String> list = new HashMap<>();
		
		list.put("sert", "list");
		
		return list;
	}
	
	@RequestMapping("/test3")
	@ResponseBody
	public User helloworld3() {
		User user = userBO.selectTest();
		return user;
	}
	
	
	
	
	
	

}
