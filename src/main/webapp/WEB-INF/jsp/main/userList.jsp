<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<div class="col-12">
    <h2>UserList</h2>
    <div>

		<table class="table text-center">
			<thead>
				<tr>
				<th class="col-1">일련번호</th>
				<th class="col-1">아이디</th>
				<th class="col-2">이름</th>
				<th class="col-2">이메일</th>
				<th class="col-1">누적신고</th>
				<th class="col-2">상태</th>
				<th class="col-2">변경</th>
				<th class="col-2">버튼</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${userlist}" var="list">
					<tr>
						<td>${list.user.id}</td>
						<td>${list.user.loginId}</td>
						<td>${list.user.name}</td>
						<td>${list.user.email}</td>
						<td>${list.hateCount}</td>
						<td>${list.user.userClass}</td>	
						<td>
						<select name="userStatus${list.user.id}">
						<option value="default" selected="selected">상태선택</option>
						<option value="normal">일반</option>
						<option value="noPrice">상품 판매금지</option>
						<option value="noWrite">채팅,글작성금지</option>
						<option value="blacklist">활동정지</option>
						<option value="except">탈퇴</option>
						</select>
						</td>
						<td>
						<a class="updateClass btn btn-light" data-user-id="${list.user.id}">변경</a>				
						</td>
					</tr>
				</c:forEach>
				
			</tbody>

		</table>

	</div>
    <hr>
 
    
</div>
<script type="text/javascript">

$(document).ready(function(){
	
	
	$('.updateClass').on('click',function(e){
		e.preventDefault();
		let id = $(this).data('user-id');
		let userClass = $("select[name=userStatus"+id+"]").val();
		
		if(userClass=='default'){
			alert('유저 상태를 선택하세요.');
			return;
		}
		
		$.ajax({
			type:'post',
			data:{'userId':id,'userClass':userClass},
			url:'/user/userClass_update',
			success:function(data){
				if(data.result=='success'){
					alert('해당 회원의 권한이 변경되었습니다.');
					location.reload();
				}else{
					alert('오류가 발생하였습니다.');
				}
			},
			error:function(){
				alert('에러발생.');
			}
		});
		
		
	});
	
	
	
});


</script>