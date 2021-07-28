<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	<c:if test="${empty loginUser }">
		alert("회원이 삭제되었습니다.\n로그아웃 됩니다.");
		window.opener.parent.location.href = "<%=request.getContextPath() %>";
	</c:if>
	<c:if test="${!empty loginUser }">
		alert('회원이 삭제되었습니다.\n회원 리스트로 돌아갑니다.');
		window.opener.parent.location.reload();
	</c:if>
	
	window.close();
</script>