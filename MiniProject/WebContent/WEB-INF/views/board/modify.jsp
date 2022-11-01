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
            
			<form:form action='${root }board/modify_pro' modelAttribute="modifyContentBean" enctype="multipart/form-data">
				<form:hidden path="content_idx"/>
				<form:hidden path="content_board_idx"/>
				<div class="form-group">
					<form:label path="content_writer_name">작성자</form:label>
					<form:input path="content_writer_name" class='form-control' readonly="true"/>
				</div>
				<div class="form-group">
					<form:label path="content_date">작성날짜</form:label>
					<form:input path="content_date" class='form-control' readonly='true'/>
				</div>
				<div class="form-group">
					<form:label path="content_subject">제목</form:label>
					<form:input path="content_subject" class='form-control'/>
					<form:errors path="content_subject" style='color:red'/>
				</div>
				<div class="form-group">
					<form:label path="content_text">내용</form:label>
					<form:textarea path="content_text" class="form-control" rows="10" style="resize:none"/>
					<form:errors path="content_text" style='color:red'/>
				</div>
				<div class="form-group">
					<label for="board_file">첨부 이미지</label>
					<c:if test="${modifyContentBean.content_file != null }">
					<img src="${root }upload/${modifyContentBean.content_file}" width="100%"/>	
					<form:hidden path="content_file"/>
					</c:if>
					<form:input path="upload_file" type='file' class="form-control" accept="image/*"/>
				</div>
				<div class="form-group">
					<div class="text-right">
						<form:button class='btn btn-primary'>수정완료</form:button>
						<a href="${root }board/read?board_info_idx=${modifyContentBean.content_board_idx}&content_idx=${modifyContentBean.content_idx}" class="btn btn-info">취소</a>
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

