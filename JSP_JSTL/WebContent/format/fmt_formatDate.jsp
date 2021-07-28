<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% Date today = new Date(); %>
<c:set var="today" value="<%=today %>"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	Today(local variable, yyyy-MM-dd HH:mm:ss) : 
	<fmt:formatDate value="<%=today %>" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
	Today(attribute variable, yyyy/MM/dd hh:mm:ss) : 
	<fmt:formatDate value="${today }" pattern="yyyy/MM/dd hh:mm:ss" />
</body>
</html>