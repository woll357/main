
	var no=0;
	var chk = false;
	var chk1=false;
	var chk2=false;
	var chk3=false;
	var chk4=false;
	var chk5=false;
	var chk6=false;
	var chk7=false;
	var chk8=false;
	
	var ididchk=false;
	var ppchk=false;
	var msg = "공란";
	$(document).ready(function(){
		 
		  
		  
		  
		  $('#idBtn').on({
		      'click':function(){
		    	  dataGet("../greenAjax/DupTest?id="+$('#id').val());
		      }
		   });
		  $('#phoneBtn').on({
		      'click':function(){
		    	  var ph=$('#phone1').val()+"-"+$('#phone2').val()+"-"+$('#phone3').val();
		    	  dataGet("../greenAjax/DupTest?phone="+ph);
		      }
		   });
		   
		   
		function dataGet(url){
			$.ajax(url,
	                {
	                   success:function(dd){
	                	   if(dd.trim()=="완료1" ){
	                		   alert("사용 가능합니다.");
	                		   $('#id').attr("readonly","readonly");
	                			ididchk=true;
	                	   }else if(dd.trim()=="완료2"){
	                		   alert("사용 가능합니다.");
	                		   $('#phone1').attr("readonly","readonly");
	                		   $('#phone2').attr("readonly","readonly");
	                		   $('#phone3').attr("readonly","readonly");
	                			ppchk=true;
	                	   }else{
	                		   alert(dd.trim());
	                	   }
	                	   
	                   },
	                   error:function(){
	                      alert("실패다 실패");
	                   },
	                }
	             );
		}
		
		
		$('#subBtn').on({
			'click':function(){
				
				if(chk && ididchk && ppchk){
					frm.submit();
				}else{
					chkPat();
					
					if(msg=="공란"){
						msg="정보를 모두 입력 부탁드립니다."
							alert(msg);
					}else if(!ididchk){
						msg="아이디 중복 확인 부탁드립니다."
							alert(msg);
					}else if(!ppchk){
						msg="연락처 중복 확인 부탁드립니다."
							alert(msg);
					}else{
						alert(msg);
					}
					
					
				}
			}
			
		})

		
	});
	
	function chkPat(){
		
		var numPat = /^\d*$/;
		var korPat = /^[가-힣]*$/;
		var spPat = /[+.!@#$%^&*-]/;
		var engPat = /^[A-Za-z]*$/;
		var emailPat = /(\w+)[.](\w+)$/
		var idPat =/^[0-9A-Za-z]*$/;
		
		
		
		var lastDay = ( new Date(eval($('#birth').val().slice(0,4))+1900, 
				eval($('#birth').val().slice(4,6))+2, 0)).getDate();
		var yychk = (new Date()).getYear();
		var mmchk = (new Date()).getMonth();
		var ddchk = (new Date()).getDate();
		
		var mchk = (mmchk+1)*100+ddchk;
		var bchk = $('#birth').val().substr(4,$('#birth').val().length);
		var ychk = 0;
		
		if($('#birth').val().length>3){
			ychk=(yychk+1900)-$('#birth').val().slice(0,4);
		}
		
		
		if(idPat.test($('#email1').val()) && emailPat.test($('#email2').val()) && $('#email1').val().length>0 && $('#email2').val().length>0){
			$('#emTag').html("정상입력");
			 chk5=true;

		}else{
			chk5=false;
			$('#emTag').html("");
			msg = "이메일 확인 부탁드립니다.";
		
			}
		if(!/[.!@#$%^&*A-Za-z]/.test($('#addDetail').val()) && $('#addDetail').val().length>0 && $('#addDetail').val()!="상세주소"){
			$('#addTag').html("정상입력");
			chk8=true;
		}else{
			chk8=false;
			msg = "주소 확인 부탁드립니다.";
			$('#addTag').html("");
		}
		if(numPat.test($('#birth').val()) && $('#birth').val().length >7
				&& eval($('#birth').val().slice(4,6))<13 && eval($('#birth').val().slice(4,6))>0
				&& eval($('#birth').val().slice(6,8))<=lastDay && eval($('#birth').val().slice(6,8))>0
				&& (ychk>19 ||(ychk==19 && (mchk-bchk)>-1))){
			
			
			$('#bbTag').html("정상입력");
			chk4=true;
		}else{
			chk4=false;
			msg = "주민번호 확인 부탁드립니다.";
			$('#bbTag').html("예) 19000101");
		}
		if(korPat.test($('#pname').val()) && $('#pname').val().length>0){
			$('#nameTag').html("정상입력");
			chk3=true;
		}else{
			chk3=false;
			msg = "이름 확인 부탁드립니다.";
			$('#nameTag').html("한글이름");
		}
		if(idPat.test($('#pw').val()) && $('#pw').val().length>7 && $('#pw').val().length<17){		
			$('#pwTag').html("정상입력");
			chk1=true;
		}else{
			chk1=false;
			msg = "PW 확인 부탁드립니다.";
			$('#pwTag').html("8 ~ 16자, 특수문자 제외");
			}
		if($('#pw').val()==$('#pw2').val() && $('#pw2').val().length>0){
			$('#pw2Tag').html("정상입력");
			chk2=true;
		}else{
			chk2=false;
			$('#pw2Tag').html("pw와 동일하게 입력");
			msg = "PW 확인 부탁드립니다.";
		
		}
		
		
		
		
		
		if(chk1 && chk2 && chk3 && chk4 && chk5 && chk6 && chk7 && chk8){
			chk=true;
		}else{
			chk=false;
		}
		
	}
	
	function butPat(){
		
		var numPat = /^\d*$/;
		var idPat =/^[0-9A-Za-z]*$/;
		
		
		if( (idPat.test($('#id').val()))
			&& $('#id').val().length>3 && $('#id').val().length<9){
			chk6=true;
			$('#idTag').html("정상입력");
			$('#idBtn').removeAttr("disabled");
			
		}else{
			msg = "id 확인 부탁드립니다.";
			chk6=false;
			$('#idTag').html("4~16자, 특수문자, 한글 제외");
			$('#idBtn').attr("disabled","disabled");

		}
		if(numPat.test($('#phone1').val()) && numPat.test($('#phone2').val()) 
				&& numPat.test($('#phone3').val()) && $('#phone1').val().length >2
				&& $('#phone2').val().length >2 && $('#phone3').val().length >3){
			chk7=true; 
			$('#ppTag').html("정상입력");
			$('#phoneBtn').removeAttr("disabled");
		}else{
			chk7=false;
			msg = "핸드폰 번호 확인 부탁드립니다.";
			$('#ppTag').html("");
			$('#phoneBtn').attr("disabled","disabled");

		}
		if(chk1 && chk2 && chk3 && chk4 && chk5 && chk6 && chk7 && chk8){
			chk=true;
		}else{
			chk=false;
		}
	}
	
	
