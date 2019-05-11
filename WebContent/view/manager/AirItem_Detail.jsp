<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<body>
<h2>상품 상세</h2>
<form action="AirItem_Detail">
	<input type="hidden" name= "partner"  value="in"/>
<table border=""class="ttcss">
		<tr>
			
			<td align="right" colspan="9" class="wbbr" style="border-bottom: 3px white solid;">상품 코드　<input style="padding: 10px" type="text" name="ccode" /></td>
			<td  align="center"  class="wbbr" style="border-bottom: 3px white solid;"><input style="background: #FFFFFF ;" class="btncss2" type="submit" value="선택  " /></td>
		</tr>
	<tr>
		<td class="wbbr">상품코드</td>
		<td class="wbbr"width="50">비행기코드</td>
		<td class="wbbr">출발시간</td>
		<td class="wbbr">출발지</td>
		<td class="wbbr">도착지</td>
		<td class="wbbr">가격</td>
		<td class="wbbr">도착시간</td>
		<td class="wbbr">예약된좌석</td>
		<td class="wbbr">총좌석</td>	
		<td class="wbbr">좌석등급</td>
	</tr>

	<tr>
	
	<td>${dto.ccode }</td>	
		<td>${dto.ap_code }</td>
		<td>${dto.ddate }</td>
		<td>${dto.darea }</td>
		<td>${dto.carea }</td>
		<td>${dto.money }</td>
		<td>${dto.a_time }</td>
		<td>${dto.seatcnt }</td>
		<td>${dto.totseatcnt }</td>
		<td>${dto.flightclass }</td>
		
	</tr>
	
<tr>
<td colspan="10" align="right">
	<a href= "AirItem_Delete?ccode=${dto.ccode }" ><input  class="btncss" type="button" style="background-color: #dcefef;"  value="삭제"></a>
</td>
</tr>

	</table>

</form>
</body>
</html>