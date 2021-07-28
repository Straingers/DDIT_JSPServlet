<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	*{
		margin: 0; 
		padding: 0;
	}
	header{
		height: 150px;
	}
	div#content-wrap{
		height: 600px;
		position: relative;
	}
	aside{
		width: 300px;
		height: 100%;
	}
	section{
		position: absolute;
		left: 300px;
		top: 0;
		widows: 100%;
		height: 100%;
	}
	footer{
		height: 150px;
	}
</style>
</head>

<% request.setAttribute("msg", "from page"); %>
<% String msg = "local variable"; %>

<body>
	<header>
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
	</header>
	<div id="content-wrap">
		<aside>
			<c:import url="/WEB-INF/views/include/aside.jsp"></c:import>
		</aside>
		<section>
			<h1>section</h1>
			<c:import url="https://www.naver.com"></c:import>
		</section>
	</div>
	<footer>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</footer>
</body>
</html>