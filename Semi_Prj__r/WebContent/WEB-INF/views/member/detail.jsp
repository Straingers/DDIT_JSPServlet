<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<title>회원상세보기</title>

<body>

  <!-- Content Wrapper. Contains page content -->
  <div >
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>마이페이지</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">회원관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	상세보기
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
    <!-- Main content -->
    <section class="content register-page">       
		<div class="register-box">         
	    	<form role="form" class="form-horizontal"  method="post">
	    		<div class="register-card-header" >
	    			<h1 class="text-center">내 정보 확인</h1>
	    		</div>
	        	<div class="register-card-body" >
	            	<div class="row"  style="height:200px;">
						<div class="mailbox-attachments clearfix col-md-12" style="text-align: center;">							
							<div id="pictureView" data-id="${member.id }" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>														
						</div>
					</div>
					<br />
	                <div class="form-group row" >
	                  <label for="inputEmail3" class="col-sm-3 control-label text-right">아이디</label>
	
	                  <div class="col-sm-9">
	                    <input name="id" type="text" class="form-control" id="id"  value="${member.id }" readonly>
	                  </div>
	                </div>
	                
	                	               
	                <div class="form-group row" >
	                  <label for="password" class="col-sm-3 control-label text-right">비밀번호</label>
	
	                  <div class="col-sm-9">
	                    <input name="pwd" type="password" class="form-control" id="pwd"  value="${member.pwd }" readonly>
	                  </div>
	                </div>
	                
	                	               
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">이  름</label>
	
	                  <div class="col-sm-9">
	                    <input name="userName" type="text" class="form-control" id="userName" value="${member.name }" readonly>
	                  </div>
	                </div>
	                
	                
	                 <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">이메일</label>
	
	                  <div class="col-sm-9">
	                    <input name="email" type="email" class="form-control" id="email" value="${member.email }" readonly>
	                  </div>
	                </div>
	                
	                
	                 <div class="form-group row">
	                  <label for="address" class="col-sm-3 control-label text-right">주소</label>

	                  <div class="col-sm-9">
	                    <input name="address" type="text" class="form-control" id="address" value="${member.address }" readonly>
	                  </div>
	                </div>
   
	              </div>  
		          <div class="card-footer" >
		          		<div class="row">
			          		<div class="col-sm-6 text-center">
			          			<button type="button" onclick="location.href='modifyForm.do?id=${member.id}';" id="modifyBtn" class="btn btn-warning ">정보 변경</button>
			          		</div>		          		
			          		<div class="col-sm-6 text-center">
			          			<button type="button" onclick="member_disabled();" id="deleteBtn" class="btn btn-danger">탈  퇴</button>
			          		</div>			          	
<!-- 			          		<div class="col-sm-4 text-center"> -->
<!-- 			            		<button type="button" id="listBtn" onclick="CloseWindow();" class="btn btn-primary pull-right">닫 기</button> -->
<!-- 			            	</div> -->
		          	    </div>  	
		          </div>
	      	  </form>
      	  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<script>
window.onload=function(){
	MemberPictureThumb(document.querySelector('[data-id="${member.id}"]'),'${member.picture}');
}

function member_disabled(){
	//alert('gd');
// 	if(confirm("정말로 탈퇴 진행을 하시겠습니까?");){
// 		location.href='remove.do?id=${member.id}';		
// 	}
	confirm("정말로 탈퇴 진행을 하시겠습니까?")
		location.href='remove.do?id=${member.id}';		
	
}
</script>  
  
</body>










