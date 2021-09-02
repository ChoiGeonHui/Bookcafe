package com.bookcafe.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test1")
	public String helloworld() {
		return "test/ex1";
	}
	

}
