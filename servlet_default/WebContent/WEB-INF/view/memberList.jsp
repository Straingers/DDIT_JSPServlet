<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>회원 목록</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<script type="text/javascript">
  	<c:if test="${not empty msg }" >
  		alert("${msg }");
  	</c:if>
  	<c:if test="${back eq 'Y' }" >
  		history.go(-1);
	</c:if>
	function insertMember(){
		location.href = "/servlet_default/memberInsert";
 	}
</script>
<div class="container">
	<br><br>
  <h2>회원 목록</h2>
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>이름</th>
        <th>전화번호</th>
      </tr>
    </thead>
    <tbody>
    	<c:if test="${not empty notMember }">
    	<tr>
    		<td colspan=3 align="center">
    			${notMember }
    		</td>
    	</tr>
    	</c:if>
    	<c:forEach items="${memberList }" var="member">
		<tr>
		  <td>
		  <a href="/servlet_default/memberInfo?memId=${member.memId }">
		  	${member.memId }
		  </a>
		  </td>
		  <td>${member.memName }</td>
		  <td>${member.memTel }</td>
		</tr>
		</c:forEach> 
    </tbody>
  </table>
  <div align="right">
	  <input type="button" class="btn btn-info" value="회원등록" onclick="insertMember()" />
  </div>
</div>
</body>
</html>
