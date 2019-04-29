<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	var no=0;
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
		  
		  
		  
		  $('.btn').on({
		      'click':function(){
		    	  dataGet("../greenAjax/DupTest?id="+$('#id').val()+"&phone="+$('#phone').val());
		      }
		   });
		   
		   
		function dataGet(url){
			$.ajax(url,
	                {
	                   success:function(dd){	                       
	                	   alert("성공성공");
	                      
	                   },
	                   error:function(){
	                      alert("실패다 실패");
	                   },
	                }
	             );
		}
		
		
	});
	
	</script>

<form action="SignUpReg" method="post">
	<table>
		<tr>
			<td align="center" width="100">id</td>
			<td>
			<input name="id" type="text" id="id" maxlength="8"/>
			</td><td>
			<input type="button" value="중복확인" class="btn"/>
			</td>
		</tr>
		<tr>
			<td align="center">pw</td>
			<td><input name="pw" type="password" maxlength="16" id="pw"/>
			</td><td></td>
			
		</tr>
		<tr>
			<td align="center">이름</td>
			<td><input name="pname" type="text" id="pname"/>
			</td><td></td>
		</tr>
		<tr>
			<td align="center">연락처</td>
			<td>
			<input name="phone" type="text" id="phone1"/>-
			<input name="phone" type="text" id="phone2"/>-
			<input name="phone" type="text" id="phone3"/>
			</td><td>
			<input type="button" value="중복확인" class="btn"/>
			</td>
		</tr>
		<tr>
			<td align="center">주민번호</td>
			<td><input name="birth" type="text" maxlength="6" id="birth"/>
			-
			<input name="gender" type="text" maxlength="1" id="gender"/></td>
		</tr>

		<tr>
			<td align="center">주소</td>
			<td id="address"><select name="country" id="country">
					<option value="한국">한국</option>
					<option value="일본">일본</option>
					<option value="태국">태국</option>
					<option value="중국">중국</option>
					<option value="필리핀">필리핀</option>
			</select> <select name="city" id="city">
					<option value="서울">서울</option>
					<option value="인천">인천</option>

			</select> <input type="text" name="addDetail" id="addDetail" value="상세주소" /></td><td></td>

		</tr>

		<tr>
			<td align="center">Email</td>
			<td>
			<input type="text" name="email" id="email1"/>@
			<input type="text" name="email" id="email2"/>
			</td><td></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><input type="submit" value="가입" />
				<input type="reset" value="초기화" /></td>
		</tr>
	</table>
</form>