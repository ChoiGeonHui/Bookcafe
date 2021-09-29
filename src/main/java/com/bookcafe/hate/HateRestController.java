package com.bookcafe.hate;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.hate.bo.HateBO;

@RestController
@RequestMapping("/hate")
public class HateRestController {
	
	@Autowired
	private HateBO hateBO;
	
	
	/**
	 * 신고하기
	 * @param subjectId
	 * @param request
	 * @return
	 */
	@RequestMapping("/hate")
	public Map<String, String> insertHate(
			@RequestParam("subjectId") int subjectId,
			HttpServletRequest request
			){
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		Map<String, String> result = new HashMap<>();
		
		if(userId == null) {
			result.put("result", "getId");
			return result;
		}
		
		int chkRow = hateBO.selectHate(userId, subjectId);
		
		if(chkRow>0) {
			result.put("result", "hated");
			return result;
		}
		
		int insertRow = hateBO.insertHate(userId, subjectId);
		if(insertRow > 0) {
			result.put("result", "success");
		}		
		return result;
	}
	
	

}
