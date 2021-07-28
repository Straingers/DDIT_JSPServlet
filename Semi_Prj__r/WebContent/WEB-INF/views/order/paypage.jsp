<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head></head>

<title>장바구니</title>

<body>
	<!-- Main content -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row md-2">
				<div class="col-sm-6">
					<h1>주문하기</h1>  				
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item">
							<a href="list.do">
								<i class="fa fa-dashboard"></i>장바구니
						 	</a>
						</li>
						<li class="breadcrumb-item active">
							목록
						</li>		        
					 </ol>
				</div>
			</div>
		</div>
	</section>

	<section class="content">
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" onclick="pay_go();">결제</button>
				<button type="button" class="btn btn-danger" onclick="cancel_go();">취소</button>
			</div>
			<div class="card-body" style="text-align:center;">
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-hover">
							<tr>
								<th width="10%">번호</th>
								<th width="10%">이미지</th>
								<th width="35%">상품명</th>
								<th width="10%">수량</th>
								<th width="30%">금액</th>
							</tr>
							<c:forEach items="${orderList }" var="order">
							<c:if test="${order.orderStatus eq '결제대기' }">
							<tr valign="middle" >
								<td><span name="orderNo">${order.orderNo }</span></td>
								<td>
									<img src="/order/getPicture.do?picture=${order.picture}" class="img-fluid mb-2" alt="img">
								</td>
								<td>${order.prodName }</td>
								<td>${order.orderQty }</td>
								<td><span name="orderCost">${order.orderCost * order.orderQty }</span></td>
							</tr>	
							</c:if>							
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="card-footer">
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<ul class="list-group list-group-unbordered mb-3">
		                  <li class="list-group-item">
		                    <b>결제 금액</b> <span id="totalPrice" class="float-right">0</span>
		                  </li>
	                	</ul>
					</div>
					<div class="col-sm-4"></div>
				</div>
			</div>
		</div>
	</section>
	<form id="fm">
		<input type="hidden" id="fmOrderNo" name="orderNo" />
		<input type="hidden" id="fmOrderStatus" name="orderStatus" />
	</form>
	
<script type="text/javascript">
window.onload = function(){
	var money = 0;
	$('span[name="orderCost"').each(function(){
		money += parseInt($(this).text());
	});
	$("#totalPrice").text(money + "원");
}

function pay_go(){
	if(!confirm("결제 하시겠습니까?")){
		return;
	}
	var tmp = "";
	$('span[name="orderNo"]').each(function(){
		tmp += $(this).text() + ",";
	});
	$("#fmOrderNo").val(tmp.substring(0, tmp.length - 1));
	$("#fmOrderStatus").val("결제완료");
	$("#fm").attr({
		"action" : "pay.do"
		, "method" : "post"
	}).submit();
}

function cancel_go(){
	if(!confirm("결제 취소 하시겠습니까?")){
		return;
	}
	var tmp = "";
	$('span[name="orderNo"]').each(function(){
		tmp += $(this).text() + ",";
	});
	$("#fmOrderNo").val(tmp.substring(0, tmp.length - 1));
	$("#fmOrderStatus").val("주문대기");
	$("#fm").attr({
		"action" : "pay.do"
		, "method" : "post"
	}).submit();
}
</script>
</body>