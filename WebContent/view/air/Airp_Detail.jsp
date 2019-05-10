<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<form action="Airp_Detail">
<h2 >항공편 검색</h2>
<table border="" style="width: 100%; border : 10px #dcefef solid;" cellspacing="0">
<input type="hidden" name= "aotcont"  value="in"/>
<input type="hidden" value="${air_p }" name="air_p">
		<tr>
			<td style="background: #D4F4FA" colspan="6">날짜</td>
			<td style="background: #D4F4FA"><input type="text" name="ddate" /></td>
			<td style="background: #D4F4FA" align="center"><input type="submit" value="선택  " /></td>
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
	
	<td><a href="AirItem_Detail?ccode=${dt.ccode }&aotcont=in">${dt.ccode }</a></td>	
		<td>${dt.ap_code }</td>
		<td>${dt.ddate }</td>
		<td>${dt.darea }</td>
		<td>${dt.carea }</td>
		<td>${dt.a_time }</td>
		<td>${dt.seatcnt }</td>
		<td>${dt.flightclass }</td>
	</tr>
 </c:forEach>
  <tr>
		</tr>
	</table> 
</form>
