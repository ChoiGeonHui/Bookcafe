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
import com.bookcafe.timeline.bo.ContentBO;
import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	
	@Autowired
	private UserBO  userBO;
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private ContentBO contentBO;

	//게시물 작성
	@PostMapping("/post_create")
	public Map<String, String> postCreate(
			@RequestParam(value = "userName") String userName,
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
		//유저 이름 넣기
		userId = (Integer) session.getAttribute("userId");	
		Map<String, String> result = new HashMap<String, String>();
		
		if(userId ==null) {
			result.put("result", "fail");
			return result;		
		}
		
		if(tag.equals("�쑀猷�")) {
			 if(price==null) {
				 result.put("result", "price");
					return result;
			 }
		}	
		
		
		System.out.println("///////////////////file===="+file);
		
		int row= postBO.createPost(userId, userName, tag, title, content, file, price);
		
		if(row>0) {
			result.put("result", "success");
		}
		
		return result;
	}
	
	/**
	 * 게시물 수정
	 * @param postId
	 * @param tag
	 * @param title
	 * @param content
	 * @param file
	 * @param price
	 * @param request
	 * @return
	 */
	@PostMapping("/post_update")
	public Map<String, String> postUpdate(
			@RequestParam("postId") int postId,
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
		User user = userBO.selectUser(userId);
		Map<String, String> result = new HashMap<String, String>();
		
		
		if(userId ==null) {
			result.put("result", "fail");
			return result;		
		}
		
		if(tag.equals("유료")) {
			 if(price==null) {
				 result.put("result", "price");
					return result;
			 }
		}
		
		
		
		int row= postBO.updatePost(userId, user.getName(),postId, tag, title, content, file, price);
		
		if(row>0) {
			result.put("result", "success");
		}
		
		return result;
	}
	
	//게시물 삭제
	@RequestMapping("/post_delete")
	public Map<String, String> postDelete(
			@RequestParam("postId") int postId,
			HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Integer userId = null;	
		userId = (Integer) session.getAttribute("userId");	
		Map<String, String> result = new HashMap<String, String>();
		
		
		if(userId ==null) {
			result.put("result", "fail");
			return result;		
		}
		
		String  deleted = contentBO.deleteContent(userId, postId);
		
		if(deleted.equals("success")) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
			
		}
		return result;
	};
	

}
