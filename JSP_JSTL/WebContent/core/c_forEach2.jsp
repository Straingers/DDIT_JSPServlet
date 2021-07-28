<%@page import="com.jsp.dto.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<MemberVO> memberList = new ArrayList<MemberVO>();
	for(int i = 1; i < 11; i++) {
		MemberVO member = new MemberVO("mimi" + i, "mimi", "mimi@naver.com", "010-1234-1234");
		memberList.add(member);
	}
	pageContext.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PWD</th>
			<th>EMAIL</th>
			<th>PHONE</th>
		</tr>
		<%--
		if(memberList != null){
			for(MemberVO member : memberList){
				pageContext.setAttribute("member", member);
		--%>
	<c:if test="${empty memberList }">
		<tr align="center">
			<td colspan="4">회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items="${memberList }" var="member">
		<tr>
			<td>${member.id }</td>
			<td>${member.pwd }</td>
			<td>${member.email }</td>
			<td>${member.phone }</td>
		</tr>
	</c:forEach>
		<%--
			}
		}
		--%>
	</table>
</body>
</html>