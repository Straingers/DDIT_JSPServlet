<%@page import="com.jsp.dto.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	List<MemberVO> memberList = new ArrayList<MemberVO>();
	for(int i = 1; i < 11; i++) {
		MemberVO member = new MemberVO("mimi" + i, "mimi", "mimi@naver.com", "010-1234-1234");
		memberList.add(member);
	}
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
		<tr align="center">
			<td colspan="4">방법1</td>
		</tr>
		<%
		for(int i = 0; i < memberList.size(); i++){
			pageContext.setAttribute("member", memberList.get(i));
		%>
		<tr>
			<td>${member.id }</td>
			<td>${member.pwd }</td>
			<td>${member.email }</td>
			<td>${member.phone }</td>
		</tr>
		<%
		}
		%>
		<tr align="center">
			<td colspan="4">방법2</td>
		</tr>
		<%
		if(memberList != null){
			for(MemberVO member : memberList){
				pageContext.setAttribute("member", member);
		%>
		<tr>
			<td>${member.id }</td>
			<td>${member.pwd }</td>
			<td>${member.email }</td>
			<td>${member.phone }</td>
		</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>