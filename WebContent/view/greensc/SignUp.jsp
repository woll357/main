<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
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
		  $('#country').on({
		      'click':function(){
		         
		         var cc = $('#country').val();
		         if(cc=="한국" && cc !="일본"&& cc !="중국"&& cc !="필리핀"&& cc !="태국"){
		        	 $('#city').remove();
		        	 $('#addDetail').remove();
		        	 $('#address').append('<select name="city" id="city"></select>');
		        	 $('#city').append('<option value="서울">서울</option>');
		        	 $('#city').append('<option value="인천">인천</option>');
		        	 $('#address').append('<textarea name="addDetail" id="addDetail">상세주소</textarea>')
		        	 
		         }
		         if(cc!="한국" && cc =="일본"&& cc !="중국"&& cc !="필리핀"&& cc !="태국"){
		        	 $('#city').remove();
		        	 $('#addDetail').remove();
		        	 $('#address').append('<select name="city" id="city"></select>');
		        	 $('#city').append('<option value="도쿄">도쿄</option>');
		        	 $('#city').append('<option value="오사카">오사카</option>');
		        	 $('#address').append('<textarea name="addDetail" id="addDetail">상세주소</textarea>')
		         }
		         if(cc!="한국" && cc !="일본"&& cc =="중국"&& cc !="필리핀"&& cc !="태국"){
		        	 $('#city').remove();
		        	 $('#addDetail').remove();
		        	 $('#address').append('<select name="city" id="city"></select>');
		        	 $('#city').append('<option value="상해">상해</option>');
		        	 $('#city').append('<option value="베이징">베이징</option>');
		        	 $('#address').append('<textarea name="addDetail" id="addDetail">상세주소</textarea>')
		         }
		         if(cc!="한국" && cc !="일본"&& cc !="중국"&& cc =="필리핀"&& cc !="태국"){
		        	 $('#city').remove();
		        	 $('#addDetail').remove();
		        	 $('#address').append('<select name="city" id="city"></select>');
		        	 $('#city').append('<option value="마닐라">마닐라</option>');
		        	 $('#city').append('<option value="보라카이">보라카이</option>');
		        	 $('#address').append('<textarea name="addDetail" id="addDetail">상세주소</textarea>')
		         }
		         if(cc!="한국" && cc !="일본"&& cc !="중국"&& cc !="필리핀"&& cc =="태국"){
		        	 $('#city').remove();
		        	 $('#addDetail').remove();
		        	 $('#address').append('<select name="city" id="city"></select>');
		        	 $('#city').append('<option value="세부">세부</option>');
		        	 $('#city').append('<option value="푸켓">푸켓</option>');
		        	 $('#address').append('<textarea name="addDetail" id="addDetail">상세주소</textarea>')
		         }
		      }
		   });
		  
		  
		  
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
	                		   alert("ppp사용 가능합니다.");
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
		
		var numPat = /[0-9]/;
		var korPat = /^[가-힣]*$/;
		var spPat = /[.!@#$%^&*-]/;
		var engPat = /[A-z]/;
		var emailPat = /(\w+)[.](\w+)$/
		var idPat =/[0-9A-z]/;
		
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
		
		
		if(!spPat.test($('#email1').val()) && engPat.test($('#email1').val())
				&& emailPat.test($('#email2').val())){
			$('#emTag').html("정상입력");
			 chk5=true;

		}else{
			chk5=false;
			$('#emTag').html("");
			msg = "이메일 확인 부탁드립니다.";
		
			}
		if(!/[.!@#$%^&*A-z]/.test($('#addDetail').val()) && $('#addDetail').val().length>0 && $('#addDetail').val()!="상세주소"){
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
		if(!spPat.test($('#pw').val()) && $('#pw').val().length>7 && $('#pw').val().length<17){		
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
		}
		
	}
	
	function butPat(){
		
		var numPat = /[0-9]/;
		var idPat =/[0-9A-z]/;
		var spPat = /[.!@#$%^&*-]/;
		
		if(!spPat.test($('#id').val()) && (idPat.test($('#id').val()))
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
		
	}
	if(chk1 && chk2 && chk3 && chk4 && chk5 && chk6 && chk7 && chk8){
		chk=true;
	}
	
	</script>
	

<form action="SignUpReg" method="post" name="frm">
	<table border="">
		<tr>
			<td align="center" width="100">id</td>
			<td>
			<input name="id" type="text" id="id" maxlength="8"  onkeyup="butPat()"/>
			<div id="idTag">4~16자, 특수문자, 한글 제외</div>
			</td><td>
			<input type="button" value="중복확인" class="btn" id="idBtn" disabled="disabled"/>
			</td>
		</tr>
		<tr>
			<td align="center">pw</td>
			<td colspan="2"><input name="pw" type="password" maxlength="16" id="pw" onkeyup="chkPat()"/>
			<div id="pwTag">8 ~ 16자, 특수문자 제외</div>		
			</td>
		</tr>
		<tr>
			<td align="center">pw 확인</td>
			<td colspan="2"><input name="pw2" type="password" maxlength="16" id="pw2" onkeyup="chkPat()"/>
			<div id="pw2Tag">pw와 동일하게 입력</div>
			</td>
			
		</tr>
		<tr>
			<td align="center">이름</td>
			<td colspan="2"><input name="pname" type="text" id="pname" onkeyup="chkPat()"/>
			<div id="nameTag">한글이름</div>
			</td>
		</tr>
		<tr>
			<td align="center">연락처</td>
			<td>
			<input name="phone" type="text" id="phone1"  maxlength="3" onkeyup="butPat()" style="width: 50px"/> -
			<input name="phone" type="text" id="phone2"  maxlength="4" onkeyup="butPat()" style="width: 50px"/> -
			<input name="phone" type="text" id="phone3" maxlength="4" onkeyup="butPat()" style="width: 50px"/>
			<div id="ppTag"></div>
			</td><td>
			<input type="button" value="중복확인" class="btn" id="phoneBtn" disabled="disabled"/>
			</td>
		</tr>
		<tr>
			<td align="center">생년월일</td>
			<td colspan="2"><input name="birth" type="text" maxlength="8" id="birth" onkeyup="chkPat()"/>
			<div id="bbTag">예) 19000101</div>
			</td>
			
		</tr>
		<tr>
			<td align="center">성별</td>
			<td colspan="2">
			<input type="radio" name=gender value="1" checked="checked"/>남자
			<input type="radio" name=gender value="2"/>여자
			
			<div id="ggTag"></div>
			</td>
			
		</tr>

		<tr>
			<td align="center">주소</td>
			<td id="address" colspan="2">
			<select name="country" id="country">
					<option value="한국">한국</option>
					<option value="일본">일본</option>
					<option value="태국">태국</option>
					<option value="중국">중국</option>
					<option value="필리핀">필리핀</option>
			</select> <select name="city" id="city">
					<option value="서울">서울</option>
					<option value="인천">인천</option>

			</select> <input type="text" name="addDetail" id="addDetail" value="상세주소" onkeyup="chkPat()"/>
			<div id="addTag"></div>
			</td>

		</tr>

		<tr>
			<td align="center">Email</td>
			<td colspan="2">
			<input type="text" name="email" id="email1" onkeyup="chkPat()"/>@
			<input type="text" name="email" id="email2" onkeyup="chkPat()"/>
			<div id="emTag"></div>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center"><input type="button" value="가입" id="subBtn"/>
				<input type="reset" value="초기화" /></td>
		</tr>
	</table>
</form>