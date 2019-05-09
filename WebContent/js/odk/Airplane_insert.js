
var regType1 = /^[a-z][a-z0-9+]{3,5}$/; 


$(document).ready(function(){
	
	
	$('.planego').on({
		'click':function(){
			
			if($('.ap').val()==''){
				alert("기입이완료되지않았습니다.")
			}else if(!regType1.test($('.ap').val())){
				alert('비행기코드 형식이 잘못되었습니다.')
			}
			else{
				airinre.submit();
			}
		}
	})
	
	
	
	
	
	
	
	
	
	
});