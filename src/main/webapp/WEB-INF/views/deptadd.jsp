<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title> Happy WOrld </title>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.5/css/bootstrap.css">
<style>
	.error { color: red; }
	.errorField { border: 1px solid red; }
</style>
</head>
<body>
<div class="container">
	<h2>부서등록</h2>
	<form:form modelAttribute="dept">
		<div class="form-group">
			<label>부서명</label>
			<form:input path="name" cssClass="form-group" placeholder="2자 이상 "  cssErrorClass="form-control errorField" />
			<form:errors path="name" element="label" cssClass="error" /><br>
		</div>
		<div class="form-group">
			<label>Level</label>
			<form:select path="level">
				<%-- <form:option value="30" label="30" />
				<form:option value="40" label="40" />
				<form:option value="50" label="50" /> --%>
				<form:options items="${levels}" itemValue="value" itemLabel="label" />
			</form:select>
		</div>
		
		<button type="submit" class="btn btn-primary">등록</button>
	</form:form>



</div>
</body>
</html>