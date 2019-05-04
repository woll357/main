
	var no=0;
	var chk = false;
	var chk1=false;
	var chk2=false;
	var chk3=false;
	var chk4=false;
	var chk5=false;
	
	var ppchk=false;
	var msg = "공란";
	$(document).ready(function(){
		  
		  
		  $('#blackBtn').on({
				'click':function(){
					
					
					if($('#black').val()!=null && $('#black').val()!=""){
						$('#black').val("");
					}else{
						$('#black').val("블랙리스트");
					}
				}
			})
		  
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
				
				if("${dto.phone1}"==$('#phone1').val() && "${dto.phone2}"==$('#phone2').val() && "${dto.phone3}"==$('#phone3').val()){
					ppchk=true;
				}
				
				if(chk && ppchk){
					frm.submit();
				}else{
					chkPat();
					
					if(msg=="공란"){
						msg="정보를 모두 입력 부탁드립니다."
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
		
	
		
		if(idPat.test($('#email1').val()) && emailPat.test($('#email2').val()) && $('#email1').val().length>0 && $('#email2').val().length>0){
		
			 chk2=true;

		}else{
			chk2=false;
			$('#emTag').html("");
			msg = "이메일 확인 부탁드립니다.";
		
			}
		if(!/[.!@#$%^&*A-Za-z]/.test($('#addDetail').val()) && $('#addDetail').val().length>0 && $('#addDetail').val()!="상세주소"){
			
			chk3=true;
		}else{
			chk3=false;
			msg = "주소 확인 부탁드립니다.";
			$('#addTag').html("");
		}
		
		
		if(idPat.test($('#pw').val()) && $('#pw').val().length>7 && $('#pw').val().length<17){		
			$('#pwTag').html("정상입력");
			chk4=true;
		}else{
			chk4=false;
			msg = "PW 확인 부탁드립니다.";
			$('#pwTag').html("8 ~ 16자, 특수문자, 한글 제외");
			}
		
		if($('#pw').val()==$('#pw2').val() && $('#pw2').val().length>0){
			$('#pw2Tag').html("정상입력");
			chk5=true;
		}else{
			chk5=false;
			$('#pw2Tag').html("pw와 동일하게 입력");
			msg = "PW 확인 부탁드립니다.";
		
		}
		
		
		
		if("${dto.phone1}"==$('#phone1').val() && "${dto.phone2}"==$('#phone2').val() && "${dto.phone3}"==$('#phone3').val()){
			chk1=true;
		}
		
		if(chk1 && chk2 && chk3 && chk4 && chk5){
			chk=true;
		}else{
			chk=false;
		}
		}
	
	function butPat(){
		
		var numPat = /^\d*$/;
		var idPat =/^[0-9A-Za-z]*$/;
		
		
		
		
		if(numPat.test($('#phone1').val()) && numPat.test($('#phone2').val()) 
				&& numPat.test($('#phone3').val()) && $('#phone1').val().length >2
				&& $('#phone2').val().length >2 && $('#phone3').val().length >3){
			chk1=true; 
			$('#ppTag').html("정상입력");
			$('#phoneBtn').removeAttr("disabled");
		}else{
			chk1=false;
			msg = "핸드폰 번호 확인 부탁드립니다.";
			$('#ppTag').html("");
			$('#phoneBtn').attr("disabled","disabled");

		}
		if(chk1 && chk2 && chk3 && chk4 && chk5){
			chk=true;
		}else{
			chk=false;
		}
	}
	
