<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("${member.name}님의 정보가 수정되었습니다.\n회원 상세보기로 돌아갑니다.");
	location.href = "detail.do?id=${member.id}";
</script>