<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h1 class="text-center text-weight-bold">회원가입</h1>
	
	

	<div class="d-flex">

		<table>
			<tr>
				<td>아이디</td>
				<td>
					<div class="input-group">
						<input type="text" id="id" name="id" placeholder="아이디를 입력하세요(4자 이상)"
							class="form-control">
						<div class="input-group-append">
							<input type="button" class="btn btn-success" id="chkId"
								value="중복체크">
						</div>
					</div>

				</td>
			</tr>
			<tr>
				<td id="idLength" class="text-danger d-none text-center" colspan="2">아이디를 4자 이상 입력하세요</td>
				<td id="idDuc" class="text-danger d-none text-center" colspan="2">중복된 아이디 입니다</td>
				<td id="idChk" class="text-success d-none text-center" colspan="2">사용가능한 아이디입니다</td>
			</tr>


			<tr>
				<td>비밀번호</td>
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
					placeholder="이름을 입력하세요"></td>

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
	<button id="inputBtn" type="button" class="btn btn-primary col-5">가입하기</button>
	</div>

</div>

<script type="text/javascript">

$(document).ready(function(){
	
	
	$('#chkId').on('click',function(e){
		e.preventDefault();
		let id= $('#id').val().trim();
		
		if(id.length<=3){
			$('#idLength').removeClass('d-none');
			$('#idDuc').addClass('d-none');
			$('#idChk').addClass('d-none');
			return;
		}
		
		
		$.ajax({
			method:'post',
			url:"/user/user_IdCheck",
			data:{'loginId':id},
			success:function(data){
				if(data.result=='success'){
					$('#idLength').addClass('d-none');
					$('#idDuc').addClass('d-none');
					$('#idChk').removeClass('d-none');
				}else{
					$('#idLength').addClass('d-none');
					$('#idDuc').removeClass('d-none');
					$('#idChk').addClass('d-none');
				}
				
			},
			error: function(e){
				alert('에러발생!');
			}
			
			
		});
		
		
		
	});
	
	
	
	
	
	
	$('#inputBtn').on('click',function(e){
		e.preventDefault();
		
		
		let id= $('#id').val().trim();
		let password= $('#password').val().trim();
		let passwordChk= $('#passwordChk').val().trim();
		let name= $('#name').val().trim();
		let eamil= $('#email').val().trim();
		let emailhost= $('#emailhost').val().trim();
		
		
		if(id==''){
			alert('아이디를 입력하세요.');
			return;
		}else if(id.length<4){
			alert('아이디를 4자이상 입력하세요.');
			return;
		}
		
		if($('#idChk').hasClass('d-none')){
			alert('아이디중복 체크를 해주세요.');
			return;
		}
		
		
		
		if(password==''){
			alert('비밀번호를 입력하세요.');
			return;
		}else if(passwordChk==''){
			alert('비밀번호확인을 입력하세요.');
			return;
		}	
		
		if(password != passwordChk){
			alert("입력한 비밀번호가 서로 다릅니다.");
			return;
		}
		
		//비밀번호 특수문자열
		let regExpEn = /[!@#$%?]/;
		
		if(!regExpEn.test(password)){
			alert("비밀번호에 특수문자(!@#$%?)가 포함되어야 합니다.");
			return;
		}
		
		
		
		
		if(name==''){
			alert('이름을 입력하세요.');
			return;
		}
		if(email==''){
			alert('이메일을 입력하세요.');
			return;
		}
		
		
		$.ajax({
			method:'post',
			url:"/user/user_sign_up",
			data:{'loginId':id,'password':password,'name':name,'email':email},
			success:function(data){
				if(data.result=='success'){
					alert("가입성공");	
					location.href = "/user_signin_view";
				}else{
					alert("가입실패");			
				}
				
			},
			error: function(e){
				alert('에러발생!');
			}
			
			
		});
		
		
		
	});
});



</script>



