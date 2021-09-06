<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="col-6">
    <img alt="책사진" src="/static/images/book3.jpg" class="h-100">
    
    </div>
    
    
    
    <div class="col-6">
	<h1 class="text-center text-weight-bold">로그인</h1>



	<div class="d-flex col-12">

		<table class="col-12">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="id" name="id"
					placeholder="아이디를 입력하세요" class="form-control"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="password" class="form-control"
					placeholder="비밀번호를 입력하세요"></td>
			</tr>
		</table>

	</div>
	<div class="d-flex justify-content-center my-2">
	<button id="loginBtn" type="button" class="btn btn-primary col-12">로그인</button>
	</div>
	
	<div class="d-flex justify-content-center my-2">
	<a href="/user/user_signup_view" class="btn btn-dark text-white col-12">회원가입</a>
	</div>
	
	<div class="d-flex justify-content-center my-2">
	<a href="#" class="btn btn-danger col-12">비밀번호 찾기</a>
	</div>

</div>

<script type="text/javascript">
$(document).ready(function(){
	
	
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
						alert("로그인 성공");
						location.href = '/bookcafe/main';
					}
				},
				error:function(e){
					alert('에러발생!');
				}
				
			});

		});

	});
</script>