var crnPat = /^\d{4}-\d{2}-\d{2}$/;

$(document).ready(function(){
	
	$('.aa').on({
		'click':function() {
		
			console.log(crnPat.test($('.ddate').val()))
			
			if(crnPat.test($('.ddate').val())) {
				
				cc.submit();
			
			}else{
				alert("형식이 잘못되었습니다.");
           		 }
       		 }
			
		
	})

});