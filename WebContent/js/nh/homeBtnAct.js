$(document).ready(function(){
	
	 $('#awp').on({
		 'click' : function(){
			 $('.dd').css({
				 'visibility': 'hidden'
			 })
			 $('#awp').css({
				 'background-color': '#dcefef'
			 })
			 $('#rtp').css({
				 'background-color': 'white'
			 })

		 }
	 })
	 $('#rtp').on({
		 'click' : function(){
			 $('.dd').css({
				 'visibility': 'visible'
			 })
			 $('#rtp').css({
				 'background-color': '#dcefef'
			 })
			 $('#awp').css({
				 'background-color': 'white'
			 })

		 }
	 })
	 
	 
	 
	$('.start').on({
		'click':function(){
			$('#startCity').val(($(this).attr('id')));
		}
	})
	$('.arrive').on({
		'click':function(){
			$('#arriveCity').val(($(this).attr('id')));
		}
	})
	$('.hotdd').on({
		'click':function(){
			$('#hotDir').val(($(this).attr('id')));
		}
	})
	
	$('#ssdate1').on({
		'click':function(){
			var cal = new Date();
			var yy = cal.getYear()+1900;
			var mm = cal.getMonth();
			var id=$(this).attr("id");
			calendar(yy,mm, id);
			$('.ssdate2').val("");
			
		}
	})
	$('#ssdate2').on({
		'click':function(){
			
			if($('.ssdate1').val()!="" && $('.ssdate1').val()!=null){
			var cal = new Date();
			var yy = cal.getYear()+1900;
			var mm = cal.getMonth();
			var id=$(this).attr("id");
			calendar(yy,mm, id);
			}else{
				alert("출발 날짜를 선택해 주세요.");
			}
			
			
		}
	})
	
	$('#startDay').on({
		'click':function(){
			var cal = new Date();
			var yy = cal.getYear()+1900;
			var mm = cal.getMonth();
			var id=$(this).attr("id");
			calendar(yy,mm, id);
			$('.endDay').val("");
			
		}
	})
	$('#endDay').on({
		'click':function(){
			
			if($('.startDay').val()!=null && $('.startDay').val()!=""){
			var cal = new Date();
			var yy = cal.getYear()+1900;
			var mm = cal.getMonth();
			var id=$(this).attr("id");
			calendar(yy,mm, id);
			}else{
				alert("체크인 날짜를 선택해 주세요");
			}
			
		}
	})
	
	
	
	
	
	$('#hott').on({
		'click':function(){
			if(($('.startDay').val()=="" ||  $('.endDay').val()==""
					||$('#pcnt').val()<1 || $('#pcnt').val()=="")){
				alert("정보를 모두 선택해 주세요");
			}else{
				hotFrm.submit();
			}
		}
	})
	
	 
 })
 
 
