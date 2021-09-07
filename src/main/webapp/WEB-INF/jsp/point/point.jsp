<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="pointpage"  class="d-flex align-items-center">

	<table>
		<tr>
			<td><b>얼마를 충전하시겠습니까?</b></td>

		</tr>
		<tr>
			<td><div class="input-group">
					<input class="form-control" type="text" id="inpoint" name="inpoint">
					<span
						class="input-group-text input-group-prepend input-group-append">Point</span>
				</div></td>
		</tr>

		<tr>
			<td>
				<button id="upPoint" type="button" class="btn btn-primary col-12">충전하기</button>
			</td>
		</tr>
		
		<tr>
			<td>
				<a href="/bookcafe/main" class="btn btn-danger col-12">취소</a>
			</td>
		</tr>
	</table>
</div>


<script type="text/javascript">
	$(document).ready(function() {
		
		$('#upPoint').on('click',function(e){
			e.preventDefault();
			
			let point = $('#inpoint').val();
			
			
			
			if(point == ''){
				alert('값을 입력하세요.');
				return;
			}
			
			
			$.ajax({
				method:'post',
				url:'/user/point_put',
				data:{'point':point},
				success:function(data){
					if(data.result=='success'){
						alert( point+' point를 충전 하였습니다.');
						location.href = '/user/update';
					}else if(data.result=='fail'){
						alert( '먼저 로그인을 하세요');
					}
				},
				error:function(){
					alert('오류,또는 올바른 값을 입력하지 않았습니다.');
				}
			});
			
			
			
		});
		

	});
</script>


