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

    <!-- 게시글 리스트 -->
    <div class="container" style="margin-top: 100px">
      <div class="card shadow">
        <div class="card-body">
          <h4 class="card-title">게시판 이름</h4>
          <table class="table table-hover" id="board_list">
            <thead>
              <tr>
                <th class="text-center d-none d-md-table-cell">글번호</th>
                <th class="w-50">제목</th>
                <th class="text-center d-none d-md-table-cell">작성자</th>
                <th class="text-center d-none d-md-table-cell">작성날짜</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
              <tr>
                <td class="text-center d-none d-md-table-cell">10</td>
                <td><a href="board_read.html">글 제목 입니다</a></td>
                <td class="text-center d-none d-md-table-cell">홍길동</td>
                <td class="text-center d-none d-md-table-cell">2018-12-12</td>
              </tr>
            </tbody>
          </table>

          <div class="d-none d-md-block">
            <ul class="pagination justify-content-center">
              <li class="page-item">
                <a href="#" class="page-link">이전</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">1</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">2</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">3</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">4</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">5</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">6</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">7</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">8</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">9</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">10</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">다음</a>
              </li>
            </ul>
          </div>

          <div class="d-block d-md-none">
            <ul class="pagination justify-content-center">
              <li class="page-item">
                <a href="#" class="page-link">이전</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">다음</a>
              </li>
            </ul>
          </div>

          <div class="text-right">
            <a href="board_write.html" class="btn btn-primary">글쓰기</a>
          </div>
        </div>
      </div>
    </div>
   
    <!-- 하단 푸터 부분 -->
	<c:import url="/WEB-INF/views/include/footer.jsp" />
  </body>
</html>
