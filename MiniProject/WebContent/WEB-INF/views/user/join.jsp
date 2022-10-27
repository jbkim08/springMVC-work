<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
              <form action="login.html" method="post">
                <div class="form-group">
                  <label for="user_name">이름</label>
                  <input type="text" id="user_name" name="user_name" class="form-control" />
                </div>
                <div class="form-group">
                  <label for="user_id">아이디</label>
                  <div class="input-group">
                    <input type="text" id="user_id" name="user_id" class="form-control" />
                    <div class="input-group-append">
                      <button type="button" class="btn btn-primary">중복확인</button>
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="user_pw">비밀번호</label>
                  <input type="password" id="user_pw" name="user_pw" class="form-control" />
                </div>
                <div class="form-group">
                  <label for="user_pw2">비밀번호 확인</label>
                  <input type="password" id="user_pw2" name="user_pw2" class="form-control" />
                </div>
                <div class="form-group">
                  <div class="text-right">
                    <button type="submit" class="btn btn-primary">회원가입</button>
                  </div>
                </div>
              </form>
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
