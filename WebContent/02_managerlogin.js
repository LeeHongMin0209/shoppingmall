$(document).ready(function(){
	//[로그인]버튼을 클릭하면 자동실행	
	$("#login").click(function(){
		var query = {id : $("#id").val(), 
				     passwd:$("#passwd").val()};
		  
		$.ajax({
		   type: "POST",
		   url: "/shoppingmall/managerLoginPro.do",
		   data: query,
		   success: function(data){
			  
			   window.location.href="/shoppingmall/managerMain.do";	
		   
		   }
		});
		//location.reload();
	});
	
	//[로그아웃]버튼을 클릭하면 자동실행
	$("#logout").click(function(){
		$.ajax({
		   type: "POST",
		   url: "/shoppingmall/managerLogout.do",
		   success: function(data){
			  
			   window.location.href="/shoppingmall/managerMain.do";
				
		   }
		});
		//location.reload();
	});
	
 });


