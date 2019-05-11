<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>비행기 상품 목록</h2>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<form action="Airplaneitem_Modify">
<input type="hidden" value="${param.ap_code }" name="ap_code" /> 			
<table border="" class="ttcss">

		<tr>
			<td align="right" class="wbbr" colspan="9" style="border-bottom: 3px white solid;" >상품 코드　<input style="padding: 10px" type="text" name="ddate" /></td>
			<td  class="wbbr" style="border-bottom: 3px white solid;" align="center"><input type="submit" value="선택  " style="background: #FFFFFF ;" class="btncss2" /></td>
		</tr>
	<tr>
		<td class="wbbr">상품코드</td>
		<td class="wbbr" width="60">비행기코드</td>
		<td class="wbbr">출발시간</td>
		<td class="wbbr">출발지</td>
		<td class="wbbr">도착지</td>
		<td class="wbbr">가격</td>
		<td class="wbbr">도착시간</td>
		<td class="wbbr" width="60">예약된좌석</td>
		<td class="wbbr">총좌석</td>	
		<td class="wbbr">좌석등급</td>
	</tr>
<c:forEach var="dto" items="${data}" varStatus="no">	

	<tr>
	
	<td><a href="AirItem_Detail?ccode=${dto.ccode }&aotcont=in">${dto.ccode }</a></td>	
	
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
