package com.bookcafe.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookcafe.post.bo.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	@Autowired
	private PostBO postBO;

	
	@PostMapping("/post_create")
	public Map<String, String> postCreate(
			@RequestParam(value = "tag") String tag,
			@RequestParam("title") String title,
			@RequestParam(value = "content",required = false) String content,
			@RequestParam(value = "file", required = false)
			MultipartFile file,
			@RequestParam(value = "price", required = false) Integer price,
			HttpServletRequest request
			){
		HttpSession session = request.getSession();
		Integer userId = null;
		userId = (Integer) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		
		Map<String, String> result = new HashMap<String, String>();
		

		if(userId ==null) {
			result.put("result", "fail");
			return result;		
		}
		
		
		int row= postBO.createPost(userId, userName, tag, title, content, file, price);
		
		if(row>0) {
			result.put("result", "success");
		}
		
		return result;
	}
}
