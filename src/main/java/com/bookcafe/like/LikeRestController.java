package com.bookcafe.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.like.bo.LikeBO;

@RestController
@RequestMapping("/like")
public class LikeRestController {
	
	@Autowired
	LikeBO likeBO;
	
	/**
	 * 추천 누르기
	 * @param postId
	 * @param request
	 * @return
	 */
	@RequestMapping("/like")
	public Map<String, String> likeOnOff(
			@RequestParam("postId") int postId,
			HttpServletRequest request){
		Map<String, String> result = new HashMap<String, String>();
		HttpSession session = request.getSession();
		Integer userId = null;	
		userId = (Integer) session.getAttribute("userId");
		
		if(userId==null) {
			result.put("result", "id");
			return result;
		}
		
		String row = likeBO.OnOffLikeById(postId, userId);
		
		if(row.equals("insert")) {
			result.put("result", "insert");	
		}else {
			result.put("result", "delete");	
		}
		
		return result;
	}
}
