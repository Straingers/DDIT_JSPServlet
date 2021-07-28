<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

   
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>수정하기</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>상품사항
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	수정하기
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
  <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-info">
					<div class="card-header row">
						<h4 class="col-md-8">상품 수정</h4>
						<div class="col-md-4">
							<div class="float-right">
								<button type="button" class="btn btn-warning" id="modifyBtn" onclick="modify_go();">수 정</button>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn btn-default " id="cancelBtn" onclick="history.go(-1);">취 소</button>
							</div>
						</div>
					</div><!--end card-header  -->
					<div class="card-body">
						<form role="form" method="post" action="modify.do" name="modifyForm" enctype="multipart/form-data">
							<div class="row">					
								<input type="hidden" name="oldPicture" value="${prod.picture }" />
								<input type="file" id="inputFile" onchange="changePicture_go()" name="picture" style="display:none" />
								<div class="input-group col-md-12">
									<div class="col-md-12" style="text-align: center;">
										<div class="" data-id="${prod.id }" id="pictureView" style="border: 1px solid blue; height: 500px; width: 500px; margin: 0 auto; margin-bottom:5px;"></div>														
										<div class="input-group input-group-sm">
											<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">사진변경</label>
											<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled
												value="${prod.picture.split('\\$\\$')[1] }"/>
											<input id="picture" class="form-control" type="hidden" name="uploadPicture" />
										</div>						
									</div>												
								</div>
							</div>	
							<input type="text" name="id" value="${prod.id }" />
							<input type="number" name="price" value="${prod.price }" />
							<input type="text" name="category" value="${prod.category }" />
							<input type="number" name="qty" value="${prod.qty }" />
							<div class="form-group">
								<label for="name">상품명</label> 
								<input type="text" id="name" name='name' class="form-control" value="${prod.name }">
							</div>
							<div class="form-group">
								<label for="outline">요약</label> 
								<input type="text" id="outline" name='outline' class="form-control" value="${prod.outline }">
							</div>
							<div class="form-group">
								<label for="detail">상세</label> 
								<input type="text" id="detail" name='detail' class="form-control" value="${prod.detail }">
							</div>
						</form>
					</div><!--end card-body  -->
					
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    <!-- /.content -->
    
<script>
    	
window.onload = function(){
	prodPictureThumb($('#pictureView')[0],'${prod.picture}');
}

function changePicture_go(){
	var picture =  $('input#inputFile')[0];
	var fileFormat = picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();
	
	if(!(fileFormat == "JPG" || fileFormat == "JPEG")){
		alert("이미지는 jpg/jpeg 형식만 가능합니다.");
		return;
	}
	if(picture.files[0].size > 1024*1024*1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
		return;
	};
	
	document.getElementById('inputFileName').value=picture.files[0].name;
	
	if(picture.files && picture.files[0]){
		var reader = new FileReader();
		
		reader.onload = function (e) {
			$('div#pictureView')
			.css({'background-image'    : 'url('+ e.target.result + ')',
				  'background-position' : 'center',
				  'background-size'     : 'cover',
				  'background-repeat'   : 'no-repeat'
			});
		}
		reader.readAsDataURL(picture.files[0]);
	}
	$('input[name="uploadPicture"]').val(picture.files[0].name);
}

function modify_go(){
	var form = $('form[role="form"]');
	form.submit();
}

function prodPictureThumb(targetObj, fileName){ 
	
	targetObj.style.backgroundImage="url('getPicture.do?picture="+fileName+"')";
	targetObj.style.backgroundPosition="center";
	targetObj.style.backgroundRepeat="no-repeat";
	targetObj.style.backgroundSize="cover";
}
</script>
    
<script src="/resources/js/prod/regist.js" ></script>
    
    
    
    
    
    
    
    
    
    
    
    