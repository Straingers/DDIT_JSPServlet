<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

	 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상품등록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>상품사항
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	등록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
  <!-- Main content -->
    <section class="content container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-9" style="max-width:960px;">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title p-1">상품등록</h3>
						<div class ="card-tools">
							<button type="button" class="btn btn-primary" id="registBtn" onclick="regist_go();">등 록</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-warning" id="cancelBtn" onclick="CloseWindow();" >취 소</button>
						</div>
					</div><!--end card-header  -->
					<div class="card-body pad">
						<form role="form" method="post" action="regist.do" name="registForm">
						<input type="hidden" name="picture" />
							<div class="mailbox-attachments clearfix" style="text-align: center;">
								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
								<div class="mailbox-attachment-info">
									<div class="input-group input-group-sm">
										<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
										<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled/>
										<span class="input-group-append-sm">											
											<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>											
										</span>
									</div>
								</div>
							</div>						
							<div class="form-group">
								<label for="id">상품코드</label> 
									<div class="input-group input-group-sm">
										<input type="text" id="id"	name='id' class="form-control" placeholder="상품코드를 쓰세요">
										<span class="input-group-append-sm">	
											<button type="button" onclick="idCheck_go();"  class="btn btn-info btn-sm btn-append">중복확인</button>
										</span>	
									</div>
							</div>							
							<div class="form-group">
								<label for="name">상품명</label> 
								<input type="text" id="name"
									name='name' class="form-control" placeholder="상품명을 쓰세요">
							</div>							
							<div class="form-group">
								<label for="qty">상품수량</label> 
								<input type="number" id="qty" value=0;
									name='qty' class="form-control" placeholder="상품 수량을 쓰세요">
							</div>							
							<div class="form-group">
								<label for="outline">상품 요약</label> 
								<input type="text" id="outline" 
									name="outline" class="form-control" placeholder="상품 요약을 쓰세요">
							</div>
							<div class="form-group">
								<label for="price">상품 가격</label> 
								<input type="number" id="price" 
									name="price" class="form-control" placeholder="상품 가격을 쓰세요">
							</div>
							<div class="form-group">
								<label for="category">상품 카테고리</label> 
								<input type="text" id="category" 
									name="category" class="form-control" placeholder="카테고리를 쓰세요">
							</div>
							<div class="form-group">
								<label for="detail">상품 상세</label>
								<input type="text" name="detail" id="detail"  class="form-control"
									placeholder="500자 내외로 작성하세요." />
							</div>
						</form>
					</div><!--end card-body  -->
					<div class="card-footer" style="display:none">
					
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    <!-- /.content -->
<form role="imageForm" action="upload/picture.do" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" onchange="picture_go();"
			style="display:none;">
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
</form>


<script src="/resources/js/common.js" ></script>
<script src="/resources/js/prod/regist.js" ></script>
    

<%@ include file="/WEB-INF/views/common/summernote.jsp" %>




    
    
    
    