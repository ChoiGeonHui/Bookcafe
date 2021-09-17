<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<div class="col-12">
    <h2>UserList</h2>
    <div>

		<table class="table">
			<thead>
				<tr>
				<th>일련번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userlist}" var="list">
					<tr>
						<td>${list.id}</td>
						<td>${list.loginId}</td>
						<td>${list.name}</td>
						<td>${list.email}</td>
						<td>${list.userClass}</td>
					</tr>
				</c:forEach>
			</tbody>



		</table>














	</div>
    <hr>
    
    
    
    
</div>