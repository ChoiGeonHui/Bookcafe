<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
    
 <div>
	<h1 class="text-center text-weight-bold">비밀번호 변경</h1>
	
	<b id="id" class="d-none">${id}</b>

	<div class="d-flex">

		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="password" class="form-control"
					placeholder="(4자이상)"></td>

			</tr>

			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="passwordChk" class="form-control"
					placeholder="비밀번호를 입력하세요"></td>

			</tr>

		</table>

	</div>
	<div class="d-flex justify-content-center my-2">
	<a href="/bookcafe/main" class="btn btn-danger col-5 mx-2">돌아가기</a>
	<button id="updatePassword" type="button" class="btn btn-primary col-5 mx-2">변경하기</button>
	</div>

</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#updatePassword').on('click',function(e){
			e.preventDefault();
			
			let userId = $('#id').text();
			let password = $('#password').val();
			let passwordChk = $('#passwordChk').val();
			
			
			if(password==''||password==''){
				alert('전부 입력하세요.');
				return;
			}
			
			if(password.length<4){
				alert('4글자 이상 입력하세요.');
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
			
			$.ajax({
				type:'post',
				url:"/user/user_Password_update",
				data:{'userId':userId,'password':password},
				success:function(data){
					if(data.result=='success'){
						alert('비밀번호가 변경되었습니다.');
						location.href='/user/user_signin_view';				
					}else{
						alert('오류가 발생하였습니다.');
					}			
				},
				error: function(e){
					alert('에러발생!');
				}
			});
			
			
		});
	});
</script>