<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
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
<table border="" class="ttcss">
		<tr>

			<td align="right" colspan="9" class="wbbr" style="border-bottom: 3px white solid;">상품 코드　　<input type="text" style="padding: 10px" type="text" name="ccode" /></td>
			<td  class="wbbr" style="border-bottom: 3px white solid;" align="center"><input type="submit" value="선택  "  style="background: #FFFFFF ;" class="btncss2"/></td>
		</tr>
	<tr>
		<td  class="wbbr">상품코드</td>
		<td  class="wbbr">비행기코드</td>
		<td  class="wbbr">출발시간</td>
		<td  class="wbbr">출발지</td>
		<td  class="wbbr">도착지</td>
		<td  class="wbbr">가격</td>
		<td  class="wbbr">도착시간</td>
		<td  class="wbbr">예약된좌석</td>
		<td  class="wbbr">총좌석</td>	
		<td  class="wbbr">좌석등급</td>
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
	<a href="AirItem_Modify?ccode=${dto.ccode }&aotcont=in"><input style="background-color: #dcefef; font-size: 20px; color: #779191;" class="acb" type="button" value="수정"  ></a>
	<a href=AirItem_Insert?aotcont=in><input  type="button" class="btncss"  value="등록"></a>
	<a href= "AirItem_Delete?ccode=${dto.ccode }&aotcont=in" ><input class="btncss"  type="button" value="삭제"></a>

</td>
</tr>

	</table>

</form>
