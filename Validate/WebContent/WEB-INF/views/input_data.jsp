<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>input_data</h1>
	<form action='input_pro' method='post'>
		ID : <input type='text' name='id'/><br/>
		<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('id') }">
				${errors.getFieldError('id').defaultMessage }<br/>			
			</c:if>
		</spring:hasBindErrors>
		PASS : <input type='text' name='pass'/><br/>
		<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('pass') }">
				${errors.getFieldError('pass').defaultMessage }<br/>			
			</c:if>
		</spring:hasBindErrors>
		<button type='submit'>확인</button>
	</form>
</body>
</html>