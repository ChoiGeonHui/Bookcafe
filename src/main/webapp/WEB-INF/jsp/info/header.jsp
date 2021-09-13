<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<header class="d-flex align-items-center justify-content-center">

	<img height="100%" alt="이미지 부착" src="/static/images/bookshop.jpg">
	<div class="text-white ml-3">
		<h1>
		<a href="/bookcafe/main" class="text-white">Book Cafe</a> 
		</h1>
	</div>
</header>



<div class="mr-3 mt-2 d-flex justify-content-end" id="usernav">

<div class="col-9">

<img alt="책사진" src="/static/images/book4.jpg" class="w-100" height="190px">

</div>


	<div class="col-3">
		<c:if test="${not empty userId}">
			<div class="col-12">
				<span><a href="/user/user_update_view">${user.name}</a> 
				<c:if test="${user.userClass eq 'admin'}">
				관리자님 어서오세요.
				</c:if> 
				<c:if test="${user.userClass eq 'normal'}">
				회원님 안녕하세요~
				</c:if> 
				</span>
				<div class="d-flex mt-2">
					<b class="col-8 text-center">${user.point} point</b> <a
						href="/user/user_point_view" class="btn btn-primary col-3">충전</a>
				</div>
				<div class="d-flex mt-2">
					<a href="/post/post_create_view" class="btn btn-success mx-2">글쓰기</a> <a
						href="/user/user/log_out" class="btn btn-secondary mx-2">로그아웃</a>
				</div>

				<c:if test="${userClass eq 'admin'}">
					<div class="d-flex justify-content-center mt-2">
						<a href="#" class="btn btn-dark mx-2">사용자 목록</a>
					</div>
				</c:if>

			</div>
		</c:if>

		<c:if test="${empty userId}">

			<div class="col-12">
				<a href="/user/user_signin_view"> <img alt="로그인"
					src="/static/images/login.jpg" class="w-100" height="120px">
				</a>
			</div>
		</c:if>
	</div>
</div>
