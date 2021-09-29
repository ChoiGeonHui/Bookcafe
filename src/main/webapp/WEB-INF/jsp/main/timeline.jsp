<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-12">
<input type="text" id="tag" hidden="true" value="${tag}">
<input type="text" id="search" hidden="true" value="${search}">
	<div class="d-flex justify-content-between">
	<div class="pull-life">
		<a href="/bookcafe/main" class="btn btn-light text-success mx-2">전체</a>
		<a href="#" class="tagBtn btn btn-light text-danger mx-2" data-tag="공지">공지</a> 
		<a href="#" class="tagBtn btn btn-light text-warning mx-2" data-tag="추천글">추천글</a>
		<a href="#" class="tagBtn btn btn-light text-success mx-2" data-tag="후기">후기</a> 
		<a href="#" class="tagBtn btn btn-light text-success mx-2" data-tag="창작">창작</a>
		<a href="#" class="tagBtn btn btn-light text-success mx-2" data-tag="질문">질문</a> 
		<a href="#" class="tagBtn btn btn-light text-success mx-2" data-tag="요청">요청</a>
		<a href="#" class="tagBtn btn btn-primary mx-2">책(유료)</a>
	</div>

		<div class="pull-right">
			<div class="input-group">

				<img alt="검색" class="bg-light" src="/static/images/serch1.jpg"
					height="35px" width="35px"> <input type="text" id="searchVal"
					class="from-control" placeholder="제목키워드 입력">
				<a href="#" id="btnSearch" class="btn input-group-text input-group-append">검색</a>
			</div>
		</div>

	</div>
	<hr>
	<div>
	<div class="text-center">
	</div>
		<table class="table text-center">
			<thead>
				<tr>
					<th class="col-1">번호</th>
					<th class="col-1">태그</th>
					<th char="col-5">제목</th>
					<th class="col-2">작성자</th>
					<th class="col-2">작성일</th>
					<th class="col-1">추천수</th>

				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>

		<c:forEach items="${list}" var="list">
		<a href="/post/post_detail_view?postId=${list.post.id}">
			<div class="d-flex btn btn-light mb-1 userlist">
				<div class="col-1">${list.post.id}</div>
				<div class="col-1">${list.post.tag}</div>
				<div class="col-5">${list.post.title}</div>
				<div class="col-2">${list.user.name}</div>
				<div class="col-2">
					<fmt:formatDate value="${list.post.createdAt}" pattern="yyyy-MM-dd" />
				</div>
				<div class="col-1 text-center">${list.likeCount}</div>
			</div>
		</a>
	</c:forEach>
</div>


<script type="text/javascript">
$(document).ready(function(){
	
	
	$('.tagBtn').on('click',function(e){
		e.preventDefault();
		let tag = $(this).data('tag');
		let search =  $('#search').val();
		
		//검색값이 들어있을경우
		if(search!=''){
			location.href='/bookcafe/main?tag='+tag+'&search='+search;
		}else{	
			location.href='/bookcafe/main?tag='+tag;
		}
		
		
	});
	
	
	$('#btnSearch').on('click',function(e){
		e.preventDefault();
		
		let search = $('#searchVal').val();	
		let tag = $('#tag').val();
		
		if(search==''){
			alert('단어를 입력하세요.');
			return;
		}
		
		//이미 태그가 입력된 경우
		if(tag!=''){
		location.href='/bookcafe/main?tag='+tag+'&search='+search;		
			}else{	
				location.href='/bookcafe/main?search='+search;
			}
			
		
	});
	
});


</script>
