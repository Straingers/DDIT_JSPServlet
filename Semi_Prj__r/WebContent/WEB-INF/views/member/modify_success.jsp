<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<body>
<script>
	alert("회원님의 정보가 수정되었습니다.");
	//location.href=''reload();
	window.parent.location.reload();
 	location.href='detail.do?id=${loginUser.id}';
</script>
</body>