<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" language="javascript">
	  $(document).ready(function(){
		
		$("#btn_insert").click(function(){
			var params = JSON.stringify($("#formId").serializeArray());
			var json = { subject: 'this is test', writer: 'cho', 
					content: 'let see how it goes...'};
			var form = document.getElementById("formId");
		//	alert(form);
		//	params = encodeURI(params);
		
		/*  var http = new XMLHttpRequest();
		var formData = new FormData(form);
		http.onload = function() {
			if (http.status === 200 || http.status ===201) {
				console.log(http.responseText);
			}else{
				console.error(http.responseText);
			}
		}
		http.open('POST','/board/post',true);
		http.setRequestHeader('Content-type','application/json');
		http.send(JSON.stringify(formData));
		http.onload = function(){
			alert(http.responseText);
		}   */
			/*   $.ajax({
				type:"POST",
				url:"/board/post",
				contentType:"application/json",
				dataType: "json",
				data: JSON.stringify(json),
				success:function(request,status,error){
						alert("ajax통신 성공!!");
						alert(request);
						alert(status);
						alert(error);
						alert(JSON.stringify(json));
					
				},
				error:function(request,status,error){
					alert("ajax통신 실패!!");
					//console.log(params);
					alert(request);
					alert(status);
					alert(error);
					alert(JSON.stringify(json));
				}
			});  */
		});
	}); 
	 
		 
</script>
<title>게시글 작성</title>
</head>
<body>
<h3>게시글 작성</h3>
<div style="padding:30px;">
	<form  id="formId" method="post" action="/board/post">
		<div class="form-group">
			<label>제목</label>
			<input type="text" name="subject" class="form-control">
		</div>
		<div class="form-group">
			<label>작성자</label>
			<input type="text" name="writer" class="form-control">
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea name="content" class="form-control" rows="5"></textarea>
		</div>
		<button type="submit" id="btn_insert" class="btn btn-default">작성</button>
	</form>
	<button class="btn btn-warning" onclick="location.href='/board'">취소</button>
</div>

</body>
</html>