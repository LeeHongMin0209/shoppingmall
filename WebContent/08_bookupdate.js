$(document).ready(function(){
	$("#upForm1").ajaxForm({//[책수정]버튼 클릭
		success: function(data, status){//업로드에 성공하면 수행
   			window.location.href="/shoppingmall/mg/bookList.do?book_kind=all";
   		}
    });
	
	$("#bookMain").click(function(){//[관리자 메인으로]버튼 클릭
		window.location.href="/shoppingmall/mg/managerMain.do";
	});
	
	$("#bookList").click(function(){//[목록으로]버튼 클릭
		window.location.href="/shoppingmall/mg/bookList.do?book_kind=all";
	});
});