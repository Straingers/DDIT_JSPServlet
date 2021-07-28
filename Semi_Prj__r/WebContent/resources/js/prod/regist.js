var formData = "";

function picture_go(){
	formData = new FormData($('form[role="imageForm"]')[0]);
	var form = $('form[role="imageForm"]');
	var picture = form.find('[name="pictureFile"]')[0];

	form.find('[name="checkUpload"]').val(0);
	var fileFormat= 
		picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();
	
	console.log(form);
	console.log(picture);
	console.log(fileFormat);
	
	if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
		alert("이미지는 jpg/jpeg 형식만 가능합니다.");
		picture.val="";
		return;
	}
	
	if(picture.files[0].size>1024*1024*1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
		return;
	}
	
	document.getElementById('inputFileName').value=picture.files[0].name;
	
	if(picture.files && picture.files[0]){
		var reader = new FileReader();
		reader.onload = function (e) {
			$('div#pictureView')
				.css({'background-image' : 'url('+e.target.result+')',
					  'background-position' : 'center',
					  'background-size' : 'contain',
					  'background-repeat' : 'no-repeat'
				});
		}
		reader.readAsDataURL(picture.files[0]);
	}
}

function upload_go(){
	if($('input[name="pictureFile"]').val()==""){
		alert("사진을 선택하세요");
		$('input[name="pictureFile"]').cilck();
		return;
	};
	
	if($('input[name="checkUpload"]') == 1){
		alert("이미 업로드된 사진입니다.");
		return;
	}
	
	$.ajax({
		url : "/prod/picture.do",
		data:formData,
		type:'post',
		processData:false,
		contentType:false,
		success:function(data){
			$('input[name="checkUpload"]').val(1);
			
			$('input#oldFile').val(data); 
			$('form[role="form"] input[name="picture"]').val(data);
			
			alert("사진이 업로드 되었습니다.");
		},
		error:function(error){
			alert("현재 사진 업로드가 불가합니다.\n 관리자에게 문의 바랍니다.");
		}
	});
}

//__________________________________________________________________________
var checkedId="";

function idCheck_go(){
	var input_Id = $('input[name="id"]');
	
	if(input_Id.val()==""){
		alert("상품 코드를 입력하세요");
		input_Id.focus();
		return;
	}
///////////////////////////////////////////////////////////	
	$.ajax({
		url : "/prod/idCheck.do?id="+input_Id.val(),
		method : "get",
		success : function(result){
			console.log(result);
			if(result == "duplicated"){
				alert("중복된 상품코드 입니다.");
				$('input[name="id"]').focus();
			}else{
				alert("사용가능한 상품코드입니다.");
				checkedId=input_Id.val().trim();
				$('input[name="id"]').val(input_Id.val().trim());
			}
		},
		error : function(error){
			alert("시스템 장애로 가입이 불가능합니다.");
		}
	});
}


function regist_go(){
	var uploadCheck = $('input[name="picture"]').val();
	if(!uploadCheck){
		alert("사진 업로드는 필수입니다.");
		return;
	}
	if($('input[name="id"]').val() == ""){
		alert("상품코드는 필수입니다.");
		return;
	}
	if($('input[name="id"]').val() != checkedId){
		alert("상품코드 중복확인이 필요합니다.");
		return;
	}
//	if($('input[name="name"]').val() == ""){
//		alert("패스워드는 필수입니다.");
//		return;
//	}
//	if($('input[name="outline"]').val() == ""){
//		alert("이름은 필수입니다.");
//		return;
//	}
	var form = $('form[role="form"]');
	
	form.submit();
}
