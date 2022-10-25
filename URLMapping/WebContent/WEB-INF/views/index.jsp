<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="test1">테스트1요청</a><br>
	<a href="test2">테스트2요청</a><br>
	<a href="sub1/test3">sub1/test3</a><br>
	<a href="sub1/test4">sub1/test4</a><br>
	<form action="test1" method="post">
		<button type="submit">test1 post</button>
	</form>
	<form action="test2" method="post">
		<button type="submit">test2 post</button>
	</form>
	<a href="test5">test5</a><br>
	<form action="test5" method="post">
		<button type="submit">test5 post</button>
	</form>
	
</body>
</html>