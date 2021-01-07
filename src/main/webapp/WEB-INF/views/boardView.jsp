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
<title>게시글 상세</title>
</head>
<body>
<h3>게시글 상세</h3>
<div style="padding : 30px;">
	<div class="form-group">
		<label>제목</label>
		<span>${board.subject }</span>
	</div>
	<div class="form-group">
		<label>작성</label>
		<span>${board.writer }</span>
	</div>
	<div class="form-group">
		<label>작성날</label>
		<span><fmt:formatDate value="${board.reg_date }" pattern="yyyy/MM/dd HH:mm"/></span>
	</div>
	<div class="form-group">
		<label>조회</label>
		<span>${board.hit }</span>
	</div>
	<div class="form-group">
		<label>내용</label>
		<p>${board.content }</p>
	</div>
	<div class="form-group">
		<input type="button" value="수정" onclick='location.href="/board/updatePage/${board.bno }"'>
		<form:form action="/board/delete/${board.bno }" method="POST">
			<input type="hidden" name="_method" value="DELETE">
			<input type="submit" value="삭제">
		</form:form>
	</div>
</div>

</body>
</html>