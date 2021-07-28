/**
 * 
 */
window.onload = function(){
	MemberPictureThumb(document.getElementById("pictureView"), '${member.picture}');
}

function changePicture_go(){
	var picture = $('input#inputFile')[0];
	
	var fileFormat = picture.value.substr(picture.value.lastIndexOf(".") + 1).toUpperCase();
	
	// 이미지 확장자 jpg 확인
	if(!(fileFormat == "JPG" || fileFormat == "JPEG")) {
		alert("이미지는 jpg/jpeg 형식만 가능합니다.");
		return;
	}
	
	// 이미지 파일 용량 체크
	if(picture.files[0].size > 1024 * 1024 * 1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
		return;
	}
	
	// 파일명 삽입
	document.getElementById('inputFileName').value = picture.files[0].name;
	
	// 섬네일
	if(picture.files && picture.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('div#pictureView').css({
				'background-image' : 'url(' + e.target.result + ')'
				, 'background-position' : 'center'
				, 'background-size' : 'cover'
				, 'background-repeat' : 'no-repeat'
			});
		}
		reader.readAsDataURL(picture.files[0]);
	}
	
	// 이미지 변경 확인
	$('input[name="uploadPicture"]').val(picture.files[0].name);
}

// 회원 수정 submit
function modify_go(){
	var form = $('form[role="form"]');
	form.submit();
}