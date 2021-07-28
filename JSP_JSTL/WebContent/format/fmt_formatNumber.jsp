<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% int price = 10000000; %>
<c:set var="price" value="<%=price %>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	price(local variable, $#,###) : 
	<fmt:formatNumber value="<%=price %>" pattern="#,###"/><br/>
	price(attribute variable, ￦#,###) :
	￦<fmt:formatNumber value="${price }" pattern="#,###"/> 
</body>
</html>