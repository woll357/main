<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	
	function maxLengthCheck(object) {
		if (object.value.length > object.maxLength) {
			object.value = object.value.slice(0, object.maxLength);
		}
	}
	
	$(document).ready(function(){
		$('.nores').on({
			'click':function() {
				if($('#rs').val()=='' || $('#norescnt').val()=='') {
					alert("기입이 완료되지않았습니다.")
					nono.button();
				}
				
				
				if($('#norescnt').val()<0 || $('#hiddenrcnt').val()<$('#norescnt').val()) {
					alert("값이 잘못 입력되었습니다.")
				}
				else {
					nono.submit();
				}
			}
		})
	})


</script>
	<input type="hidden" name="rcnt" value="${param.rcnt }" id="hiddenrcnt" />
<form name="nono" action="HnoresDatewriteReg" method="post">
     <input type="hidden" name="rcode" value="${param.rcode }" />
     
     <table border="">
     	<tr>
     		<td>날짜선택</td>
     		<td><input type="date" name="noresdate"/></td>
     	</tr>
     	<tr>
     		<td>예약불가갯수</td>
     		<td><input type="number" maxlength="2" oninput="maxLengthCheck(this)"  name="norescnt" value="${dto.rcnt }" id="norescnt"/> </td>
     	</tr>
     	<tr>
     		<td>사유</td>
     		<td><input type="text" name="reason" id="rs"/></td>
     	</tr>
		<tr>
			<td colspan="2" align="right">
			<input type="button" value="작성" class="nores"/>
			<input type="reset" value="초기화" />
			</td>
		</tr>
     </table>
</form>    