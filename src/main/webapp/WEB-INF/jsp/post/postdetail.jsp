<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="d-flex justify-content-start col-12">

	<div class="col-12">

		<div class="d-flex col-12 ml-3">
			<h2>[ ${content.post.tag } ]</h2>
			<h2>[ ${content.post.title } ]</h2>
		</div>

		<div class="d-flex justify-content-between align-items-center col-12 ml-3">
			<b>${content.user.name}</b>
			<b id="createrId" class="d-none">${content.user.id}</b>
			
			<div>
			<b>작성일자 : <fmt:formatDate
					value="${content.post.createdAt}" pattern="yyyy년 MM월 dd일" />
			 </b> 
			 <span> <fmt:formatDate value="${content.post.createdAt}"
					pattern="HH:mm:ss" /></span>


			</div>

		</div>
		
		<div class="bg-light d-flex justify-content-end">
		
				<c:if test="${content.post.userId eq userId}">
					<a href="#" class="moreBtn" data-toggle="modal"
						data-target="#moreSet" data-post-name="${content.user.name}"
						data-post-id="${content.post.id}"
						data-post-image="${content.post.imagePath}"> <img
						height="30px" alt="더보기" src="/static/images/moreicon.jpg">
					</a>
				</c:if>
		
		
		</div>
		
		
		
		<div class="my-5">

			<c:choose>
				<c:when test="${content.buyfile}">
					<c:if test="${not empty content.post.imagePath}">
						<img alt="이미지" src="${content.post.imagePath }" width="100%">
					</c:if>
					<span> ${content.post.content} </span>
				</c:when>
				
				<c:when test="${content.user.id == userId}">

					<c:if test="${not empty content.post.imagePath}">
						<img alt="이미지" src="${content.post.imagePath}" width="100%">
					</c:if>
					<span> ${content.post.content} </span>

				</c:when>

				<c:otherwise>
					<div class="text-center">
						<span>해당 글을 보시려면 <b id="price">${content.post.price}</b> point 를 지불
							하셔야 합니다.
						</span><br> <span>지불 하시겠습니까?</span>
						<div class="d-flex justify-content-center">
							<button id="payBtn" value="${content.post.id}" class="btn btn-info mx-2 my-2 col-2">예</button>
							<a href="/bookcafe/main" class="btn btn-danger col-2 mx-2 my-2">아니오</a>

						</div>

					</div>


				</c:otherwise>


			</c:choose>



		</div>
		
		
		
		<div class="my-2">
		
		
		
		</div>	

	</div>


</div>

<div class="modal" id="moreSet" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
		<div class="modal-content">
			<%-- Modal 창 안에 내용 넣기 --%>
			<div class="w-100">
				<div class="my-3 text-center">
					<a href="#" class="del-post d-block">삭제하기</a><%-- 클릭할 수 있는 영역을 넓히기 위해 d-block --%>
				</div>
				<div class="border-top py-3  text-center">
					<a href="/post/post_update_view?postId=${content.post.id }" class="update-post d-block">수정하기</a><%-- 클릭할 수 있는 영역을 넓히기 위해 d-block --%>
				</div>
				<div class="border-top py-3 text-center">
					<%-- data-dismiss: 모달창 닫힘 --%>
					<a href="#" class="cancel d-block" data-dismiss="modal">취소</a> <%-- 클릭할 수 있는 영역을 넓히기 위해 d-block --%>
				</div>
			</div>
		</div>
	</div>
</div>




<script type="text/javascript">
$(document).ready(function(){
	
	
	
	$('#payBtn').on('click',function(e){
		e.preventDefault();
		
		let createrId = $('#createrId').text();
		let postId = $(this).val();
		let price = $('#price').text();
		
		alert("price = "+price);
		alert("createrId = "+createrId);
		alert("postId = "+postId);
		
		
		$.ajax({
			type:'post',
			data:{'postId':postId, 'price': price,'createrId':createrId},
			url:'/buy/pay',
			success:function(data){
				if(data.result == 'success'){
				alert('결제 완료');
				location.reload();
				
				}else if(data.result == 'noMoney'){
				alert('잔액이 부족합니다. 먼저 충전을 하세요.');					
				location.href = '/user/user_point_view';
				}else{
				alert('오류 발생.');			
					
				}
			},
			error:function(e){
				alert('에러발생');
			}
		});  
		
		
	});
	
});


</script>

