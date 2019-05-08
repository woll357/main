<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <link rel="stylesheet" href="../css/nh/centerList.css" type="text/css">
<body>

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
		<td>${dto.seatcnt }</td>
		<td>${dto.totseatcnt }</td>
		<td>${dto.flightclass }</td>
		
	</tr>
	
<tr>
<td colspan="10" align="right">
	<a href="AirItem_Modify?ccode=${dto.ccode }&aotcont=in"><input type="button" value="수정"></a>
	<a href=AirItem_Insert?aotcont=in><input type="button" value="등록"></a>
	<a href= "AirItem_Delete?ccode=${dto.ccode }&aotcont=in" ><input type="button" value="삭제"></a>
</td>
</tr>

	</table>

</form>
</body>
</html>