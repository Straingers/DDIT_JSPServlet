<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<body>
<script>
	alert("회원가입 축하드립니다!!");
	
	window.onload=function(){
		$.ajax({
			url:"/getMcode.do?mName=회원목록",
			type:"get",
			success:function(menu){
				location.href="/";			
			}
		});		
	}
</script>
</body>