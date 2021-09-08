package com.bookcafe.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
	
	
	@RequestMapping("/post_create_view")
	public String postcreate(Model model) {
		
		model.addAttribute("page", "post/postcreate");
		
		return "templete/layout";
		
	}

}
