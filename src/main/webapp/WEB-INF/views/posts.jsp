<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container-wrapper">
	<div class="container">
		<h2>All Posts</h2>
		<p>일정을 꼼꼼히 확인하세요!</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-primary">
					<th>Title</th>
					<th>Priority</th>
					<th>Deadline</th>
					<th>State</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="post" items="${posts}">
					<!--출력 화면 테이블 내부 데이터들! // posts랑 controller의 key값과 일치!-->
					<tr>
						<td>${post.title}</td>
						<td>${post.priority}</td>
						<td>${post.deadline}</td>
						<td>${post.state}</td>
						<td>${post.description}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
