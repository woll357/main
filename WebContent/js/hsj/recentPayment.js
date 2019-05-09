
	$('#pw').focusout(function(){
		if(pwPat.test($(this).val())){
			chk6=true;
		}
		else{
			chk6=false;
			 alert("유효하지 않은 pw 입니다.");
		}
	})
