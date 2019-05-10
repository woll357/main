<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <link rel="stylesheet" href="../css/nh/centerList.css" type="text/css">
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<script>
/* $(document).ready(function(){
	$('.acb').on({
		'click':function() {
		
			
			
			
			if($('.seatcnt').val()>0 ) {
				console.log($('.seatcnt').val());
				alert("파일은 선택해주세요.");
				
				
			}		
     	
		}
		
	})
	
}) ; */

/* <a href="#" onclick="delchk();">삭제하기</a>

<script type="text/javascript">
function delchk(){
    if(confirm("삭제하시겠습니까?")){
        location.href = "write_del_ok.jsp?num=1";
        return true;
    } else {
        return false;
    }
} */


</script>
<h2>상품 상세</h2>
<form action="AirItem_Detail">
	<input type="hidden" name= "aotcont"  value="in"/>
<table border="" style="width: 100%; border : 10px #dcefef solid;" cellspacing="0">
		<tr>
			<td colspan="8" style="background: #D4F4FA">상품 코드</td>
			<td style="background: #D4F4FA"><input type="text" name="ccode" /></td>
			<td align="center" style="background: #D4F4FA"><input type="submit" value="선택  " /></td>
		</tr>
	<tr>
		<td>상품코드</td>
		<td>비행기코드</td>
		<td>출발시간</td>
		<td>출발지</td>
		<td>도착지</td>
		<td>가격</td>
		<td>도착시간</td>
		<td>예약된좌석</td>
		<td>총좌석</td>	
		<td>좌석등급</td>
	</tr>

	<tr>
	
	<td>${dto.ccode }</td>	
		<td>${dto.ap_code }</td>
		<td>${dto.ddate }</td>
		<td>${dto.darea }</td>
		<td>${dto.carea }</td>
		<td>${dto.money }</td>
		<td>${dto.a_time }</td>
		<td class="seatcnt">${dto.seatcnt }</td>
		<td>${dto.totseatcnt }</td>
		<td>${dto.flightclass }</td>
		
	</tr>
	
<tr>
<td colspan="10" align="right">
	<a onclick="showHide()" class="acccc" href="AirItem_Modify?ccode=${dto.ccode }&aotcont=in"><input class="acb" type="button" value="수정"  ></a>
	<a href=AirItem_Insert?aotcont=in><input type="button" value="등록"></a>
	<a href= "AirItem_Delete?ccode=${dto.ccode }&aotcont=in" ><input type="button" value="삭제"></a>
</td>
</tr>

	</table>

</form>
