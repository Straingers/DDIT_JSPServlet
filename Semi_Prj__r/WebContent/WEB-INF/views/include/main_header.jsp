<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav main-menu-list">
     	<!-- main menu list -->
     	<c:forEach items="${menuList }" var="menu">
    	<li class="nav-item d-none d-sm-inline-block"  >
    	<a href="javascript:subMenu('${menu.mcode }');goPage('${menu.murl}','${menu.mcode }');"
    		class="nav-link">
    			<i class="${menu.micon }" ></i>
    			${menu.mname }
    		</a>
    	</li>
    	</c:forEach>
    	
    </ul>

    <!-- SEARCH FORM -->
    <form class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>

  </nav>
  <!-- /.navbar -->