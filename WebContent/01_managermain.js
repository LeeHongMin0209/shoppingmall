
$(document).ready(function(){
	$("#registProduct").click(function(){//[상품등록]버튼 클릭
		window.location.href="/shoppingmall/bookRegister.do";

	});
	
	$("#updateProduct").click(function(){//[상품수정/삭제]버튼 클릭
		window.location.href="/shoppingmall/bookList.do?book_kind=all";
			 
	});
	
	$("#orderedProduct").click(function(){//[전체구매목록 확인]버튼 클릭
		
		window.location.href="/shoppingmall/orderList.do";
		
	});
	
	$("#qna").click(function(){//[상품 QnA답변]버튼 클릭
		
		window.location.href="/shoppingmall/qnaList.do";
	});
});