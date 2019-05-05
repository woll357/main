
$(document).ready(function(){
	
	$('#btn1').on({
		'click':function(){
			var idPat =/^[0-9A-Za-z]*$/;
			var numPat=/^[0-9]*$/;
			
			if(numPat.test($('#phone1').val()) && numPat.test($('#phone2').val()) && 
					numPat.test($('#phone3').val()) && idPat.test($('#id').val())
				&& $('#id').val().length>2 	&& $('#phone1').val().length>2	&& $('#phone2').val().length>0
				&& $('#phone3').val().length>3
			){
				frm1.submit();
			}else{
				alert('입력 형식을 확인해주세요');
			}
		}
	})
	$('#btn2').on({
		'click':function(){
			var idPat =/^[0-9A-Za-z]*$/;
			var numPat=/^[0-9]*$/;
			
			if(numPat.test($('#phone11').val()) && numPat.test($('#phone22').val()) && 
					numPat.test($('#phone33').val()) && $('#phone11').val().length>2 && $('#phone22').val().length>0
				&& $('#phone33').val().length>3
			){
				frm2.submit();
			}else{
				alert('입력 형식을 확인해주세요');
			}
		}
	})
	
})
