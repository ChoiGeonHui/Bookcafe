package com.bookcafe.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.common.EncryptUtils;
import com.bookcafe.user.bo.UserBO;
import com.bookcafe.user.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	//아이디 중복확인
	@PostMapping("/user_IdCheck")
	public Map<String, String> checkId(
			@RequestParam("loginId") String loginId){	
		Map<String, String> result = new HashMap<String, String>();		
		int row = userBO.selectUserByloginId(loginId);	
		if(row==0) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");	
		}
		
		return result;
		
	}
	
	//회원가입 유저db추가
	@PostMapping("/user_sign_up")
	public Map<String, String> signup(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email
			){
		
		Map<String, String> result = new HashMap<String, String>();
		String encrytpassword = EncryptUtils.md5(password);
		
		int row= userBO.insertUser(loginId, encrytpassword, name, email);
		
		
		if(row>0) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
			
		}
		
		return result;
	}
	
	
	/**
	 * 로그인
	 * @param loginId
	 * @param password
	 * @param request
	 * @return
	 */
	@PostMapping("/user_sign_in")
	public Map<String, String> signin(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request
			){
		
		Map<String, String> result = new HashMap<String, String>();

		String EncryptPassword = EncryptUtils.md5(password);
		
		User user = userBO.LoginUser(loginId, EncryptPassword);
		HttpSession session = request.getSession();	
		
		if(user != null && !user.getUserClass().equals("except")) {
			result.put("result", "success");
			session.setAttribute("userId", user.getId());
			session.setAttribute("user", user);
			
		}else if(user.getUserClass().equals("except")){
			result.put("result", "except");
		}else {
			result.put("result", "fail");
		}
		
		
		return result;
	}
	
	
	/**
	 * 포인트 충전
	 * @param point
	 * @param request
	 * @return
	 */
	@PostMapping("/point_put")
	public Map<String, String> insertPoint(
			@RequestParam("point") int point,
			HttpServletRequest request){
		Integer userId =null;
		HttpSession session = request.getSession();
		userId = (Integer) session.getAttribute("userId");
		Map<String, String> result = new HashMap<String, String>();
		
		//비로그인 상태인 경우
		if(userId ==null) {
			result.put("result", "fail");
			return result;		
		}
		
		
		int row = userBO.plusPointByUserId(userId, point);
		
		if(row>0) {
			result.put("result", "success");
		}
		
		return result;
	}
	
	/**
	 * 회원 정보 변경
	 * @param password
	 * @param name
	 * @param email
	 * @param request
	 * @return
	 */
	@RequestMapping("/user_update")
	public Map<String, String> userUpdate(
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "name",required = false) String name,
			@RequestParam(value = "email",required = false) String email,
			HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Map<String, String> result = new HashMap<String, String>();
		Integer userId =null;
		userId= (Integer) session.getAttribute("userId");
		
		if(userId ==null) {
			result.put("result", "fail");
			return result;
		}
		
		String encrytpassword = null;
		
		System.out.println("password+========================"+password);
		
		if(!password.equals("")) {
			encrytpassword = EncryptUtils.md5(password);
		}
		int row = userBO.updateUserByColumns(userId, encrytpassword, name, email);	
		
		if(row >0) {
			result.put("result", "success");
		}
		
		return result;
	}
	
	/**
	 *  유저 인증
	 * @param loginId
	 * @param name
	 * @param email
	 * @return
	 */
	@RequestMapping("/user_find")
	public Map<String, String> findUser(
			@RequestParam("loginId") String loginId,
			@RequestParam("name") String name,
			@RequestParam("email") String email){
		
		Map<String, String> result = new HashMap<String, String>();
		
		Integer row =null;	
		row = userBO.findUser(loginId, name, email);

			
		if(row !=null) {
			result.put("result", "success");
			result.put("userNum", ""+row+"");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@PostMapping("/user_Password_update")
	public Map<String, String> userPasswordUpdate(
			@RequestParam("userId") int id,
			@RequestParam("password") String password){
		
		Map<String, String> result = new HashMap<String, String>();
		
		String encrytpassword = "";
		
		if(password != null) {
			encrytpassword = EncryptUtils.md5(password);
		}
		
		int row = userBO.updateUserByIdSetPassword(id, encrytpassword);	
		
		if(row >0) {
			result.put("result", "success");
		}
		
		return result;
	}
	
	
	@RequestMapping("/user_except")
	public Map<String, String> userExcept(
			@RequestParam("userId") int id,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String, String> result = new HashMap<String, String>();	
		Integer userId =null;
		userId= (Integer) session.getAttribute("userId");
		
		if(id != userId) {
			result.put("result", "idFail");
			return result;	
			
		}
		
		
		int row = userBO.updateUserExceptById(id);
		
		if(row >0) {
			result.put("result", "success");
		}
		
		return result;
	}
	

}
