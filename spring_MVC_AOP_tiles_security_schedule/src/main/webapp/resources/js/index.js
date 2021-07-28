/**
 * 
 */
function subMenu(mCode) {
	if(mCode!="M000000") {
		$.getJSON("subMenu.do?mCode=" + mCode, function(data){	
//			console.log(data);		
			printData(data, $('.subMenuList'), $('#subMenu-list-template'), '.subMenu');
		});
	}else {
		$('.subMenuList').html("");	
	}
}

function printData(dataArr, target, templateObject, removeClass) {
	var template = Handlebars.compile(templateObject.html());
	
	var html = template(dataArr);
	
	$(removeClass).remove();
	target.append(html);
}

function goPage(url, mCode) {
	//HTML5 지원 브라우저에서 사용가능
	if(typeof(history.pushState) == 'function'){
		var renewURL = location.href;
		
		renewURL = renewURL.substring(0, renewURL.indexOf(".do") + 3);
		
		if(mCode != 'M000000'){
			renewURL += "?mCode=" + mCode;
		}
		// 페이지를 리로드하지 않고 페이지 주소면 변경할때 사용
		history.pushState(mCode, null, renewURL);
	} else {
		location.hash = "#" + mCode;
	}
	$('iframe[name="ifr"]').attr("src", url);
}
