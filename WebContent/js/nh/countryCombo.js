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
})