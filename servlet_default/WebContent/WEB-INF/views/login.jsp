<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>login.jsp</h1>
	<form action="login" method="post">
		아이디 : <input type="text" name="memId" /><br/>
		비밀번호 : <input type="password" name="memPw" /><br/>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>