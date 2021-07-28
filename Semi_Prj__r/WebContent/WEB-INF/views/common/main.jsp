<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="noticeList" value="${dataMap.noticeList }" />
<c:set var="boardList" value="${dataMap2.boardList }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-6">
					<div class="card">
						<div class="card-header"><strong>공지사항 최신글</strong></div>
						<div class="card-body">
							<table class="table table-bordered text-center">
								<tr style="font-size: 0.95em;">
									<th style="width: 10%;">번 호</th>
									<th style="width: 50%;">제 목</th>
									<th style="width: 15%;">작성자</th>
									<th>등록일</th>
<!-- 									<th style="width: 10%;">조회수</th> -->
								</tr>
								<c:if test="${empty noticeList }">
									<tr>
										<td colspan="5"><strong>해당 내용이 없습니다.</strong></td>
									</tr>
								</c:if>
								<c:forEach var="notice"  items="${noticeList }">
									<tr style='font-size: 0.85em;'>
										<td>${notice.nno }</td>
										<td id="boardTitle"
											style="text-align: left; max-width: 100px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">

											<a
											href="javascript:OpenWindow('notice/detail.do?nno=${notice.nno }','상세보기',800,700);">
												${notice.title } </a>
										</td>
										<td>${notice.writer }</td>
										<td><fmt:formatDate value="${notice.regDate }"
												pattern="yyyy-MM-dd" /></td>
<%-- 										<td><span class="badge bg-red">${notice.viewcnt }</span></td> --%>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="card-footer text-center"><a href="/notice/list.do">전체보기</a></div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-header"><strong>자유게시판 최신글</strong></div>
						<div class="card-body">
										<table class="table table-bordered text-center" >					
					<tr style="font-size:0.95em;">
						<th style="width:10%;">번 호</th>
						<th style="width:50%;">제 목</th>
						<th style="width:15%;">작성자</th>
						<th>등록일</th>
<!-- 						<th style="width:10%;">조회수</th> -->
					</tr>				
					<c:if test="${empty boardList }" >
						<tr>
							<td colspan="5">
								<strong>해당 내용이 없습니다.</strong>
							</td>
						</tr>
					</c:if>						
					<c:forEach items="${boardList }" var="board">
						<tr style='font-size:0.85em;'>
							<td>${board.bno }</td>
							<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden; 
												white-space: nowrap; text-overflow: ellipsis;">
												
							<a href="javascript:OpenWindow('board/detail.do?bno=${board.bno }','상세보기',800,700);">
								<span class="col-sm-12 ">${board.title }
									<c:if test="${board.replycnt ne 0 }">		
										<span class="nav-item">															
										&nbsp;&nbsp;<i class="fa fa-comment"></i>
										<span class="badge badge-warning navbar-badge">${board.replycnt}</span>
										</span>
										
									</c:if>
								</span>								
							</a>
							</td>
							<td>${board.writer }</td>
							<td>
								<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/>
							</td>
<%-- 							<td><span class="badge bg-red">${board.viewcnt }</span></td> --%>
						</tr>
					</c:forEach>
				</table>
						
						
						</div>
						<div class="card-footer text-center"><a href="/board/list.do">전체보기</a></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>