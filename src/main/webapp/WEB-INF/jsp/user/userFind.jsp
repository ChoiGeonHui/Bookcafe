<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<h1 class="text-center text-weight-bold">비밀번호 찾기</h1>
	<div class="d-flex">

		<table>		
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userId" class="form-control"
					placeholder="가입한 아이디를 입력하세요"></td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" id="name" class="form-control"
					placeholder="회원이름을 입력하세요"></td>

			</tr>

			<tr>
				<td>이메일</td>
				<td>
					<div class="input-group">
						<input class="form-control" type="text" id="email" name="email">
						<span
							class="input-group-text input-group-prepend input-group-append">@</span>
						<select class="form-control" id="emailhost" name="emailhost">
							<option value="naver.com">naver.com</option>
							<option value="nate.com">nate.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="kakao.com">kakao.com</option>
						</select>
							
					</div>
				</td>

			</tr>


		</table>

	</div>
	<div class="d-flex justify-content-center my-2">
	<a href="/bookcafe/main" class="btn btn-secondary col-3 mx-2">취소</a>
	<button id="findBtn" type="button" class="btn btn-primary col-3 mx-2">인증하기</button>
	</div>

</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#findBtn').on('click',function(e){
			e.preventDefault();
			
			let userId = $('#userId').val();
			let name = $('#name').val();
			let email = $('#email').val();
			let emailhost = $('#emailhost').val();
			
			if(userId==''||name==''||email==''){
				alert('전부 입력하세요.');
			}
			
			email = email+'@'+emailhost;
			
			
			
			$.ajax({
				type:'post',
				url:"/user/user_find",
				data:{'loginId':userId,'name':name,'email':email},
				success:function(data){
					if(data.result=='success'){
						alert('인증 성공.');
						location.href='/user/user_updatePassword?id='+data.userNum+'';				
					}else{
						alert('인증에 실패하였습니다.');
					}			
				},
				error: function(e){
					alert('에러발생!');
				}
			});
			
			
		});
	});
</script>