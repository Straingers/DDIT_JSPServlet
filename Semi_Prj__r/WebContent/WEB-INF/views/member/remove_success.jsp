<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	alert("탈퇴처리가 되었습니다. 고객님을 영원히 기다립니다.");
	
	<c:if test="${!empty loginUser}">
		window.parent.location.reload();
	</c:if>
	<c:if test="${empty loginUser}">
		window.parent.location.href="/";
	</c:if>
	
	CloseWindow();
</script>

