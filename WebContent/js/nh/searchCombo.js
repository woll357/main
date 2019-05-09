$(document).ready(function(){
	
	
	$('#plane').on({
		'click':function(){
			if(( $('.ssdate1').val()=="" ||  $('.ssdate2').val()==""
					||$('#seatcnt').val()<1 || $('#seatcnt').val()=="")&& $('.dd').css("visibility")=="visible"){
				alert("정보를 모두 선택해 주세요");
			}else if(( $('.ssdate1').val()=="" ||$('#seatcnt').val()<1 
					|| $('#seatcnt').val()=="")&& $('.dd').css("visibility")=="hidden"){
				alert("정보를 모두 선택해 주세요");
			}else if($('#darea').val()!='인천' && $('#carea').val()!='인천' ){
				alert("출발, 혹은 도착지 한 곳은 인천이어야 합니다.");
			}else if($('#darea').val()=='상해' || $('#darea').val()=='베이징'){
				if($('#carea').val()=='상해' || $('#carea').val()=='베이징'){
					alert("동일 국가는 선택 불가합니다.");
				}else if($('#darea').val()!='인천' && $('#carea').val()!='인천' ){
					alert("출발, 혹은 도착지 한 곳은 인천이어야 합니다.");
				}else{
					airFrm.submit();
				}
				
			}else if($('#darea').val()=='도쿄' || $('#darea').val()=='오사카'){
				if($('#carea').val()=='오사카' || $('#carea').val()=='도쿄'){
					alert("동일 국가는 선택 불가합니다.");
				}else if($('#darea').val()!='인천' && $('#carea').val()!='인천' ){
					alert("출발, 혹은 도착지 한 곳은 인천이어야 합니다.");
				}else{
					airFrm.submit();
				}
				
			}else if($('#darea').val()=='마닐라' || $('#darea').val()=='보라카이'){
				if($('#carea').val()=='마닐라' || $('#carea').val()=='보라카이'){
					alert("동일 국가는 선택 불가합니다.");
				}else if($('#darea').val()!='인천' && $('#carea').val()!='인천' ){
					alert("출발, 혹은 도착지 한 곳은 인천이어야 합니다.");
				}else{
					airFrm.submit();
				}
				
			}else if($('#darea').val()=='세부' || $('#darea').val()=='푸켓'){
				if($('#carea').val()=='세부' || $('#carea').val()=='푸켓'){
					alert("동일 국가는 선택 불가합니다.");
				}else if($('#darea').val()!='인천' && $('#carea').val()!='인천' ){
					alert("출발, 혹은 도착지 한 곳은 인천이어야 합니다.");
				}else{
					airFrm.submit();
				}
				
			}else if($('#darea').val()=='인천'){
				if($('#carea').val()=='인천'){
					alert("동일 국가는 선택 불가합니다.");
				}else if($('#darea').val()!='인천' && $('#carea').val()!='인천' ){
					alert("출발, 혹은 도착지 한 곳은 인천이어야 합니다.");
				}else{
					airFrm.submit();
				}
			}
		}
	})
	
	
	
	
	
})