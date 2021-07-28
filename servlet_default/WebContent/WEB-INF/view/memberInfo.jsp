<%@page import="com.servlet.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세</title>
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
<script type="text/javascript">
	function updateMember(memId){
		location.href = "/servlet_default/memberUpdate?memId=" + memId;
	}
	
	function deleteMember(memId){
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}
		location.href = "/servlet_default/memberDelete?memId=" + memId;
	}
	
	function goList() {
		location.href = "/servlet_default/memberList";
	}
</script>
</head>
<body>
	 <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-9" align="center">
            <h1>회원 정보</h1>
          </div>
          <div class="col-sm-3">
            <ol class="breadcrumb float-sm-right">
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
	<div class="card-body box-profile">
			<h3 class="profile-username text-center">${mv.memName }</h3>
			
		<div class="row">
		<div class="col-sm-4"></div>
			<div class="col-sm-4">
			<ul class="list-group list-group-unbordered mb-3">
			  <li class="list-group-item">
			    <b>ID</b> <span class="float-right">${mv.memId }</span>
			  </li>
			  <li class="list-group-item">
			    <b>PW</b> <span class="float-right">${mv.memPw }</span>
			  </li>
			  <li class="list-group-item">
			    <b>TEL</b> <span class="float-right">${mv.memTel }</span>
			  </li>
			</ul>
			<a href="#" onclick="updateMember('${mv.memId }')" class="btn btn-primary btn-block"><b>정보수정</b></a>
			<a href="#" onclick="deleteMember('${mv.memId }')"  class="btn btn-primary btn-block"><b>삭제</b></a>
			<a href="#" onclick="goList()" class="btn btn-primary btn-block"><b>메인으로</b></a>
		</div>
		<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>