<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<script>
function TravelerInfoDetail(id){
	
	location.href="TravelerInfoDetail?basketID="+id+"&mypage=in";
		
}
</script>
	<table border="" >
		<tr>
			<td>항공사명</td>
			<td>비행기코드</td>
			<td>출발날짜</td>
			<td>도착날짜</td>
			<td>출발도시</td>
			<td>도착도시</td>
			<td>예약인원</td>
			<td>여행객정보</td>
			<td>환불</td>
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
			<td><button onclick="TravelerInfoDetail('${adto.basketID}')" >여행객 상세 정보</button></td>
			<td>
			<form action="RefundReg">
			<input type="submit" value="환불" />
			<input type="hidden" name="basketID" value="${adto.basketID }" /></form>
			</td>
		</tr>
		</c:forEach>
	</table>
	<table border="">
		<tr>
			<td>호텔이름</td>
			<td>방이름</td>
			<td>체크인날짜</td>
			<td>체크아웃날짜</td>
			<td>국가명</td>
			<td>도시명</td>
			<td>방인원</td>
			<td>환불</td>
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
			
			<td>
			<form action="RefundReg">
			<input type="submit" value="환불" />
			<input type="hidden" name="basketID" value="${hdto.basketID }" /></form>
			</td>

		</tr>
		</c:forEach>
	</table>