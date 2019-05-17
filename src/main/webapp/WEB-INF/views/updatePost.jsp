<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<h1>Update Post</h1>
		<p class="lead">File the below information to add a post:</p>
		
		<sf:form action="${pageContext.request.contextPath}/admin/postInventory/updatePost"
			method="post" modelAttribute="post">
			
			<!-- id도 binding 해줘야 함! -->
			<sf:hidden path="id"/>
			
			<div class="form-group">
				<label for="title">Title</label>
				<sf:input path="title" id="title" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="priority">Priority:</label>
				<sf:radiobutton path="priority" id="priority" value="상"/> 상
				<sf:radiobutton path="priority" id="priority" value="중"/> 중
				<sf:radiobutton path="priority" id="priority" value="하"/> 하
			</div>
			
			<div class="form-group">
				<label for="deadline">Deadline</label>
				<sf:input path="deadline" id="deadline" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="state">State</label>
				<sf:input path="state" id="state" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" id="description" class="form-control"/>
			</div>
			
			<input type="submit" value="submit" class="btn btn-primary">
			<a href="<c:url value="/admin/postInventory"/>" class="btn-btn-default">Cancel</a>
			
		</sf:form>
		<br />
	</div>
</div>

