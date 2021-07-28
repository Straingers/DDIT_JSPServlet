<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	for(int i = 2; i < 10; i++){
%>
<h3><%=i %>단</h3>
<p>
<%
		for(int j = 1; j < 10; j++){ 
%>
<%=i %> X <%=j %> = <%=i*j %><br/>
<%
		}
%>
</p>
<%
	}
%>