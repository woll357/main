<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/countryCombo.js"></script>
<link rel="stylesheet" href="../css/nh/signup.css" type="text/css">
<script>

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
					$('#reason').html('<select name="preason" id="preason"><option value=""></option></select>');
				}else{
					$('#black').val("블랙리스트");
					$('#reason').html('<select name="preason" id="preason">'+
							'<option value="강성고객">강성고객</option>'+
							'<option value="경범죄">경범죄</option>'+
							'<option value="중범죄">중범죄</option>'+
							'</select>');
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
			if($('#pw').val()==$('#pw2').val()=='${dto.pw}' && 
					$('#country').val()=='${dto.country}' &&
					$('#city').val()=='${dto.city}' &&
					$('#addDetail').val()=='${dto.addDetail}' &&
					$('#email1').val()=='${dto.email1}' && 
					$('#email2').val()=='${dto.email2}'){
				chk=true;
			}
			console.log(chk);
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


</script>
	
	<div id="back"><div id="in">
	<form action="ModifyMemReg" method="post" name="frm">
	<input type="hidden" value="${dto.id }" name="id"/>
	<table style="width: 100%">
		<tr>
    			<td width="100" class="tt" align="center">ID</td>
    			<td colspan="2" class="tt">${dto.id }</td>
    		</tr>
		<tr>
			<td align="center" class="tt">pw</td>
			<td colspan="2"><input name="pw" type="password" maxlength="16" id="pw" onkeyup="chkPat()" value="${dto.pw }" class="inin"/>
			<div id="pwTag">8 ~ 16자, 특수문자, 한글 제외</div>		
			</td>
		</tr>
		<tr>
			<td align="center" class="tt">pw 확인</td>
			<td colspan="2"><input name="pw2" type="password" maxlength="16" id="pw2" onkeyup="chkPat()" value="${dto.pw }" class="inin"/>
			<div id="pw2Tag">pw와 동일하게 입력</div>
			</td>
			
		</tr>
		<tr>
			<td align="center" class="tt">이름</td>
			<td colspan="2" class="tt">${dto.pname }
			
			</td>
		</tr>
		<tr>
			<td align="center" class="tt">연락처</td>
			<td>
			<input name="phone" type="text" id="phone1"  maxlength="3" onkeyup="butPat()" value="${dto.phone1 }" class="ppin"/> -
			<input name="phone" type="text" id="phone2"  maxlength="4" onkeyup="butPat()" value="${dto.phone2 }" class="ppin"/> -
			<input name="phone" type="text" id="phone3" maxlength="4" onkeyup="butPat()" value="${dto.phone3 }" class="ppin"/>
			<div id="ppTag"></div>
			</td><td>
			<input type="button" value="중복확인" class="btn" id="phoneBtn" disabled="disabled"/>
			</td>
		</tr>
		<tr>
			<td align="center" class="tt">생년월일</td>
			<td colspan="2" class="tt">${dto.birth }
			</td>
			
		</tr>
		<tr>
			<td align="center" class="tt">성별</td>
			<td colspan="2" class="tt">${dto.gender }
			</td>
			
		</tr>

		<tr>
			<td align="center" class="tt">주소</td>
			<td id="address" colspan="2">
			<c:choose>
					<c:when test="${dto.country=='한국' }">
						<select name="country" id="country">
					<option value="한국">한국</option>
					<option value="일본">일본</option>
					<option value="태국">태국</option>
					<option value="중국">중국</option>
					<option value="필리핀">필리핀</option>
			</select>
						<select name="city" id="city">
							<c:choose>
							<c:when test="${dto.city=='서울' }">
							<option value="서울">서울</option>
							<option value="인천">인천</option>
							</c:when>
							
							<c:otherwise>
							<option value="인천">인천</option>
							<option value="서울">서울</option>
							</c:otherwise>
							</c:choose>
							
						</select>
					</c:when>
					<c:when test="${dto.country=='일본' }">
						<select name="country" id="country">
						<option value="일본">일본</option>
					<option value="한국">한국</option>
					
					<option value="태국">태국</option>
					<option value="중국">중국</option>
					<option value="필리핀">필리핀</option>
			</select>
						<select name="city" id="city">
						
							<c:choose>
							<c:when test="${dto.city=='도쿄' }">
							<option value="도쿄">도쿄</option>
							<option value="오사카">오사카</option>
							</c:when>
							
							<c:otherwise>
							<option value="오사카">오사카</option>
							<option value="도쿄">도쿄</option>
							</c:otherwise>
							</c:choose>
						
						
						
							
						</select>
					</c:when>
					<c:when test="${dto.country=='필리핀' }">
						<select name="country" id="country">
						<option value="필리핀">필리핀</option>
					<option value="한국">한국</option>
					<option value="일본">일본</option>
					<option value="태국">태국</option>
					<option value="중국">중국</option>
					
			</select>
						<select name="city" id="city">
						
						<c:choose>
							<c:when test="${dto.city=='마닐라' }">
							<option value="마닐라">마닐라</option>
							<option value="보라카이">보라카이</option>
							</c:when>
							
							<c:otherwise>
							<option value="보라카이">보라카이</option>
							<option value="마닐라">마닐라</option>
							</c:otherwise>
							</c:choose>
						
						</select>
					</c:when>
					<c:when test="${dto.country=='중국' }">
						<select name="country" id="country">
						<option value="중국">중국</option>
					<option value="한국">한국</option>
					<option value="일본">일본</option>
					<option value="태국">태국</option>
					
					<option value="필리핀">필리핀</option>
			</select>
						<select name="city" id="city">
						
						
						
						<c:choose>
							<c:when test="${dto.city=='베이징' }">
							<option value="베이징">베이징</option>
							<option value="상해">상해</option>
							</c:when>
							
							<c:otherwise>
							<option value="상해">상해</option>
							<option value="베이징">베이징</option>
							</c:otherwise>
							</c:choose>
							
							
							
							
						</select>
					</c:when>
					<c:otherwise>
						<select name="country" id="country">
						<option value="태국">태국</option>
					<option value="한국">한국</option>
					<option value="일본">일본</option>
					
					<option value="중국">중국</option>
					<option value="필리핀">필리핀</option>
			</select>
						<select name="city" id="city">
						
						<c:choose>
							<c:when test="${dto.city=='세부' }">
							<option value="세부">세부</option>
							<option value="푸켓">푸켓</option>
							</c:when>
							
							<c:otherwise>
							<option value="푸켓">푸켓</option>
							<option value="세부">세부</option>
							</c:otherwise>
							</c:choose>

						</select>
					</c:otherwise>
					</c:choose>


			 <input type="text" name="addDetail" id="addDetail" value="${dto.addDetail }" onkeyup="chkPat()"/>
			
			</td>

		</tr>

		<tr>
			<td align="center" class="tt">Email</td>
			<td colspan="2">
			<input type="text" name="email" id="email1" onkeyup="chkPat()" value="${dto.email1 }" class="ee"/> @
			<input type="text" name="email" id="email2" onkeyup="chkPat()" value="${dto.email2 }" class="ee"/>
			
			</td>
		</tr>
		<tr>
			<td class="tt" align="center">블랙리스트</td>
			<td colspan="2"><input id="black" readonly="readonly" type="text"
				name="black" value="${dto.black }" class="inin"/></td>
		</tr>
		<tr>
			<td class="tt" align="center">사유</td>
			<td colspan="2" id="reason">
			<select name="preason" id="preason">
					<c:choose>
					<c:when test="${dto.preason=='강성고객'}">
					<option value="강성고객">강성고객</option>
					<option value="경범죄">경범죄</option>
					<option value="중범죄">중범죄</option>
					</c:when>
					<c:when test="${dto.preason=='경범죄'}">
					<option value="경범죄">경범죄</option>
					<option value="강성고객">강성고객</option>
					<option value="중범죄">중범죄</option>
					</c:when>
					<c:when test="${dto.preason=='중범죄'}">
					<option value="중범죄">중범죄</option>
					<option value="경범죄">경범죄</option>
					<option value="강성고객">강성고객</option>
					
					</c:when>
					<c:otherwise>
					<option value=""></option>
					<option value="강성고객">강성고객</option>
					<option value="경범죄">경범죄</option>
					<option value="중범죄">중범죄</option>
					</c:otherwise>
					</c:choose>
					
			</select>
			
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
			<input type="button" value="수정" id="subBtn"/>
			<input type="button" value="블랙리스트 추가하기" id="blackBtn" />
				<input type="reset" value="초기화" /></td>
		</tr>
	</table>
</form>
	
		</div></div>
	
	
   