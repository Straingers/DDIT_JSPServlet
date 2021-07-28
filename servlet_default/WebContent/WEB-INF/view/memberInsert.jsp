<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>회원 등록</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
	function goList() {
		location.href = "/servlet_default/memberList";
	}
</script>
</head>
<body>

<div class="container content">
  <h2 align="center">회원 등록</h2>
  <form action="/servlet_default/memberInsert" method="post">
  	<div class="row">
	  	<div class="col-sm-3"></div>
	    <div class="form-group col-sm-6">
	      <label for="memId">ID:</label>
	      <input type="text" class="form-control" id="memId" name="memId" />
	    </div>
	  	<div class="col-sm-3"></div>
  	</div>
  	<div class="row">
  		<div class="col-sm-3"></div>
	    <div class="form-group col-sm-6">
	      <label for="memPw">Password:</label>
	      <input type="password" class="form-control" id="memPw" name="memPw" />
	    </div>
	    <div class="col-sm-3"></div>
    </div>
    <div class="row">
	    <div class="col-sm-3"></div>
	    <div class="form-group col-sm-6">
	      <label for="memName">이름:</label>
	      <input type="text" class="form-control" id="memName" name="memName" />
	    </div>
	    <div class="col-sm-3"></div>
    </div>
    <div class="row">
	    <div class="col-sm-3"></div>
	    <div class="form-group col-sm-6">
	      <label for="memTel">전화번호:</label>
	      <input type="text" class="form-control" id="memTel" name="memTel" />
	    </div>
	    <div class="col-sm-3"></div>
	</div>
	<br/><br/>
	<div class="row">
		<div class="col-sm-9" align="right">
		    <input type="button" class="btn btn-info" onclick="goList()" value="메인으로" />
		    <input type="reset" class="btn btn-info" value="초기화" />
		    <input type="submit" class="btn btn-info" value="저장" />
		</div>
	    <div class="col-sm-3"></div>
	</div>
  </form>
</div>
</body>
</html>