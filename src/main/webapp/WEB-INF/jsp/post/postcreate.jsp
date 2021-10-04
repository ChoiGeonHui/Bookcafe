<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="d-flex justify-content-start col-12">
	
	<div class="col-12 ml-3">
		<h3>글쓰기</h3>

		<div class="radio mt-3">
		<b>태그</b>
		<b id="userName" class="d-none">${user.name}</b>
				<label class="radio-inline mx-2"><input type="radio" name="tag" value="자유" checked="checked">자유</label> 
				<label class="radio-inline mx-2"><input type="radio" name="tag" value="후기">후기</label> 
				<label class="radio-inline mx-2"><input type="radio" name="tag" value="질문">질문</label>
				 <label	class="radio-inline mx-2"><input type="radio" name="tag" value="창작">창작</label>
				 <label class="radio-inline mx-2"><input type="radio" name="tag" value="요청">요청</label>

			<c:if test="${user.userClass ne 'noPrice'}">
				<label class="radio-inline mx-2"><input type="radio" name="tag" value="유료">상품(유료)</label>
			</c:if>
			<c:if test="${user.userClass eq 'admin'}">
				<label class="radio-inline mx-2"><input type="radio" name="tag" value="공지">공지</label>
			</c:if>
		</div>
		<div class="mt-3 input-group">
			<span class="input-group-text input-group-append">제목</span>
			<input type="text" id="title" class="form-control" placeholder="제목을 입력하세요.">
		</div>
		<div class="d-flex mt-3">
		<b class="mr-4">사진첨부</b>
			<input id="file" name="file" accept=".jpg,.jpeg,.png,.gif"
				type="file" class="d-none"> <a href="#" id="fileUploadBtn"><img
				width="35" src="/static/images/cm.jpg"></a>
				<div id="fileName"class="ml-2 text-center"></div>

		</div>
		
		
		<textarea class="mt-3" id="content" rows="5" cols="140" placeholder="내용을 입력하세요."></textarea>
		
		
		<div class="mt-3 input-group d-none" id="priceDiv">
			<input type="text" id="price" class="form-control col-6" placeholder="금액을 입력하세요">
			<span class="input-group-text input-group-prepend">point</span>
		</div>
		
	<div class="d-flex mt-3">
	<a href="/bookcafe/main" class="btn btn-danger mx-2 col-2">취소</a>
	<button id="postcreateBtn" class="btn btn-info mx-2 col-2">등록</button>
	</div>

	</div>



</div>

<script>
$(document).ready(function(){
	$('#fileUploadBtn').on('click',function(e){
		e.preventDefault();
		$('#file').click();
	});
	
	
	//사용자가 파일 업로드를 했을 때
	$('#file').on('change',function(e){
		let fileName =e.target.files[0].name;
		
		//확장자
		let ext = fileName.split('.');
		
		if(ext.length<2 || 
				(ext[ext.length -1] != 'gif'
				&&ext[ext.length -1] != 'png'
				&&ext[ext.length -1] != 'jpg'
				&&ext[ext.length -1] != 'jpeg')){
				alert('부적절한 파일입니다');
				$(this).val("");
				return;
		}
		
		$('#fileName').text(fileName);
	});
	
	
	
	$('input[name=tag]').on('change',function(e){
		e.preventDefault();
		
		let	tag = $(this).val();
		
		if(tag == '유료'){
			$('#priceDiv').removeClass('d-none');
		}else{
			$('#priceDiv').addClass('d-none');
			$('#price').val('');	
		}
		
	});
	
	//글작성
	$('#postcreateBtn').on('click',function(e){
		
		//태그에 체크값이 없는 상황을 막기위해 자유버튼에 checked="checked"를 설정함
		let userName =$('#userName').text();
		let tag = $('input[name=tag]:checked').val();
		let title = $('#title').val();
		let content =$('#content').val();
		let price =$('#price').val();
		let content2 = content.replace(/(\n|\r\n)/g, '<br>');
		
		
		if(title == ''){
			alert('제목을 입력하세요.');
			return;
		}
		
		let formData = new FormData();
		formData.append("userName",userName);
		formData.append("tag",tag);
		formData.append("title",title);
		formData.append("content",content2);
		formData.append("file",$('input[name=file]')[0].files[0]);
		formData.append("price",price); 
		
		
		$.ajax({
			type:'post',
			url:'/post/post_create',
			data:formData,
				processData:false,
				contentType:false,
				enctype: 'multipart/form-data', 
			success:function(data){
				if(data.result=='success'){
					alert('작성 완료');
					location.href='/user/update';
				}else if(data.result=='price'){
					alert('금액 비움');		
				} else{
					alert('먼저 로그인을 하세요.');		
				}
			},
			error:function(e){
				alert('에러발생');
			}
			
			
		});
		
	});
	
	
	
	
	

});
</script>