<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="d-flex justify-content-start col-12">

	<div class="col-12">

		<div class="d-flex col-12 ml-3">
			<h2>[ ${content.post.tag } ]</h2>
			<h2>[ ${content.post.title } ]</h2>
			<span class="d-none" id="postId">${content.post.id}</span>
		</div>

		<div class="d-flex justify-content-between align-items-center col-12 ml-3">
			
			<div class="d-flex align-items-center">
				<b>${content.user.name}</b> 
			
			<c:if test="${content.user.id ne userId}">	
				<a href="#" class="ml-1 hateBtn" data-toggle="modal"
						data-target="#moreHate" data-hate-id="${content.user.id}" data-hate-name="${content.user.name}"> 
				<img alt="신고" src="/static/images/hate.jpg" height="23px" width="23px">
				</a>		
			</c:if>
			
			</div>
			
			<b id="createrId" class="d-none">${content.user.id}</b>
			
			<div>
			<b>작성일자 : <fmt:formatDate
					value="${content.post.createdAt}" pattern="yyyy년 MM월 dd일" />
			 </b> 
			 <span> <fmt:formatDate value="${content.post.createdAt}" pattern="HH:mm:ss" /></span>


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
				<c:when test="${content.buyfile or content.user.id == userId}">
					<c:if test="${not empty content.post.imagePath}">
						<img alt="이미지" src="${content.post.imagePath }" width="100%">
					</c:if>
					<span> ${content.post.content} </span>
					<hr>

					<a href="#" id="likeSend">
						<c:choose>
							<c:when test="${content.likefile}">
								<img alt="like" src="/static/images/heart2.jpg" height="25px"
									width="25px">

							</c:when>
							<c:otherwise>
								<img alt="like" src="/static/images/heart.jpg" height="25px"
									width="25px">

							</c:otherwise>
						</c:choose>
					</a>
					
					
					추천 <span>${content.likeCount } 개</span>
					<hr>
					<div class="bg-light my-3 d-flex">
					<img alt="댓글" src="/static/images/tolk.jpg" height="25px" width="25px">
						<b class="ml-2">댓글</b>
					</div>
					<div class="my-2">
					
					<c:forEach var="comment" items="${content.commentList}">
						<div>
							<b>${comment.userName}</b>

								<c:if test="${comment.userId ne userId}">
									<a href="#" class="ml-1 hateBtn" data-toggle="modal"
										data-target="#moreHate" data-hate-id="${content.user.id}"
										data-hate-name="${content.user.name}"> <img alt="신고"
										src="/static/images/hate.jpg" height="23px" width="23px">
									</a>
								</c:if>

								<br> <span>${comment.content }</span><br>
							
							 <small	class="text-secondary">
									<fmt:formatDate value="${comment.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
							 </small>

							<c:if test="${comment.userId eq userId}">
								<a href="#" data-comment-id="${comment.id}" id="delComment"> <small>삭제하기</small></a>
							</c:if>
						</div>
					</c:forEach>
					</div>
					<hr>
					<div>
					<b>댓글 작성</b>
					<div class="input-group">
					<input type="text" id="content" class="form-control">
							<div class="input-group-text input-group-prepend">
								<button id="insertComment" class="btn">작성하기</button>
							</div>
						</div>
							
					</div>

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
		

	</div>


</div>

<div class="modal" id="moreHate" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
		<div class="modal-content">
			<%-- Modal 창 안에 내용 넣기 --%>
			<div class="w-100">
				<div class="my-3 text-center">
					<a href="#" class="insertHate d-block">신고하기</a><%-- 클릭할 수 있는 영역을 넓히기 위해 d-block --%>
				</div>
				<div class="border-top py-3 text-center">
					<%-- data-dismiss: 모달창 닫힘 --%>
					<a href="#" class="cancel d-block" data-dismiss="modal">취소</a> <%-- 클릭할 수 있는 영역을 넓히기 위해 d-block --%>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="modal" id="moreSet" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
		<div class="modal-content">
			<%-- Modal 창 안에 내용 넣기 --%>
			<div class="w-100">
				<div class="my-3 text-center">
					<a href="#" class="deletePost d-block">삭제하기</a><%-- 클릭할 수 있는 영역을 넓히기 위해 d-block --%>
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
	
	//post삭제 하기
	$('.deletePost').on('click',function(e){
		e.preventDefault();
		let postId = $('#postId').text();
		
		let waringAlert = confirm('정말 해당 게시물을 삭제하시겠습니까?');
		
		if(waringAlert == true){
			
			alert(postId);
			
			$.ajax({
				type:'post',
				url:'/post/post_delete',
				data:{'postId':postId},
				success:function(data){
					if(data.result=='success'){
						alert('삭제 하였습니다.');
						location.href='/bookcafe/main';
					}else{
						alert('오류가 발생하였습니다.');
					}
					
				},
				error:function(e){
					alert('에러발생.');
				}
				
			});
		}
		
	});
	
	
	//신고하기
	$('.insertHate').on('click',function(e){
		e.preventDefault();
		
		let subjectId = $('.hateBtn').data('hate-id'); 
		let name = $('.hateBtn').data('hate-name'); 
		
		let waringAlert = confirm('정말 해당 유저를 신고하시겠습니까?\n'
				+'신고시 취소할수 없으며 허위신고는 처벌받을수 있습니다.');
		if(waringAlert ==true){
			alert('신고 일련번호: '+ subjectId +"  이름:"+name);
		
			
			$.ajax({
				type:'post',
				url:'/hate/hate',
				data:{'subjectId':subjectId},
				success:function(data){	
					if(data.result == 'getId'){
						alert('먼저 로그인을 하세요.');
					}else if(data.result == 'hated'){
						alert('이미 해당유저를 신고하였습니다.');
						location.reload();
					}else if(data.result == 'success'){
						alert('해당유저를 신고하였습니다.');
						location.reload();
					}else{
						alert('오류가 발생하였습니다.');
					}
				},error:function(e){
						alert('에러 발생.');				
				}
				
			});
		}
		
		
		
		
	});
	
	
	
	
	
	//추천 누르기
	$('#likeSend').on('click',function(e){
		e.preventDefault();
		let postId = $('#postId').text();
		
		$.ajax({
			type:'post',
			url:'/like/like',
			data:{'postId':postId},
			success:function(data){
				if(data.result=='insert'){
					location.reload();
				}else if(data.result=='delete'){
					location.reload();
				}else{
					alert('오류가 발생하였습니다.');
				}
				
			},error:function(e){
				alert('에러발생.');
			}
			
		});
		
	});
	
	//댓글 작성
	$('#insertComment').on('click',function(e){
		e.preventDefault();
		let postId = $('#postId').text();
		let content = $('#content').val();
		
		if(content==''){
				alert('댓글을 작성하세요.');
				return;
		}
		
		$.ajax({
			type:'post',
			url:'/comment/write_comment',
			data:{'postId':postId,'content':content},
			success:function(data){
				if(data.result=='success'){
					location.reload();
				}else if(data.result=='noWrite'){
					alert('관리자에 의해 댓글작성 및 글쓰기가 제한되었습니다.\n'+
							'아름다운 활동 부탁드려요~');
					location.reload();					
				}else{
					alert('오류가 발생하였습니다.');
				}
				
			},error:function(e){
				alert('에러발생.');
			}
		})
	});
	
	
	//댓글 삭제
	$('#delComment').bind('click',function(e){
		e.preventDefault();	
		let commentId = $(this).data('comment-id');
		let postId = $('#postId').text();
		
		$.ajax({
			type:'post',
			data:{'id':commentId,'postId':postId},
			url:'/comment/delete_comment',
			success:function(data){
				if(data.result=='success'){
					alert('삭제 완료');
					location.reload();
				}else{
					alert('오류가 발생하였습니다.');
				}
			},
			error:function(e){
				alert('오류발생');
			}
		});
		
		
		
		
	});
	
	
	
	$('#payBtn').on('click',function(e){
		e.preventDefault();
		
		let createrId = $('#createrId').text();
		let postId = $(this).val();
		let price = $('#price').text();
		
		
		$.ajax({
			type:'post',
			data:{'postId':postId,'createrId':createrId,'price': price},
			url:'/buy/pay',
			success:function(data){
				if(data.result == 'success'){
				alert('결제 완료');
				location.reload();
				//새로고침
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

