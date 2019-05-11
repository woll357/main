<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" href="../css/nh/tot.css" />

<form action="../greensc/Home">
<h2>방금 결제하신 상품</h2>
	<table class="ttcss" border="" >
		<tr>
			<td class="wbbr">항공사명</td>
			<td class="wbbr">비행기코드</td>
			<td class="wbbr">출발날짜</td>
			<td class="wbbr">도착날짜</td>
			<td class="wbbr">출발도시</td>
			<td class="wbbr">도착도시</td>
			<td class="wbbr">예약인원</td>
			<td class="wbbr">금액</td>
		</tr>
		<c:forEach var="adto" items="${adtos }"   >
		<tr>
			<td>${adto.cName }</td>
			<td>${adto.itemName }</td>
			<td>${adto.ddateStr }</td>
			<td>${adto.fdateStr }</td>
			<td>${adto.location1 }</td>
			<td>${adto.location2 }</td>
			<td>${adto.psn }</td>
			<td>${adto.totalPrice }</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<table class="ttcss" border="">
		<tr>
			<td class="wbbr">호텔이름</td>
			<td class="wbbr">방이름</td>
			<td class="wbbr">체크인날짜</td>
			<td class="wbbr">체크아웃날짜</td>
			<td class="wbbr">국가명</td>
			<td class="wbbr">도시명</td>
			<td class="wbbr">방인원</td>
			<td class="wbbr">금액</td>
		</tr>
		
		<c:forEach var="hdto" items="${hdtos }" >
		<tr>
			<td>${hdto.cName }</td>
			<c:choose>
			<c:when test="${hdto.itemName=='S' }">
			<td>스탠다드</td>
			</c:when>
			<c:when test="${hdto.itemName=='D' }">
			<td>디럭스</td>
			</c:when>
			</c:choose>
			<td>${hdto.ddateStr }</td>
			<td>${hdto.fdateStr }</td>
			<td>${hdto.location1 }</td>
			<td>${hdto.location2 }</td>
			<td>${hdto.psn }</td>
			<td>${hdto.totalPrice }</td>
		</tr>
		</c:forEach>
	</table>
	<div align="right">
	<table style="border: 10px #dcefef solid; border-collapse: collapse;" >
	<tr>
	<td class="wbbr" >총액</td>
	
	<td>${totalPrice }</td>
	<td><input class="btncss" type="submit" value="확인" /></td>
	</tr>
	</table>
	</div>
</form>