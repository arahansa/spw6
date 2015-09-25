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
		<h2>부서 정보</h2>
		
		<div class="btn-group">
			<a href="dept/add"><button class="btn btn-primary" type="button">부서등록</button></a>
		</div>
		
		<table id="depts" class="table table-boardered table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>부서명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="d" items="${depts}">
					<tr>
						<td>${d.id }</td>
						<td><a href="dept/${d.id}/edit">${d.name }</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>
</body>
</html>