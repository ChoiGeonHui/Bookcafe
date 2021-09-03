package com.bookcafe.timeline;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookcafe")
public class TimelineController {
	
	@RequestMapping("/main")
	public String mainpage(Model model) {
		model.addAttribute("page", "main/timeline");
		
		return "templete/layout";
	}

}
