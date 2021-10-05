<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="col-6">
    	<img id="imageControl" alt="책사진" src="/static/images/book3.jpg" class="w-100" height="330px">
    </div>  
    <div class="col-6">
	<h1 class="text-center text-weight-bold">로그인</h1>

	<div class="d-flex col-12 justify-content-center">

		<table class="col-8">
			<tr ">
				<td>아이디</td>
				<td><input type="text" id="id" name="id"
					placeholder="Login ID" class="form-control"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="password" class="form-control"
					placeholder="Password"></td>
			</tr>
		</table>

	</div>
	<div class="d-flex justify-content-center my-2">
	<button id="loginBtn" type="button" class="btn btn-primary col-8">로그인</button>
	</div>
	
	<div class="d-flex justify-content-center my-2">
	<a href="/user/user_signup_view" class="btn btn-dark text-white col-8">회원가입</a>
	</div>
	
	<div class="d-flex justify-content-center my-2">
	<a href="/user/user_find_view" class="btn btn-danger col-8">비밀번호 찾기</a>
	</div>

</div>

<script type="text/javascript">
$(document).ready(function(){
	
	let bannerSrcArr = ['/static/images/book1.jpg', '/static/images/book2.jpg',
		 '/static/images/book3.jpg'];
           var currentIndex = 0;
           setInterval(function() {
               $('#imageControl').attr('src', bannerSrcArr[currentIndex]);
               currentIndex++;

               if (currentIndex >= bannerSrcArr.length) {
                   currentIndex = 0;
               }
           }, 3000); 
	
	//로그인 버튼
	$('#loginBtn').on('click', function(e) {
			e.preventDefault();	
			let loginId = $('#id').val();
			let password = $('#password').val();

			if (loginId == '') {
				alert("아이디를 입력하세요.");
				return;
			}		
			if (password == '') {
				alert("비밀번호를 입력하세요.");
				return;
			}
			
			$.ajax({	
				method:'post',
				url:'/user/user_sign_in',
				data:{'loginId':loginId,'password':password},
				success:function(data){
					if(data.result=='success'){
						location.href = '/bookcafe/main';
					}else if(data.result=='except'){
						alert("[알림]\n탈퇴된 계정입니다.");						
					}else if(data.result =='blacklist'){
						alert("[알림]\n해당유저는 누적된 신고로 인하여 활동이 정지되었습니다.\n"+
								"문의 사항은 관리자 이메일(admin@naver.com)로 접수하시면 됩니다.");						
					}else{
						alert("아이디 또는 비밀번호가 틀렷습니다.");
					}
				},
				error:function(e){ alert('에러발생!'); }
				
			});

		});
	
	


	});
</script>