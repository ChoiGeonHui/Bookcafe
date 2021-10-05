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
	
	/**
	 * 게시물 구매
	 * @param postId
	 * @param createrId
	 * @param price
	 * @param request
	 * @return
	 */
	@PostMapping("/pay")
	public Map<String, String> payPost(
			@RequestParam("postId") int postId,
			@RequestParam("createrId") int createrId,
			@RequestParam("price") int price,	
			HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Map<String, String> result = new HashMap<String, String>();	
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId == null) {
			result.put("result", "fail");
			return result;
		}
		
		
		User user = userBO.selectUser(userId);	
		//잔액이 부족할 경우
		if((user.getPoint()-price)<0) {
			result.put("result", "noMoney");
			return result;
		}
		
		int row = buyBO.insertPost(userId, postId, price);
		int row2 = userBO.plusPointByUserId(createrId,price);
		int row3 = userBO.minusPointByUserId(userId,price);
		
		//모든 코트가 전부 실행 됐을경우
		if(row>0 && row2>0 && row3>0 ) {
			result.put("result", "success");		
		}		
		return result;
	}
	
	
	

}
