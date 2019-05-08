$(document).ready(function(){
	
	
	$('.planego').on({
		'click':function(){
			
			if($('.ap').val()==''){
				alert("기입이완료되지않았습니다.")
			}else{
				airinre.submit();
			}
		}
	})
});