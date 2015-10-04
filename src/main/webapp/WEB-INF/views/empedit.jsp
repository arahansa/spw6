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
	<h2>직원수정</h2>
	<form:form modelAttribute="emp">
		<div class="form-group">
			<label>ID</label>
			<div>${emp.id}</div>
		</div>
		<div class="form-group">
			<label>직원명</label>
			<form:input path="name" cssClass="form-group" placeholder="2자 이상 "  cssErrorClass="form-control errorField" />
			<form:errors path="name" element="label" cssClass="error" /><br>
			
			
			<label>부서명</label>
			<form:select path="dept"  items="${depts}" itemLabel="name" itemValue="id" />
				
			<form:errors path="dept" element="label" cssClass="error" /><br>
			<br> 
			
			
			<button type="submit" class="btn btn-primary">수정</button>
			<a href="/emp/${emp.id}/delete">
				<button type="button" class="btn btn-warning">삭제</button> 
			</a>
			<button type="button" class="btn btn-danger" onclick="deleteemp(${emp.id})">삭제 이벤트</button>
		</div>
	</form:form>

<script>
	function deleteemp(empid){
		console.log(empid);
		// 스택오버플로우 참고 : http://stackoverflow.com/questions/6964927/how-to-create-a-form-dynamically-via-javascript
		var f = document.createElement("form");
		f.setAttribute('method',"post");
		f.setAttribute('action', "/emp/"+empid+"/delete");
		alert("폼 전송 전 서브밋 합니다~콘솔 창 미리 띄워두고 확인해보세요~");
		f.submit();
	}
</script>
</div>
</body>
</html>