var chk1=false;
var chk2=false;
var chk3=false;
var msg="공란 확인";

$(document).ready(function(){
	
	 
	   $('#btn1').on({
	      'click':function(){
	    	  if(chk1){
	    	  dataGet("../greenAjax/Find?id="+$('#id').val()+"&black="+"black");
	    	  $('#id').val("");
	    	  $('#phone').val("");
	    	  $('#name').val("");
	    	  }else{
	    		  alert(msg);
	    	  }
	      }
	   });
	   $('#btn2').on({
		      'click':function(){
		    	  if(chk2){
		    	  dataGet("../greenAjax/Find?pname="+$('#name').val()+"&black="+"black");
		    	  $('#id').val("");
		    	  $('#phone').val("");
		    	  $('#name').val("");
		    	  }else{
		    		  alert(msg);
		    	  }
		      }
		   });
	   $('#btn3').on({
		      'click':function(){
		    	  if(chk3){
		    	  dataGet("../greenAjax/Find?phone="+$('#phone').val()+"&black="+"black");
		    	  $('#id').val("");
		    	  $('#phone').val("");
		    	  $('#name').val("");
		    	  }else{
		    		  alert(msg);
		    	  }
		      }
		   });
	   $('#btn4').on({
		      'click':function(){
		    	  console.log($('#preason').val());
		    	  dataGet("../greenAjax/Find?preason="+$('#preason').val()+"&black="+"black");
		    	  $('#id').val("");
		    	  $('#phone').val("");
		    	  $('#name').val("");
		    	  
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


		function chkPat1(){
		
		var numPat = /^\d*$/;
		var korPat = /^[가-힣]*$/;
		var spPat = /[+.!@#$%^&*-]/;
		var engPat = /^[A-Za-z]*$/;
		var emailPat = /(\w+)[.](\w+)$/
		var idPat =/^[0-9A-Za-z]*$/;
		
		
		if(idPat.test($('#id').val()) && $('#id').val().length>3){
			
			
			chk1=true;
		}else{
			chk1=false;
			msg = "id 확인 부탁드립니다.";
			
		}
		
	}

function chkPat2(){
	
	var numPat = /^\d*$/;
	var korPat = /^[가-힣]*$/;
	var spPat = /[+.!@#$%^&*-]/;
	var engPat = /^[A-Za-z]*$/;
	var emailPat = /(\w+)[.](\w+)$/
	var idPat =/^[0-9A-Za-z]*$/;
	
		
	if(korPat.test($('#name').val()) && $('#name').val().length>0){
		
		chk2=true;
	}else{
		chk2=false;
		msg = "이름 확인 부탁드립니다.";
		
	}
	
}

function chkPat3(){
	
	var numPat = /^\d*$/;
	var korPat = /^[가-힣]*$/;
	var spPat = /[+.!@#$%^&*-]/;
	var engPat = /^[A-Za-z]*$/;
	var emailPat = /(\w+)[.](\w+)$/
	var idPat =/^[0-9A-Za-z]*$/;
	
	if(numPat.test($('#phone').val()) && $('#phone').val().length>3){	
		chk3=true;
	}else{
		chk3=false;
		msg = "연락처 확인 부탁드립니다.";
		
	}
	
}