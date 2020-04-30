$(document).ready(function(){
    $("#replyPro").click(function(){//[답변하기]버튼 클릭
  		  var query = {qna_content:$("#rContent").val(),
  				       qna_writer:$("#qna_writer").val(),
  				       book_title:$("#book_title").val(),
  				       book_id:$("#book_id").val(),
  				       qna_id:$("#qna_id").val(),
  				       qora:$("#qora").val()};
  		  
  		  $.ajax({
  		     type: "POST",
  		     url: "/shoppingmall/mg/qnaReplyPro.do",
  		     data: query,
  		     success: function(data){
  		    	window.location.href="/shoppingmall/mg/qnaList.do";
  		     }
  		  });
	});
    
    $("#cancle").click(function(){//[취소]버튼 클릭
    	window.location.href="/shoppingmall/mg/managerMain.do";
	});
       
});
