<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%!
public int total(int kor, int eng, int math, int sci){
	return kor + eng + math + sci;
}
%>
<%
	String korParam = request.getParameter("kor");
	String engParam = request.getParameter("eng");
	String mathParam = request.getParameter("math");
	String sciParam = request.getParameter("sci");
	
	float avg = 0.0f;
	try{
		int kor = Integer.parseInt(korParam);
		int eng = Integer.parseInt(engParam);
		int math = Integer.parseInt(mathParam);
		int sci = Integer.parseInt(sciParam);
		
		int total = total(kor, eng, math, sci);
		
		avg = total / 4.0f;
		pageContext.setAttribute("avg", avg);
	} catch (Exception e){
		out.println("입력값이 올바르지 않습니다.");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	alert('평균 : ${avg }');
</script>
</head>
<body>
</body>
</html>