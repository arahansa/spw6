<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title> Happy WOrld </title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.2.1/mustache.min.js"></script>
</head>
<body>

<form:form method="post" modelAttribute="multipleParam">
	<form:hidden path="myline"/> <br>
	<input type="text" name="test" class="dynamicInput" /> <button class="btnDelete">삭제</button> <br>
	<button id="btnSubmit" type="submit">전송</button>
</form:form>
<button id="btnAddLine">추가</button>

<script>
$(function(){
	$("#btnSubmit").click(function(e){
		console.log("Hello world");
		e.preventDefault();
		
		var str ='';
		$("input.dynamicInput").each(function(k,v){
			console.log(" k : " , k, " , v : ", $(v).val());
			if(k!=0) str += '|&*';
			str += $(v).val();
		});
		
		$("#myline").val(str);
		$("#multipleParam").submit();
	});
	
	$("#btnAddLine").click(function(){
		console.log("test");
		var temp = $('#dynamicInputTmpl').html();
        var rendered = Mustache.render( temp );
        
        $("#btnSubmit").before(rendered);
	});
	
	$(document).on("click" , "button.btnDelete", function(e){
		e.preventDefault();
		console.log("삭제");
		$(this).prev().remove();
		$(this).remove();
	});
	
});
</script>
<script id="dynamicInputTmpl" type="x-tmpl-mustache">
	<input type="text" name="test" class="dynamicInput" /> <button class="btnDelete">삭제</button> <br>
</script>



</body>
</html>