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
	<%
		int sum = 0;
		for(int i = 1; i < 11; i++){
			sum += i;
	%>
			<%=i %><%=i != 10 ? "+" : "" %>
	<%
		}
	%> = <%=sum %>
</body>
</html>