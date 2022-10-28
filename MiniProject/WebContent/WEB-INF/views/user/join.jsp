<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }/" /> 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>미니 프로젝트</title>
    <!-- Bootstrap CDN -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <!-- 상단 메뉴 부분 -->
	<c:import url="/WEB-INF/views/include/menu.jsp" />

    <div class="container" style="margin-top: 100px">
      <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
          <div class="card shadow">
            <div class="card-body">
              <form:form action="${root }user/join_pro" modelAttribute="joinUserBean" >
                <div class="form-group">
                  <form:label path="user_name">이름</form:label>
                  <form:input path="user_name" class="form-control" />
                  <form:errors path="user_name" style="color:coral" />
                </div>
                <div class="form-group">
                  <form:label path="user_id">아이디</form:label>
                  <div class="input-group">
                    <form:input path="user_id" class="form-control" />
                    <div class="input-group-append">
                      <button type="button" class="btn btn-primary">중복확인</button>
                    </div>
                  </div>
                  <form:errors path="user_id" style="color:coral" />
                </div>
                <div class="form-group">
                  <form:label path="user_pw">비밀번호</form:label>
                  <form:input path="user_pw" class="form-control" />
                  <form:errors path="user_pw" style="color:coral" />
                </div>
                <div class="form-group">
                  <form:label path="user_pw2">비밀번호 확인</form:label>
                  <form:input path="user_pw2" class="form-control" />
                  <form:errors path="user_pw2" style="color:coral" />
                </div>
                <div class="form-group">
                  <div class="text-right">
                    <button type="submit" class="btn btn-primary">회원가입</button>
                  </div>
                </div>
              </form:form>
            </div>
          </div>
        </div>
        <div class="col-sm-3"></div>
      </div>
    </div>

    <!-- 하단 푸터 부분 -->
	<c:import url="/WEB-INF/views/include/footer.jsp" />
  </body>
</html>
