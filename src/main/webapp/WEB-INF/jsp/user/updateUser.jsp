<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<h1 class="text-center text-weight-bold">정보 수정</h1>
	
	

	<div class="d-flex">
	<span class="d-none" id="userId">${user.id}</span>
		<table>
			
			<tr>
				<td>변경할 비밀번호</td>
				<td><input type="password" id="password" class="form-control"
					placeholder="비밀번호를 입력하세요 (4자이상)"></td>
			</tr>

			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="passwordChk" class="form-control"
					placeholder="비밀번호를 입력하세요"></td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" id="name" class="form-control"
					placeholder="이름을 입력하세요" value="${user.name}"></td>
			</tr>

			<tr>
				<td>변경할 이메일</td>
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
	<button id="updateBtn" type="button" class="btn btn-primary col-3 mx-2">변경하기</button>
	<a id="outBtn" class="btn btn-danger col-3 mx-2">회원 탈퇴하기</a>
	</div>

</div>

<script type="text/javascript">

$(document).ready(function(){

	$('#updateBtn').on('click',function(e){
		e.preventDefault();
		
		let password= $('#password').val().trim();
		let passwordChk= $('#passwordChk').val().trim();
		let name= $('#name').val().trim();
		let email= $('#email').val().trim();
		let emailhost= $('#emailhost').val().trim();
			
		
		if(password==''&&passwordChk==''&&name==''&&email==''){
			alert('최소 한개 이상의 항목을 입력하세요.');
			return;
		}	
		
		if(password!=''&&passwordChk!=''&&password != passwordChk){
			alert("입력한 비밀번호가 서로 다릅니다.");
			return;
		}
		
		if(password!=''&&password.length<4){
			alert("비밀번호를 4자이상 입력하세요.");
			return;
			
		}	
		//비밀번호 특수문자열
		let regExpEn = /[!@#$%?]/;
		if(password!=''&&!regExpEn.test(password)){
			alert("비밀번호에 특수문자(!@#$%?)가 포함되어야 합니다.");
			return;
		}
		if(email !=''){
			email = email+"@"+emailhost;
		}
		
		
		
		$.ajax({
			method:'post',
			url:"/user/user_update",
			data:{'password':password,'name':name,'email':email},
			success:function(data){
				if(data.result=='success'){
					alert("수정성공");	
					location.href = "/user/update";
				}else{
					alert("가입실패");			
				}
			},
			error: function(e){
				alert('에러발생!');
			} 
			
			
		});
		
		
		
	});
	
	
	$('#outBtn').on('click',function(e){
		e.preventDefault();
		let waringAlert = confirm('탈퇴시 모든 활동 중단 및 서비스 제공을 받을수 없습니다.\n'+
				'탈퇴 하시겠습니까?');
		
		
		
		if(waringAlert == true){
			
			let userId = $('#userId').text();
			
			alert('userId : '+userId);
			
			
			 $.ajax({
				method:'post',
				url:"/user/user_except",
				data:{'userId':userId},
				success:function(data){
					if(data.result=='success'){
						alert("탈퇴되었습니다.");	
						alert("계정이 탈퇴 되었으므로 로그아웃이 됩니다.");	
						location.href = "/user/user/log_out";
					}else if(data.result=='idFail'){
						alert("접속해있는 계정이 다릅니다.");			
					}else{
						alert("오류 발생.");						
					}
				},
				error: function(e){
					alert('에러발생!');
				} 
				
				
			});
			
		}
		
	});
	
	
});



</script>