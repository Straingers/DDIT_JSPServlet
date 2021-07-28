<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/index.do" class="brand-link">
      <img src="<%=request.getContextPath()%>/resources/bootstrap/dist/img/2.png" alt="Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">신발사슈</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      	<c:if test="${!empty loginUser }">
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
        	 <img src="/member/getPicture.do?picture=${loginUser.picture}" class="img-circle elevation-2" 
        	 	alt="User Image">
        </div>
        <div class="info">
         	<div class="row">
              <a href="#" class="d-block">&nbsp&nbsp${loginUser.name }</a>
              <button onclick="location.href='<%=request.getContextPath() %>/logout.do';" 
              	class="btn btn-xs btn-primary col-xs-3 " type="button" >LOGOUT</button>
         	</div>
<%--            	<a href="tel:${loginUser.phone }">tel : ${loginUser.phone }</a><br/> --%>
           	<a href="mailto:${loginUser.email}">${loginUser.email }</a>		
        </div>    
      </div>
      </c:if>
	<c:if test="${empty loginUser }">
   	<form action="<%=request.getContextPath() %>/login.do"	method="post">
		<div class="form-group has-feedback">
			<input type="text" class="form-control" id="loginId" name="id" placeholder="아이디를 입력하세요." value="">
			<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
		<div class="form-group has-feedback">
			<input type="password" class="form-control" name="pwd" placeholder="패스워드를 입력하세요."  value="">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="checkbox icheck">
					<button type="button" class="btn btn-primary btn-block btn-flat btn-sm" onclick="goPage('member/registForm.do', 'M010200');">회원가입</button>
				</div>
			</div>
			<div class="col-sm-6">
				<button type="submit" class="btn btn-primary btn-block btn-flat btn-sm">로그인</button>
			</div>
			<!-- /.col -->
		</div>
	</form>
	</c:if>
	
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column subMenuList" data-widget="treeview" role="menu" data-accordion="false">
       		<!--  sub-menu-list -->
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
