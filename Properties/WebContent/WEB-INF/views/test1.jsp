<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<h3>oracle.user : <spring:message code='oracle.user'/></h3>
	<h3>oracle.pass : <spring:message code='oracle.pass'/></h3>
	<h3>mysql.user : <spring:message code='mysql.user'/></h3>
	<h3>mysql.pass : <spring:message code='mysql.pass'/></h3>
</body>
</html>