<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("선택된 상품이 삭제되었습니다.");
	location.href = "list.do?id=${id}";
</script>