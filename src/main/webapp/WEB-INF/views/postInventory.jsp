<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container-wrapper">
	<div class="container">
		<h2>Posts Inventory</h2>
		<p>To do list 목록입니다.</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-primary">
					<th>Title</th>
					<th>Priority</th>
					<th>Deadline</th>
					<th>State</th>
					<th>Description</th>
					<th> </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="post" items="${posts}">
					<tr>
						<td>${post.title}</td>
						<td>${post.priority}</td>
						<td>${post.deadline}</td>
						<td>${post.state}</td>
						<td>${post.description}</td>
						<td>
							<!-- id ? or status -->
							<a href="<c:url value="/admin/postInventory/completionPost/${post.id}"/>"> <i class="fa fa-check-circle"></i> </a>
							<a href="<c:url value="/admin/postInventory/updatePost/${post.id}"/>"> <i class="fa fa-edit"></i> </a>
							<a href="<c:url value="/admin/postInventory/deletePost/${post.id}"/>"> <i class="fa fa-times"></i> </a>
						</td>
			
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="<c:url value="/admin/postInventory/addPost"/>" class="btn btn-primary" >Add Post</a>
		
	</div>
</div>
