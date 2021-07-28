<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="prodList" value="${dataMap.prodList }" />

<head></head>

<title>상품목록</title>

<body>
	<!-- Main content -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row md-2">
				<div class="col-sm-6">
					<h1>상품목록</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="list.do"> <i
								class="fa fa-dashboard"></i>상품사항
						</a></li>
						<li class="breadcrumb-item active">목록</li>
					</ol>
				</div>
			</div>
		</div>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="card">
			<div class="card-header with-border">
			<c:if test="${loginUser.authority eq '1' }">
				<button type="button" class="btn btn-primary" id="registBtn"
					onclick="OpenWindow('registForm.do','상품등록',800,700);">상품등록</button>
			</c:if>
				<div id="keyword" class="card-tools" style="width: 450px;">
					<div class="input-group row">
						<select class="form-control col-md-3" name="perPageNum"
							id="perPageNum" onchange="list_go();">
							<option value="10">정렬개수</option>
							<option value="20" ${cri.perPageNum == 20 ? 'selected':''}>20개씩</option>
							<option value="50" ${cri.perPageNum == 50 ? 'selected':''}>50개씩</option>
							<option value="100" ${cri.perPageNum == 100 ? 'selected':''}>100개씩</option>

						</select> 
						<select class="form-control col-md-4" name="searchType"	id="searchType">
							<option value="ndc" ${cri.searchType eq 'ndc' ? 'selected':'' }>전체</option>
							<option value="n" ${cri.searchType eq 'n'   ? 'selected':'' }>상품명</option>
							<option value="d" ${cri.searchType eq 'd'   ? 'selected':'' }>내 용</option>
							<option value="c" ${cri.searchType eq 'c'   ? 'selected':'' }>카테고리</option>
							<option value="nc" ${cri.searchType eq 'nc'  ? 'selected':'' }>상품명+카테고리</option>
							<option value="dc" ${cri.searchType eq 'dc'  ? 'selected':'' }>내 용+카테고리</option>
							<option value="ncd" ${cri.searchType eq 'ncd' ? 'selected':'' }>상품명+내 용+카테고리</option>
						</select>
						 <input class="form-control" type="text" name="keyword"
							placeholder="검색어를 입력하세요." value="${param.keyword }" /> <span
							class="input-group-append">
							<button class="btn btn-primary" type="button"
								onclick="list_go(1);" data-card-widget="search">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
			<div class="card-body">
				<table class="table table-bordered text-center table-valign-middle"
					style="vertical-align: middle;">
					<tr style="font-size: 0.95em; vertical-align: middle;">
						<th style="width: 10%;">카테고리</th>
						<th style="width: 15%;">상품명</th>
						<th style="width: 25%;">사진</th>
						<th style="width: 10%;">가격</th>
						<th style="width: 40%;">상품요약</th>
					</tr>
					<c:if test="${empty prodList }">
						<tbody>
							<tr>
								<td colspan="5"><strong>해당 내용이 없습니다.</strong></td>
							</tr>
						</tbody>
					</c:if>
					<c:forEach items="${prodList }" var="prod">
						<tbody>
							<tr>
								<td>${prod.category }</td>
								<td id="name"
									style="text-align: left; max-width: 100px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
									<a
									href="javascript:OpenWindow('detail.do?id=${prod.id }','상세보기',1600,800);">
										${prod.name } </a>
								</td>
								<td><img alt="prodImg"
									src='getPicture.do?picture=${prod.picture }'
									style="width: 150px; height: 150px; text-align: center;"></td>
								<td>${prod.price }</td>
								<td>${prod.outline }</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
			<div class="card-footer">
				<%@ include file="/WEB-INF/views/common/pagination.jsp"%>
			</div>
		</div>

	</section>
	<!-- /.content -->

	<script src="/resources/js/common.js"></script>

</body>
