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
					<h1>장바구니</h1>  				
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
		<c:if test="${!empty orderList }">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" onclick="order_go();">주문하기</button>
				<button type="button" class="btn btn-danger" onclick="remove_go('${loginUser.id}');">삭제</button>
			</div>
			</c:if>
			<div class="card-body" style="text-align:center;">
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-hover">
							<tr>
								<th width="5%">선택</th>
								<th width="10%">번호</th>
								<th width="10%">이미지</th>
								<th width="35%">상품명</th>
								<th width="10%">수량</th>
								<th width="30%">금액</th>
							</tr>
							<c:if test="${empty orderList }">
							<tr text-align="center">
								<td colspan="7">장바구니가 비었습니다.</td>
							</tr>
							</c:if>
							<c:forEach items="${orderList }" var="order">
							<c:if test="${order.orderStatus eq '주문대기' }">
							<tr valign="middle" >
								<td>
									<input type="checkbox" name="orderCheck" value="${order.orderNo }" onchange="money_go(this, ${order.orderCost * order.orderQty });"/>
								</td>
								<td>${order.orderNo }</td>
								<td class="product-image-thumb active" onclick="OpenWindow('/prod/detail.do?id=${order.prodId}', '', '1600', '900');">
									<img src="/order/getPicture.do?picture=${order.picture}" class="img-fluid mb-2" alt="img">
								</td>
								<td onclick="OpenWindow('/prod/detail.do?id=${order.prodId}', '', '1600', '900');">${order.prodName }</td>
								<td>
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-8">
											<input type="number" min="1" class="form-control" name="orderQty" value="${order.orderQty }" >
										</div>
										<div class="col-sm-2">
											<button type="button" class="btn btn-default" onclick="qty_go('${loginUser.id}', '${order.orderNo}', '${order.orderNoDetail}');">변경</button>
										</div>
									</div>
								</td>
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
		                    <b>선택한 상품 가격 </b> <span id="selectPrice" class="float-right">0</span>
		                  </li>
		                  <li class="list-group-item">
		                    <b>전체 가격</b> <span id="totalPrice" class="float-right">0</span>
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
		<input type="hidden" id="fmid" name="id" />
	</form>
	
<script type="text/javascript">
	window.onload = function(){
		var money = 0;
		$('span[name="orderCost"').each(function(){
			money += parseInt($(this).text());
		});
		$("#totalPrice").text(money);
	}
	function qty_go(id, orderNo, orderNoDetail){
		var reqData = {
			"id" : id
			, "orderNo" : orderNo
			, "orderNoDetail" : orderNoDetail
			, "orderQty" : $("input[name='orderQty']").val()
		};
		
		$.ajax({
			url : "changeQty.do"
			, data : reqData
			, type : "POST"
			, contextType : "application/json"
			, success : function(data) {
				alert("수정 되었습니다.")
				location.reload();
			}
		});
	}
	
	function order_go(){
		if($("input:checkbox[name='orderCheck']:checked").length < 1){
			alert("선택된 상품이 없습니다.");
			return;
		}
		if(!confirm("선택한 상품을 주문 하시겠습니까?")){
			return;
		}
		var tmp = "";	
		$('input[type="checkbox"]:checked').each(function(){
			tmp += $(this).val() + ",";
		});
		$("#fmOrderNo").val(tmp.substring(0, tmp.length - 1));
		$("#fm").attr({
			"action" : "order.do"
			, "method" : "post"
		}).submit();
	}
	
	function remove_go(id) {
		if($("input:checkbox[name='orderCheck']:checked").length < 1){
			alert("선택된 상품이 없습니다.");
			return;
		}
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}
		var tmp = "";	
		$('input[type="checkbox"]:checked').each(function(){
			tmp += $(this).val() + ",";
		});
		$("#fmOrderNo").val(tmp.substring(0, tmp.length - 1));
		$("#fmid").val(id)
		$("#fm").attr({
			"action" : "remove.do"
			, "method" : "post"
		}).submit();
	}
	
	function money_go(obj, cost){
		var money = parseInt($("#selectPrice").text());
		if(obj.checked == true){
			money += cost;
		}else {
			money -= cost;
		}
		$("#selectPrice").text(money);
	}
</script>
</body>