<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>상품상세보기</title>

<body>
	<!-- Content Wrapper. Contains page content -->
	<div>
		<section class="content-header">
			<div class="container-fluid">
				<div class="row md-2">
					<div class="col-sm-6">
						<h1>상세페이지</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#"> <i
									class="fa fa-dashboard">상품관리</i>
							</a></li>
							<li class="breadcrumb-item active">상세보기</li>
						</ol>
					</div>
				</div>
			</div>
		</section>
		<!-- Main content -->
<section class="content">

      <!-- Default box -->
      <div class="card card-solid">
        <div class="card-body">
          <div class="row">
            <div class="col-12 col-sm-6">
              <h3 class="d-inline-block d-sm-none">${prod.name }</h3>
              <div class="col-12">
                <div id="pictureView" data-id="${prod.id }" style="width:510px; height:510px;border: 1px solid green; margin: 0 auto ;">
               		<img alt="prodImg"  src='getPicture.do?picture=${prod.picture }' style="width:500px; height:500px; text-align : center;">
                </div>
              </div>
              <button type="button" id="listBtn" class="btn btn-primary" onclick="CloseWindow();">닫기</button>
              <c:if test="${loginUser.authority eq '1' }">
              <button type="button" onclick="location.href='modifyForm.do?id=${prod.id}';" id="modifyBtn" class="btn btn-warning ">수 정</button>
   			  <button type="button" onclick="remove_confirm();" id="deleteBtn" class="btn btn-danger" >삭 제</button>
   			  </c:if>
            </div>
            <div class="col-12 col-sm-6">
              <h3 class="my-3">${prod.name }</h3>
              <p>${prod.outline}</p>

              <hr>


              <div class="bg-gray py-2 px-3 mt-4">
                <h2 class="mb-0">
                  ${prod.price} &nbsp 원
                </h2>
              </div>

              <div class="mt-4">
                <div class="btn btn-primary btn-lg btn-flat">
                	<input type="number" id="qty" min="1" value="1" />
                </div>
                
                <div class="btn btn-primary btn-lg btn-flat" onclick="cart_go('${prod.id}', '${prod.name }');">
                  <i class="fas fa-cart-plus fa-lg mr-2"></i>
                  Add to Cart
                </div>

                 	<br><br>
                <div>
                   <h3>남은 수량 : ${prod.qty }</h3>
                </div>
                                <br>
                <a href="https://www.google.co.kr/search?q=${prod.name}&source=lnms&tbm=isch" target="_blank" class="btn_basic"><i class="fab fa-google"></i>구글 이미지 검색 결과 보기</a>
	          <div class="row mt-4">
	            <nav class="w-100">
	              <div class="nav nav-tabs" id="product-tab" role="tablist">
	                <a class="nav-item nav-link" id="product-desc-tab" data-toggle="tab" href="#product-desc" role="tab" aria-controls="product-desc" aria-selected="false">Description</a>
	                <a class="nav-item nav-link" id="product-comments-tab" data-toggle="tab" href="#product-comments" role="tab" aria-controls="product-comments" aria-selected="false">리뷰</a>
	              </div>
	            </nav>
	            <div class="tab-content p-3" id="nav-tabContent">
	              <div class="tab-pane fade" id="product-desc" role="tabpanel" aria-labelledby="product-desc-tab"> ${prod.detail} </div>
	              <div class="tab-pane fade" id="product-comments" role="tabpanel" aria-labelledby="product-comments-tab"> 
	                  <!-- Reply content -->
					    <section class="content container-fluid">
					    	<!-- reply component start --> 
							<div class="row">
								<div class="col-md-12">
									<div class="card card-info">					
										<div class="card-body">
											<!-- The time line -->
											<div class="timeline">
												<!-- timeline time label -->
												<div class="time-label" id="repliesDiv">
													<span class="bg-green">Replies List </span>							
												</div>
												
											</div>
											<div class='text-center'>
												<ul id="pagination" class="pagination justify-content-center m-0">
					
												</ul>
											</div>
										</div>
										<div class="card-footer">
											<label for="newReplyWriter">Writer</label>
											<input class="form-control" type="hidden" placeholder="USER ID"	 id="newReplyWriter" readonly value="${loginUser.id }"> 
											<label for="newReplyText">Reply Text</label>
											<input class="form-control" type="text"	placeholder="REPLY TEXT" id="newReplyText">
											<br/>
											<button type="button" class="btn btn-primary" id="replyAddBtn" onclick="replyRegist_go();">ADD REPLY</button>
										</div>				
									</div>			
									
								</div><!-- end col-md-12 -->
							</div><!-- end row -->
					    </section>
	              
	              </div>
	            </div>
	          </div>

              </div>


            </div>
          </div>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->

    </section>		
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<script>
window.onload=function(){
// 	prodPictureThumb(document.querySelector('[data-id="${prod.id}"]'),'${prod.picture}');
}

function remove_confirm(){

var removeConfirm = confirm('정말 삭제하시겠습니까?');
	if (removeConfirm) {
		location.href = 'remove.do?id=${prod.id}';
	}
}
function stop_confirm(){

	var stopConfirm = confirm('정말 정지하시겠습니까?');
	if (stopConfirm) {
		location.href = 'disabled.do?id=${prod.id}';
	}
}

function cart_go(id, name){
	if(${empty loginUser}){
		alert("로그인이 필요합니다.");
		return;
	}
	if(!confirm("장바구니에 담으시겠습니까?")){
		return;
	}
   if($('#orderQty').val() > ${prod.qty}){
	      alert("상품 재고보다 많은 수량을 주문할 수 없습니다.");
	      return;
	}
	var data = {
			prodId : id
		  , prodName : name
		  , id : '${loginUser.id}'
		  , orderCost : ${prod.price}
		  , orderQty : $("#qty").val()
	      , picture : '${prod.picture}'
	}
	$.ajax({
		url : "/order/addCart.do"
	  , type : "post"
	  , data : JSON.stringify(data)
	  , contentType : "applicatin/json"
	  , success : function(data){
			if(confirm("장바구니에 담았습니다.\n장바구니로 이동하시겠습니까?")){
				window.opener.location.href = "/order/list.do?id=${loginUser.id}";
				window.close();
				return;
			}
			window.reload();
	  }
	})		
}
</script>
<!-- Modal -->
<div id="modifyModal" class="modal modal-default fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" style="display:none;"></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>        
      </div>
      <div class="modal-body" data-rno>
        <p><input type="text" id="replytext" class="form-control"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn" onclick="replyModify_go();">Modify</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn" onclick="replyRemove_go();">DELETE</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
 <%@ include file="./reply_js.jsp" %>
</body>
