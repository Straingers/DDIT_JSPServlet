<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<script>
	alert("상품 수정에 성공했습니다.");
	location.href = "detail.do?id=${prod.id}";
	opener.location.reload();
	window.close();
</script>