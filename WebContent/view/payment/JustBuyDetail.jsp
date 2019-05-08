<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>

<form action="../greensc/Home">
	<table style="text-align: center; border: 10px #dcefef solid;" cellspacing="0" >
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">항공사명</td>
			<td style="border-bottom: 10px #dcefef solid;">비행기코드</td>
			<td style="border-bottom: 10px #dcefef solid;">출발날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">도착날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">출발도시</td>
			<td style="border-bottom: 10px #dcefef solid;">도착도시</td>
			<td style="border-bottom: 10px #dcefef solid;">예약인원</td>
			<td style="border-bottom: 10px #dcefef solid;">금액</td>
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
	<table style="text-align: center; border: 10px #dcefef solid;" cellspacing="0"">
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">호텔이름</td>
			<td style="border-bottom: 10px #dcefef solid;">방이름</td>
			<td style="border-bottom: 10px #dcefef solid;">체크인날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">체크아웃날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">국가명</td>
			<td style="border-bottom: 10px #dcefef solid;">도시명</td>
			<td style="border-bottom: 10px #dcefef solid;">방인원</td>
			<td style="border-bottom: 10px #dcefef solid;">금액</td>
		</tr>
		
		<c:forEach var="hdto" items="${hdtos }" >
		<tr>
			<td>${hdto.cName }</td>
			<td>${hdto.itemName }</td>
			<td>${hdto.ddateStr }</td>
			<td>${hdto.fdateStr }</td>
			<td>${hdto.location1 }</td>
			<td>${hdto.location2 }</td>
			<td>${hdto.psn }</td>
			<td>${hdto.totalPrice }</td>
		</tr>
		</c:forEach>
	</table>
	<table style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
	<tr>
	<td style="border-bottom: 10px #dcefef solid;">총액</td>
	<td>${totalPrice }</td>
	<td><input type="submit" value="확인" /></td>
	</tr>
	</table>
</form>