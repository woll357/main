<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<form action="Airp_Detail">
<h2>항공편 검색</h2>
<table class="ttcss" border="">
<input type="hidden" name= "aotcont"  value="in"/>
<input type="hidden" value="${air_p }" name="air_p">
		<tr>
			
			<td  align="right"  colspan="7" class="wbbr" style="border-bottom: 3px white solid; " >날짜　<input style="padding: 10px" type="text" name="ddate" /></td>
			<td align="center" class="wbbr" style="border-bottom: 3px white solid; "><input type="submit" style="background: #FFFFFF ;" class="btncss2" value="선택  " /></td>
		</tr>
	<tr>
		<td class="wbbr">상품코드</td>
		<td class="wbbr">비행기코드</td>
		<td class="wbbr">출발시간</td>
		<td class="wbbr">출발지</td>
		<td class="wbbr">도착지</td>
		<td class="wbbr">도착시간</td>
		<td class="wbbr">남은좌석</td>	
		<td class="wbbr">좌석등급</td>
	</tr>
<c:forEach var="dt" items="${dto }" varStatus="no" >
	<tr>
	
	<td style="border-bottom: 10px #dcefef solid;"><a href="AirItem_Detail?ccode=${dt.ccode }&aotcont=in">${dt.ccode }</a></td>	
		<td style="border-bottom: 10px #dcefef solid;">${dt.ap_code }</td>
		<td style="border-bottom: 10px #dcefef solid;">${dt.ddate }</td>
		<td style="border-bottom: 10px #dcefef solid;">${dt.darea }</td>
		<td style="border-bottom: 10px #dcefef solid;">${dt.carea }</td>
		<td style="border-bottom: 10px #dcefef solid;">${dt.a_time }</td>
		<td style="border-bottom: 10px #dcefef solid;">${dt.seatcnt }</td>
		<td style="border-bottom: 10px #dcefef solid;">${dt.flightclass }</td>
	</tr>
 </c:forEach>
  <tr>
		</tr>
	</table> 
</form>
