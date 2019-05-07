<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
</head>
<body>
<h1>상품 상세</h1>
<form action="AirItem_Detail">
	<table width=100%>	
		<tr>
			<td style="background: #FFFFFF" colspan="8">상품 코드</td>
			<td style="background: #FFFFFF"><input type="text" name="ccode" /></td>
			<td style="background: #FFFFFF" align="center"><input type="submit" value="선택  " /></td>
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