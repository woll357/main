<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공편 하나에 전체 상품</title>
</head>
<body>
<form action="Airp_Detail">
	<table border="" >	
		<tr>
			<td colspan="4">항공편 코드</td>
			<td><input type="text" name="air_p" /></td>
			<td>날짜</td>
			<td><input type="text" name="ddate" /></td>
			<td align="center"><input type="submit" value="선택  " /></td>
		</tr>
	<tr>
		<td>상품코드</td>
		<td>비행기코드</td>
		<td>출발시간</td>
		<td>출발지</td>
		<td>도착지</td>
		<td>도착시간</td>
		<td>남은좌석</td>	
		<td>좌석등급</td>
	</tr>
<c:forEach var="dt" items="${dto }" varStatus="no" >
	<tr>
	<td><a href="AirItem_Modify?ccode=${dt.ccode }">${dt.ccode }</a></td>	
		<td>${dt.ap_code }</td>
		<td>${dt.ddate }</td>
		<td>${dt.darea }</td>
		<td>${dt.carea }</td>
		<td>${dt.a_time }</td>
		<td>${dt.seatcnt }</td>
		<td>${dt.flightclass }</td>
	</tr>
 </c:forEach>
</table>
</form>
</body>
</html>