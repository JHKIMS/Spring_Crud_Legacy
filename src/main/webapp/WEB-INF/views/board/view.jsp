<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>

<link rel='stylesheet' type='text/css' href="/resources/default.css">
</head>
<body>

	<div id="nav">
		<%@ include file="../include/nav.jsp"%>
	</div>
	
	<form method="post">

		<label>제목</label> ${view.title}<br /> 
		<label>작성자</label>${view.writer}<br /> 
		<label>내용</label> ${view.content}<br />

		<div>
			<a href="/board/modify?idx=${view.idx}">게시물 수정</a>
			<a href="/board/delete?idx=${view.idx}">게시물 삭제</a>
		</div>
	</form>

</body>
</html>