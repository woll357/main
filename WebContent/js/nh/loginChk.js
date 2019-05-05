
$(document).ready(function(){
	
	$('#btn').on({
		'click':function(){
			var idPat =/^[0-9A-Za-z]*$/;
			
			if(!idPat.test($('#pw').val()) || !idPat.test($('#id').val())){
				alert('아이디와 비밀번호 형식을 확인해주세요');
			}else{
				frm.submit();
			}
		}
	})
	
	
})
