<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title> Happy WOrld </title>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.5/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<h2>직원 정보</h2>
		
		<div class="btn-group">
			<a href="emp/add"><button class="btn btn-primary" type="button">직원 등록</button></a>
		</div>
		
		<table id="emps" class="table table-boardered table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>직원명</th>
					<th>부서</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${emps}">
					<tr>
						<td>${e.id }</td>
						<td><a href="emp/${e.id}/edit">${e.name }</a></td>
						<td>${e.dept.name }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>
</body>
</html>