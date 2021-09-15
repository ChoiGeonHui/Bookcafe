package com.bookcafe.buy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.buy.bo.BuyBO;
import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@RestController
@RequestMapping("/buy")
public class BuyRestController {
	
	@Autowired
	private BuyBO buyBO;
	
	@Autowired
	private UserBO userBO;
	
	
	@PostMapping("/pay")
	public Map<String, String> payPost(
			@RequestParam("postId") int postId,
			@RequestParam("price") int price,	
			@RequestParam("createrId") int createrId,
			HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Map<String, String> result = new HashMap<String, String>();	
		Integer userId =(Integer) session.getAttribute("userId");
		
		if(userId == null) {
			result.put("result", "fail");
			return result;
		}
		
		
		User user = userBO.selectUser(userId);	
		//잔액이 부족할때
		if((user.getPoint()-price)<0) {
			result.put("result", "noMoney");
			return result;
		}
		
		int row = buyBO.insertPost(userId, postId, price);
		int row2 = userBO.plusPointByUserId(createrId,price);
		int row3 = userBO.minusPointByUserId(userId,price);
		
		if((row+row2+row3) ==3 ) {
			result.put("result", "success");		
		}		
		return result;
	}
	
	
	

}
