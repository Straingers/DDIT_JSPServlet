<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>

<title>Kim's Home</title>
<head>
<style type="text/css">
	*{
		margin: 0; padding: 0;		
	}
</style>
</head>
	
<body>
	<%@ include file="/WEB-INF/views/include/main_header.jsp" %>
	<%@ include file="/WEB-INF/views/include/main_aside.jsp" %>
	<div class="content-wrapper" style="background-color: #fff">
		<iframe name="ifr" src="/main.do" frameborder="0" style="width:100%; height: 80vh;"></iframe>
	</div>
 	<%@ include file="/WEB-INF/views/include/main_footer.jsp" %>

	<!-- handlebars -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
	
	<script src="<%=request.getContextPath() %>/resources/js/index.js"></script>
	
	<script type="text/x-handlebars-template"  id="subMenu-list-template" >
	{{#each .}}
		<li class="nav-item subMenu" >
      		<a href="javascript:goPage('{{mUrl}}','{{mCode}}');" class="nav-link">
         	 <i class="{{mIcon}}"></i>
         	    <p>{{mName}}</p>
        	</a>
		</li>
	{{/each}}
	</script>
	
	<!-- common -->
	<script type="text/javascript">
		function init() {
			goPage('${menu.mUrl}', '${menu.mCode}');
			subMenu('${menu.mCode}'.substring(0, 3) + '0000');
		}
	</script>
</body>