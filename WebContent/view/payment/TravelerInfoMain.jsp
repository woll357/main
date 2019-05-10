<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>

<h1>여행객 정보</h1>
<form name="frm" action="../payment/TravelerInfoReg" method="post">

<c:forEach var="l" items="${basketIDs }" >

<input type="hidden" name="basketIDs" value="${l }"  />

</c:forEach>

<c:choose>
<c:when test="${airBaskets.size()==0 }">
	
	<script>
		frm.submit();
	</script>
</c:when>
</c:choose>

	<c:forEach var="i" items="${airBaskets }" >
		<input type="hidden" name="airBaskets" value="${i.basketID }"  />
				<table width="100%" style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
					<tr>
					<td style="border-bottom: 10px #dcefef solid;">성명(한글)</td>
					<td style="border-bottom: 10px #dcefef solid;">여권번호</td>
					<td style="border-bottom: 10px #dcefef solid;">성(영어)</td>
					<td style="border-bottom: 10px #dcefef solid;">이름(영어)</td>
					<td style="border-bottom: 10px #dcefef solid;">생년월일 6자리</td>
					<td style="border-bottom: 10px #dcefef solid;">연락처</td>
					<td style="border-bottom: 10px #dcefef solid;">이메일</td>
					</tr>
					
					<c:forEach  var="j" begin="1" end="${i.psn }" step="1" >
							<tr>
					<td style="width:75px"><input style="width:98%;" class="cKorName" name="cKorName" type="text" /></td>
					<td style="width:75px"><input style="width:98%;" class="passport" maxlength="8" name="passport" type="text" /></td>
					<td style="width:75px"><input style="width:98%;" class="cEngLastName" name="cEngLastName" type="text" /></td>
					<td style="width:75px"><input style="width:98%;" class="cEngFirstName" name="cEngFirstName" type="text" /></td>
					<td style="width:150px"><input style="width:98%;" class="birthDate" name="birthDate" type="text" maxlength="6" /></td>
					<td style="width:200px"><select style="width:30%;" class="cph1" name="cph1">
					<option value="선택" >선택</option>
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
					</select>-<input style="width:27%;" class="cph2" name="cph2" type="text" maxlength="4" />-<input style="width:27%;" class="cph3" name="cph3" style="width:30px" type="text" maxlength="4" /></td>
					<td style="width:200px"><input class="cemail1" name="cemail1" style="width:85px" type="text" />@
					<input class="cemail2" name="cemail2" style="width:85px" type="text" /></td>		
					</tr>
				</c:forEach>
		</c:forEach>	
	</table>
	<div align="right"><input style="width:75px" type="button" value="제출" onclick="chkPat()" /></div>
</form>
<script>


	var chk = false;
	
	var chk1=false;
	var chk2=false;
	var chk3=false;
	var chk4=false;
	var chk5=false;
	var chk6=false;
	var chk7=false;
	var chk8=false;
	var chk9=false;
	
	var chk10=false;

	var chk11=false;
	
	var msg = "";
	
	var cKorNamePat= /^[가-힣]*$/;
	var passportPat=/^[A-Z]{1}[0-9]*$/;
	var cEngLastNamePat= /^[A-Z]*$/;
	var cEngFirstNamePat= /^[A-Z]*$/;
	var birthDatePat= /^[0-9]*$/;
	var cph2Pat= /^[0-9]*$/;
	var cph3Pat= /^[0-9]*$/;
	var cemail1Pat= /^[a-zA-Z0-9]*$/;
	var cemail2Pat= /(\w+)[.](\w+)$/;
	
	function chkPat(){
		
		$('.cKorName').each(function(i){
			i+$(this).val()+","+$('.passport').eq(i).val()
			
			if(cKorNamePat.test($(this).val())){
				chk1=true;
			}
			else{
				chk1=false;
				alert(""+(i+1)+"번째 고객님의 한글이름이 잘못되었습니다");
				return;
			}
			
			if(passportPat.test($('.passport').eq(i).val())){
				chk2=true;
			}
			else{
				chk2=false;
				alert(""+(i+1)+"번째 고객님의 여권번호가 잘못되었습니다");
				return;
			}
			if(cEngLastNamePat.test($('.cEngLastName').eq(i).val())){
				chk3=true;
			}
			else{
				chk3=false;
				alert(""+(i+1)+"번째 고객님의 영문 성이 잘못되었습니다");
				return;
			}
			if(cEngFirstNamePat.test($('.cEngFirstName').eq(i).val())){
				chk4=true;
			}
			else{
				chk4=false;
				alert(""+(i+1)+"번째 고객님의 영문 이름이 잘못되었습니다");
				return;
			}
			if(birthDatePat.test($('.birthDate').eq(i).val())){
				chk5=true;
			}
			else{
				chk5=false;
				alert(""+(i+1)+"번째 고객님의 생년월일이 잘못되었습니다");
				return;
			}
			if($('.cph1').eq(i).val()=="선택"){
				chk11=false;
				alert(""+(i+1)+"번째 고객님의 핸드폰 첫재짜리가 잘못되었습니다");
				return;
			}
			else{
				chk11=true;
			}
			if(cph2Pat.test($('.cph2').eq(i).val())){
				chk6=true;
			}
			else{
				chk6=false;
				alert(""+(i+1)+"번째 고객님의 핸드폰 둘재짜리가 잘못되었습니다");
				return;
			}
			if(cph3Pat.test($('.cph3').eq(i).val())){
				chk7=true;
			}
			else{
				chk7=false;
				alert(""+(i+1)+"번째 고객님의 핸드폰 셋재짜리가 잘못되었습니다");
				return;
			}
			if(cemail1Pat.test($('.cemail1').eq(i).val())){
				chk8=true;
			}
			else{
				chk8=false;
				alert(""+(i+1)+"번째 고객님의 이메일 앞부분이 잘못되었습니다");
				return;
			}
			if(cemail2Pat.test($('.cemail2').eq(i).val())){
				chk9=true;
			}
			else{
				chk9=false;
				alert(""+(i+1)+"번째 고객님의 이메일 뒷부분이 잘못되었습니다");
				return;
			}		
		});
		
		
		if(chk1 && chk2 && chk3 && chk4 && chk5 && chk6 && chk7 && chk8 && chk9){
			chk=true;
			
			if($('.cph1').val()!="선택"){
				chk10=true;
				alert("결제성공");
				frm.submit();
			}
			else{
				chk10=false;
			}
			
		}
		else{
			chk=false;
		}
	}
	
	
	
	$(document).ready(function(){
		
		$('.cKorName').focusout(function(){
			if(cKorNamePat.test($(this).val())){
				chk1=true;
			}
			else{
				chk1=false;
			}
		})
		
		$('.passport').focusout(function(){
			if(passportPat.test($(this).val())){
				chk2=true;
			}
			else{
				chk2=false;
			}
		})
		
		$('.cEngLastName').focusout(function(){
			if(cEngLastNamePat.test($(this).val())){
				chk3=true;
			}
			else{
				chk3=false;
			}
		})

		$('.cEngFirstName').focusout(function(){
			if(cEngFirstNamePat.test($(this).val())){
				chk4=true;
			}
			else{
				chk4=false;
			}
		})
		
		$('.birthDate').focusout(function(){
			if(birthDatePat.test($(this).val())){
				chk5=true;
			}
			else{
				chk5=false;
			}
		})
		
		$('.cph2').focusout(function(){
			if(cph2Pat.test($(this).val())){
				chk6=true;
			}
			else{
				chk6=false;
			}
		})
		
		$('.cph3').focusout(function(){
			if(cph3Pat.test($(this).val())){
				chk7=true;
			}
			else{
				chk7=false;
			}
		})
		
		$('.cemail1').focusout(function(){
			if(cemail1Pat.test($(this).val())){
				chk8=true;
			}
			else{
				chk8=false;
			}
		})
		
		$('.cemail2').focusout(function(){
			if(cemail2Pat.test($(this).val())){
				chk9=true;
			}
			else{
				chk9=false;
			}
		})
		
		
	})
	
</script>