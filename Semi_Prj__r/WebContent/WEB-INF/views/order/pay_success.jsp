<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("${msg}\n장바구니로 돌아갑니다.");
	location.href = "list.do?id=${loginUser.id}";
</script>