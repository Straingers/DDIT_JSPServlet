<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cri" value="${pageMaker.cri }" />
<!DOCTYPE html>
<html lang="en">
<head>
	<title>회원 목록</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<br/><br/>
	<h2>회원 목록</h2>
	<br/>
	<div class="row">
		<div class="col-sm-4">
			<input type="button" class="btn btn-info" value="회원등록" onclick="insertMember()" />
		</div>
		<div class="col-sm-8">
			<div class="row">
				<div class="col-sm-3">
					<select class="form-control col-sm-12" name="perPageNum" id="perPageNum" onchange="list_go(1)">
						<option value="10" ${cri.perPageNum == 10 ? 'selected' : '' }>개수선택</option>
						<option value="3" ${cri.perPageNum == 3 ? 'selected' : '' }>3</option>
						<option value="5" ${cri.perPageNum == 5 ? 'selected' : '' }>5</option>
						<option value="7" ${cri.perPageNum == 7 ? 'selected' : '' }>7</option>
					</select>
				</div>
				<div class="col-sm-3">
				<select class="form-control col-sm-12" name="searchType" id="searchType">
					<option value="">검색옵션</option>
					<option value="i" ${cri.searchType eq 'i' ? 'selected' : '' }>아이디</option>
					<option value="n" ${cri.searchType eq 'n' ? 'selected' : '' }>이름</option>
					<option value="t" ${cri.searchType eq 't' ? 'selected' : '' }>전화번호</option>
				</select>
				</div>
				<div class="col-sm-6">
					<span class="input-group-append">
						<input class="form-control" type="text" name="keyword" id="keyword" placeholder="검색어를 입력하세요." value="${cri.keyword }" />
						<input type="button" class="btn btn-info" value="검색" onclick="list_go(1);" />
					</span>
				</div>
			</div>
		</div>
	</div>
	<br/>
    <table class="table">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>이름</th>
	        <th>전화번호</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${memberList }" var="member">
			<tr>
			  <td>
			  <a href="/member/memberInfo.do?id=${id }">
			  	${member.id }
			  </a>
			  </td>
			  <td>${member.name }</td>
			  <td>${member.phone}</td>
			</tr>
			</c:forEach> 
	    </tbody>
    </table>
  <div class="row">
  	<div class="col-sm-4">
  	</div>
  	<div class="col-sm-4">
  		<div class="row">
  			<div class="col-sm-2">
  				<a href="javascript:list_go(1);">
					<<
				</a>
  			</div>
  			<div class="col-sm-2">
				<a href="javascript:list_go(${pageMaker.prev ? pageMaker.startPage - 1 : 1 });">
					<
				</a>
  			</div>
  			<div class="col-sm-4">
				<c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
					<a href="javascript:list_go(${pageNum });">${pageNum }</a>
				</c:forEach>
  			</div>
  			<div class="col-sm-2">
				<a href="javascript:list_go(${pageMaker.next ? pageMaker.endPage + 1 : pageMaker.cri.page });">
					>
				</a>
  			</div>
				<a href="javascript:list_go(${pageMaker.realEndPage });">
					>>
				</a>
  			<div class="col-sm-2">
  			</div>
  		</div>
  	</div>
	<div class="col-sm-4">
  	</div>
  </div>
</div>

<form id="pageForm">
	<input type="hidden" name="page" value=""/>
	<input type="hidden" name="perPageNum" value=""/>
	<input type="hidden" name="searchType" value=""/>
	<input type="hidden" name="keyword" value=""/>
</form>

<script type="text/javascript">
	function list_go(page){
		var pageForm = $("#pageForm");
		
		pageForm.find('[name="page"]').val(page);
		pageForm.find('[name="perPageNum"]').val($('select[name="perPageNum]').val());
		pageForm.find('[name="searchType"]').val($('select[name="searchType"]').val());
		pageForm.find('[name="keyword"]').val($('div.input-group>input[name="keyword"]').val());
		
		pageForm.attr({
			action : "memberList.do"
			, method : 'get'
		}).submit();
	}
</script>

</body>
</html>
