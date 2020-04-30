$(document).ready(function(){
	$("#insertCart").click(function(){//[장바구니에 담기]버튼 클릭
		var buyer = $("#buyer").val();
		var book_kind = $("#book_kind").val();
		var query = {book_id:$("#book_id").val(),
				     buy_count:$("#buy_count").val(),
				     book_image:$("#book_image").val(),
				     book_title:$("#book_title").val(),
				     buy_price:$("#buy_price").val(),
				     buyer:buyer};		
		$.ajax({
 		     type: "POST",
 		     url: "/shoppingmall/insertCart.do",
 		     data: query,
 		     success: function(data){
 		    	 alert("장바구니에 담겼습니다."); 
 		     }
 		});
	});
	
	$("#list").click(function(){//[목록으로]버튼 클릭
		window.location.href="/shoppingmall/list.do?book_kind=all";
	});
	
	$("#shopMain").click(function(){//[메인으로]버튼 클릭
		window.location.href="/shoppingmall/index.do";
	});
	
	$("#writeQna").click(function(){//[상품QnA쓰기]버튼 클릭
		var book_id = $("#book_id").val();
		var book_kind = $("#book_kind").val();
		
 		var query="/shoppingmall/qnaForm.do?book_id="+book_id;
 		query += "&book_kind="+book_kind;
 		window.location.href=query;
 		
	});
});

function edit(editBtn){//[수정]버튼 클릭
	var rStr = editBtn.name;
	var arr = rStr.split(",");
	var query = "/shoppingmall/qnaUpdateForm.do?qna_id="+arr[0];
	query += "&book_kind="+arr[1];
	window.location.href=query;
}

function del(delBtn){//[삭제]버튼 클릭
	var rStr = delBtn.name;
	var arr = rStr.split(",");
	
	var query = {qna_id: arr[0]};
    $.ajax({
       type: "POST",
       url: "/shoppingmall/qnaDeletePro.do",
       data: query,
       success: function(data){
    	   var str1 = '<p id="ck">';
 		   var loc = data.indexOf(str1);
 		   var len = str1.length;
 		   var check = data.substr(loc+len,1);
 		   if(check == "1"){//
 		  	  alert("QnA가 삭제 되었습니다.");
 		 	  var query = "/shoppingmall/bookContent.do?book_id="+arr[1];
 			  query += "&book_kind="+arr[2];
 			  window.location.href=query;
 	       }else//사용할 수 있는 아이디
 	  	      alert("QnA가 삭제 실패");
       }
    });
}