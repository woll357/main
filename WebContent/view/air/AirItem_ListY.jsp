<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지난상품 목록</title>
</head>
<body>
</head>
<body>
<h1>지난상품 목록</h1>
<form action="AirItem_Detail">
	<table border="" >	
		<tr>
			<td colspan="8">상품 코드</td>
			<td><input type="text" name="ccode" /></td>
			<td align="center"><input type="submit" value="선택  " /></td>
		</tr>
	<tr>
		<td width="40">상품코드</td>
		<td width="30">비행기코드</td>
		<td>출발시간</td>
		<td>출발지</td>
		<td>도착지</td>
		<td>가격</td>
		<td>도착시간</td>
		<td width="50" >예약된좌석</td>
		<td width="35">총좌석</td>	
		<td>좌석등급</td>
	</tr>

<c:forEach var="dto" items="${data}" varStatus="no">	
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
	</c:forEach>

	</table>

</form>
</body>
</html>