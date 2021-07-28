<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		List<Integer> intList = (ArrayList<Integer>) request.getAttribute("intList");
		for(int i : intList){
	%>
			<span><%=i %></span>&nbsp;
	<%		
		}
	%>
</body>
</html>