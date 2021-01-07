<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시글 수정</title>
</head>
<body>
<h3>게시글 수정</h3>
	<form:form commandName="BoardVO" action="/board/update/${board.bno }" method="PUT">
		<div class="form-group">
			<label>제목</label>
			<input type="text" name="subject" value="${board.subject }" class="form-control">
		</div>
		<div class="form-group">
			<label>작성자</label>
			<span>${board.writer }</span>
			<input type="hidden" name="writer" value="${board.writer }" class="form-control">
		</div>
		<div>
			<label>내용</label>
			<textarea rows="5" name="content" class="form-control">${board.content }</textarea>
		</div>
		<button type="submit" class="btn btn-default">수정</button>
	</form:form>
</body>
</html>