	function maxLengthCheck(object) {
		if (object.value.length > object.maxLength) {
			object.value = object.value.slice(0, object.maxLength);
		}
	}
	
	$(document).ready(function(){
		$('.nores').on({
			'click':function() {
				if($('#rs').val()=='' || $('#norescnt').val()=='' || $('#noresdate').val()=='') {
					alert("기입이 완료되지않았습니다.")
					nono.button();
				}
				if(eval($('#norescnt').val())<0 || eval($('#hiddenrcnt').val())<eval($('#norescnt').val())) {
					alert("값이 잘못 입력되었습니다.")
				}
				else {
					nono.submit();
				}
			}
		});
	});
	