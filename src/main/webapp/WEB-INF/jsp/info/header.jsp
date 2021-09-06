<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<header class="d-flex align-items-center justify-content-center">

	<img height="100%" alt="이미지 부착" src="/static/images/bookshop.jpg">
	<div class="text-white ml-3">
		<h1>Book Cafe</h1>
	</div>
</header>



<div class="mr-3 mt-2 d-flex justify-content-end">



	<c:if test="${not empty userId}">
	<div>
		<span>${userName} 회원님 안녕하세요~</span>
		<div class="d-flex">
		<a href="">로그아웃</a>
		<a href="/user/user/log_out" class="btn btn-secondary">로그아웃</a>
		</div>
	</div>
	</c:if>

	<c:if test="${empty userId}">
	
		<a href="/user/user_signin_view">로그인</a>
	</c:if>
</div>
