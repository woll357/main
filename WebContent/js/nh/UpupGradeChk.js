$(document).ready(function(){
	
	 
	   $('#grade').on({
	      'click':function(){
	    	  dataGet("../greenAjax/Upup?grade="+$('#grade').val());
	      }
	   });
	   
	   
	function dataGet(url){
		$.ajax(url,
                {
                   success:function(dd){	                       
                	   $("#contents").html(dd);
                      
                   },
                   error:function(){
                      alert("실패다 실패");
                   },
                }
             );
	}
	
	
})