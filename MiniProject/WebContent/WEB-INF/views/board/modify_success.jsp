<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />        
<script>
alert('수정 되었습니다')
location.href = '${root }board/read?board_info_idx=${modifyContentBean.content_board_idx}&page=${page}&content_idx=${modifyContentBean.content_idx}'
</script>