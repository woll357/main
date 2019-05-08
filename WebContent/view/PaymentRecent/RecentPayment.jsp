<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
if("${msg}"!=""){
	alert("${msg}");
	
	location.href="${goUrl}";
}
</script>
 <table style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
		<tr>
			<td style="width: 120px;border-bottom: 10px #dcefef solid;" >최근 이용 카드</td>
			<td><input id="check" type="checkbox" checked="checked" disabled="disabled" /></td>
		</tr>
		
		<tr>
			<td style="width: 120px;border-bottom: 10px #dcefef solid;">카드선택</td>
			<td><input id="cComName" name="cComName" style="width: 50px" type="text" value="${pdto.cComName }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td style="width: 120px;border-bottom: 10px #dcefef solid;">카드번호</td>
			<td><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cNum1" value="${pdto.cNum1 }"/></td><td style="width: 10px">-</td>
			<td><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cNum2" value="${pdto.cNum2 }"/></td><td style="width: 10px">-</td>
			<td><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cNum3" value="${pdto.cNum3 }"/></td><td style="width: 10px">-</td>
			<td><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cNum4" value="${pdto.cNum4 }"/></td>
		</tr>
		<tr>
			<td style="width: 120px;border-bottom: 10px #dcefef solid;">유효기간</td>
			<td><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="exDateMonth" value="${pdto.exDateMonth }"/></td>
			<td style="width: 10px">/</td>
			<td><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="exDateYear" value="${pdto.exDateYear }"/></td>
		</tr>
		<tr>
			<td style="width: 120px;border-bottom: 10px #dcefef solid;">cvc</td>
			<td style="width: 50px" ><input style="width: 50px" readonly="readonly" type="text" maxlength="4" name="cvc" value="${pdto.cvc }"/></td>
		</tr>
		<tr>
			<td style="width: 120px;border-bottom: 10px #dcefef solid;">카드비밀번호</td>
			<td style="width: 50px"><input style="width: 50px"  type="password" maxlength="2" id="pw" name="pw" /></td><td style="width: 10px">**</td>
		</tr>
		</table>
<script>

	$('#pw').focusout(function(){
		if(pwPat.test($(this).val())){
			chk6=true;
		}
		else{
			chk6=false;
			 alert("유효하지 않은 pw 입니다.");
		}
	})

</script>